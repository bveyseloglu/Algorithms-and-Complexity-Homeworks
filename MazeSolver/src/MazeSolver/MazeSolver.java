/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeSolver;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author veyseloglu 
 */
public class MazeSolver {

    String fileLocation = "";        
            
    public static void main(String[] args) {
        // TODO code application logic here
       
        System.out.println("Maze Solver\nWritten by Bahaddin Veyseloglu");
        
        boolean temp = true;
        
        while (temp) {
            Maze maze = new Maze();
            maze.ReadMazeFromFile();
            maze.SolveMaze();
            maze.PrintSolution();
            
            System.out.println("[i] The program has finished.\n\n[»] Do you want to solve a new maze? Type 'y' then press enter if you want, simply press <enter> to exit the application.");
            Scanner userRead2 = new Scanner(System.in);
            String in = userRead2.nextLine();
            if (!in.toLowerCase().equals("y") && !in.toLowerCase().equals("'y'")) return;
        }
    }

    
}
