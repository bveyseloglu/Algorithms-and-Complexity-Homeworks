/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReadingAndSorting;

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
public class FileReadingAndSorting {

    static List<String> lines;
    static String dbFileLocation = null;
    static StudentdBase dbstd;
    static String userInput;
    static boolean firstUse = true;
    
    public static void main(String[] args) {
        System.out.println("File Reading and Sorting Example\nWritten by Bahaddin Veyseloglu");
        
        dbFileLocation = getFileInput(""); // ask user to input the txt file's location.
        readTextFile(); // read the txt file
        loadDB(); // load db
        
        while (true) // show menu
        {
            getUserInput();
            
            if (userInput.equals("1")) {
                System.out.println("\n[i] Student list is shown below.");
                dbstd.printAllStudents();
            }
            else if (userInput.equals("3")) {
                dbstd.sort_ID();
                System.out.println("[i] Sorted by ID. You can list students to view the new order.");
            }
            else if (userInput.equals("4")) {
                dbstd.sort_Age();
                System.out.println("[i] Sorted by age. You can list students to view the new order.");
            }
            else if (userInput.equals("5")) {
                dbstd.sort_Year();
                System.out.println("[i] Sorted by year. You can list students to view the new order.");
            }
            else if (userInput.equals("6")) {
                firstUse = true;
                dbFileLocation = getFileInput(dbFileLocation);
                readTextFile();
                loadDB();
            }
            else if (userInput.equals("7")) {
                firstUse = true;
                dbFileLocation = getFileInput("");
                readTextFile();
                loadDB();
            }
            else if (userInput.equals("8")) {
                updateDatabaseFile();
            }
            else if (userInput.equals("2")) {
                System.out.println("\n[i] Student list is shown below.");
                dbstd.printAllStudents();
                
                dbstd.sort_ID();
                System.out.println("\n[i] Student list that sorted by ID is shown below.");
                dbstd.printAllStudents();
                
                dbstd.sort_Age();
                System.out.println("\n[i] Student list that sorted by age is shown below.");
                dbstd.printAllStudents();
                
                dbstd.sort_Year();
                System.out.println("\n[i] Student list that sorted by year is shown below.");
                dbstd.printAllStudents();
            }
            else {
                System.out.println("[!] There is no choice like \"" + userInput + "\". Please enter a valid choice index.");
            }
        }
    }
    
    static void getUserInput()
    {   
        Scanner userRead = new Scanner(System.in);
                
        if (!firstUse) {
            System.out.println("\n[i] Press <ENTER> to return to the menu...");
            userRead.nextLine();
        }
        
        firstUse = false;
        
        System.out.println("\n== PROGRAM MENU ==\n[1] Print all of the students\n[2] Do all types of sorting then print each of their result\n[3] Sort students by ID\n[4] Sort students by age\n[5] Sort students by year\n[6] Reload database from " + dbFileLocation + "\n[7] Reload database from another file\n[8] Update datebase file");
        System.out.println("\n[>>] Please enter your choice then press <ENTER>: ");
            
        userInput = userRead.nextLine();
    }
    
    static String getFileInput(String fromFile)
    {
        boolean fileInputNotAccepted = true;
        File f;
        String fileLocation = fromFile;
        
        while (fileInputNotAccepted)
        {
            if (fromFile == "")
            {
                fileLocation = "";

                System.out.println("\n[>>] Please enter the location of your database file: ");
                Scanner userRead = new Scanner(System.in);
                fileLocation = userRead.nextLine();
            }

            f = new File(fileLocation);
            if(f.exists() && !f.isDirectory()) { 
                fileInputNotAccepted = false;
            }
            else {
                System.out.println("[!] Incorrect input.");
            }
        }
        
        return fileLocation;
    }
    
    static void readTextFile()
    {
        BufferedReader reader;
               
        lines = new ArrayList<>();
        
        try
        {
            reader = new BufferedReader(new FileReader(dbFileLocation));
            
            String line =  reader.readLine();
            while(line != null) {
                lines.add(line);
                line =  reader.readLine();
            }
            reader.close();
            
            System.out.println("[i] File read successfully.");
        }
        catch (Exception ex)
        {
            System.out.println("[!] Something went wrong: " + ex.getMessage());
            dbFileLocation = getFileInput("");
            readTextFile();
            loadDB();
        }
    }
    
    static void printTheContentsReadFromFile()
    {
        for (int i=0; i<lines.size();i++)
           System.out.println(lines.get(i));
    }
    
    static void loadDB()
    {
        try
        {
            if (lines.size() != Integer.parseInt(lines.get(0)) +1) {
                System.out.println("[!] Something's wrong with your file. The program may not work as intended.");
            }
            
            dbstd = new StudentdBase(Integer.parseInt(lines.get(0)));
            for (int i=1; i < lines.size();i++) {
                String str = lines.get(i);

                String[] splitStr = str.trim().split("\\s+");

                Student std = new Student();
                std.setStudentInfo(Integer.parseInt(splitStr[3]), Long.parseLong(splitStr[0]), Integer.parseInt(splitStr[4]),splitStr[1], splitStr[2]);

                dbstd.StudentArray[i-1] = std;
            }

            System.out.println("[i] "+ dbstd.getStudentCount() + " students loaded from the database file successfully.");
        }
        catch (Exception ex)
        {
            System.out.println("[!] Please enter a valid file.");
            dbFileLocation = getFileInput("");
            readTextFile();
            loadDB();
        }
    }
    
    static void updateDatabaseFile()
    {
        Scanner userRead = new Scanner(System.in);
        System.out.println("\n[?] Are you sure you want to replace your database file? [y/n]");
        String userCh = userRead.nextLine();
                
        if (userCh.equals("y")) {
            if (dbstd.updateDBFile(dbFileLocation)) {
                System.out.println("[i] Database file updated.");
            }
            else {
                System.out.println("[!] Something went wront. The application may not have admin privileges.");
            }
        }
        else {
            System.out.println("[i] Canceled.");
        }
    }
    
}
