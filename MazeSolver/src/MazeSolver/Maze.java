/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeSolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author veyseloglu
 */
public class Maze implements MazeClass {

    public String fileLocation = "";// = "C:\\m.txt"; 
    public int [][] MazeContent;
    public int [][] MazeSolution;
    public int [][] MazeRollBack;
    public Stack MazeStack;
    int rowCount, columnCount;
    boolean PrintAttempts = false;
    int EndPointValue;
            
    @Override
    public void ReadMazeFromFile() {
        // get user input
        askForFileLocation();
        
        // parse maze to an array
        if (readFile() == false) return;
    }

    private void askForFileLocation()
    {        
        boolean fileInputNotAccepted = true;
        File f;
        String fileLocation = "";
        
        while (fileInputNotAccepted)
        {
            if (fileLocation.equals(""))
            {
                fileLocation = "";

                System.out.println("\n[»] Please enter the location of your maze description file, which should have UTF-8 encoding: ");
                Scanner userRead = new Scanner(System.in);
                fileLocation = userRead.nextLine();
            }

            f = new File(fileLocation);
            if(f.exists() && !f.isDirectory()) { 
                fileInputNotAccepted = false;
            }
            else {
                System.out.println("[!] Incorrect input.");
                fileLocation = "";
            }
        }
        
        this.fileLocation = fileLocation;
        
        // get the last maze value
        boolean waitCorrectInput = true;
        
        while(waitCorrectInput) {
            try {
                System.out.println("\n[»] Please enter the last value that desired to be located on the end of the maze path (it is '32' in the maze given in the homework): ");
                Scanner userRead = new Scanner(System.in);
                EndPointValue = userRead.nextInt();
                if (EndPointValue <= 1) System.out.println("[!] The value must greater than 1.");
                else waitCorrectInput=false;
            }
            catch (Exception ex) {
                System.out.println("[!] Incorrect input.");
            }
        
        }
        
        // get the user preference (edit: i think its not necessary to ask.)
        PrintAttempts = true;
        
        /*boolean waitCorrectInput2 = true;
        
        while(waitCorrectInput2) {
            try {
                System.out.println("\n[»] Do you want to print all of the attempts that the algoritm take?\n    Type 'y' to print each action of the algorithm while solving the maze.\n    Simply press <enter> to print only the solution of the maze.");
                Scanner userRead2 = new Scanner(System.in);
                String in = userRead2.nextLine();
                if (in.toLowerCase().equals("y") || in.toLowerCase().equals("'y'")) PrintAttempts = true;
                waitCorrectInput2 = false;
            }
            catch (Exception ex) {
                System.out.println("[!] Incorrect input.");
            }
        }*/
    }
    
    private boolean readFile()
    {

        List<String> lines;
        
        // *** read lines of txt file and insert them to the 'lines' list
        BufferedReader reader;
        lines = new ArrayList<>();
        
        columnCount = rowCount = 0;
        
        try
        {
            reader = new BufferedReader(new FileReader(fileLocation));
            
            String line =  reader.readLine();
            while(line != null) {
                rowCount++; // count the rows
                lines.add(line);
                line =  reader.readLine();
            }
            reader.close();
            
            System.out.println("\n[i] Maze description file read successfully.");
        }
        catch (Exception ex)
        {
            System.out.println("\n[!] Something went wrong while reading the maze description file: " + ex.getMessage());
            return false; // return if any error occurs
        }
        
        // *** construct the array
        // first, get the colums count:
        String temp = lines.get(0);
        String[] temp2 = temp.trim().split("\\s+");
        columnCount = temp2.length;
        System.out.println("    Row Count: " + rowCount + "\n    Column Count: " + columnCount + "\n");
        
        // initialize
        MazeContent = new int[rowCount+2][columnCount+2];
        MazeSolution = new int[rowCount+2][columnCount+2];
        MazeRollBack = new int[rowCount+2][columnCount+2];
        MazeStack = new Stack(rowCount, columnCount);
        
        // populate the array
        for (int i=1; i < lines.size()+1;i++) {
            String str = lines.get(i-1);

            String[] splitStr = str.trim().split("\\s+");
            
            for (int ii = 1; ii < columnCount+1; ii++){
                MazeContent[i][ii] = Integer.parseInt(splitStr[ii-1]);
            }

        }
        
        return true;
    }
    
    @Override
    public void SolveMaze() {
        if (PrintAttempts) System.out.println("[i] The steps taken by the algorithm were printed below.");
        for (int i=1; i < rowCount+1;i++) {
            for (int ii = 1; ii < columnCount+1; ii++){
                if (MazeContent[i][ii] == 1) {
                    
                    boolean nextAvailable = false;
                    for (int a = -1; a<= 1; a++){
                        for (int aa = -1; aa <= 1; aa++) {
                            if (MazeContent[i+a][ii+aa] == 2)
                                nextAvailable = true;
                        }
                    }
                    if (nextAvailable) {
                        if (PrintAttempts) System.out.println("    -- Started from " +  i +":" + ii);
                        if (proceedPoint(i,ii) == true) return;
                    }
                    else if (PrintAttempts) System.out.println("    -- The algoritm stated that the " +  i +":" + ii + " is not a proper starting point.");
                }
            }
        }
    }

    private boolean proceedPoint(int X, int Y)
    {
        if (MazeContent[X][Y] == 1) {
            boolean nextAvailable = false;
            for (int i = -1; i<= 1;i++){
                for (int ii = -1; ii <= 1; ii++) {
                    if (MazeContent[X+i][Y+ii] == 2)
                        nextAvailable = true;
                }
            }
            if (!nextAvailable) return false;
        }
        
        
        if (MazeContent[X][Y] == -1){
            if (PrintAttempts) System.out.println("    -- Returned back to the starting point.");
            return false;
        }
        else if (MazeContent[X][Y] == EndPointValue){
            MazeStack.push(X, Y);
            return true;
        }

        for (int i = -1; i<= 1;i++){
            for (int ii = -1; ii <= 1; ii++) {
                if (MazeContent[X+i][Y+ii] == MazeContent[X][Y] + 1 && MazeRollBack[X+i][Y+ii] != 1){
                     
                    if (MazeContent[X][Y] == 1) MazeContent[X][Y] = -1;
                      
                    MazeStack.push(X, Y);
                    if (PrintAttempts) System.out.println("    Proceeding to " +  (X+i) +":" + (Y+ii) + " (Value: " + MazeContent[X+i][Y+ii] + ")");
                    return proceedPoint(X+i, Y+ii);
                }
            }
        }
           
        MazeRollBack[X][Y] = 1;
        if (PrintAttempts) System.out.println("    Rolled back from " +  X +":" + Y);
        return proceedPoint(MazeStack.peekX(), MazeStack.peekY(true));

    }
    
    @Override
    public void PrintSolution() {
        
        if (MazeStack.stackLastElementIndex == -1) {
            System.out.println("\n[i] There is no solution of the maze for the given condition. The maze may not contain the desired ending point, which is " + EndPointValue + " or format or the encoding of the input file may invalid.");
            return;
        }
        
        if (PrintAttempts) System.out.println("\n[i] The Solution of the maze is:");
        else System.out.println("[i] The Solution of the maze is:");
        
        for (int i = 0; i <= MazeStack.stackLastElementIndex; i++)
        {
            if (i == MazeStack.stackLastElementIndex )
                System.out.print((MazeStack.StackX[i] ) + ":" +  (MazeStack.StackY[i]) + "\n\n" );
            else
                System.out.print((MazeStack.StackX[i] ) + ":" +  (MazeStack.StackY[i]) + " » ");
        
        }

    }
    
}
