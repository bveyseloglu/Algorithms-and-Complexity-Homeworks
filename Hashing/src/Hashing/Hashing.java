/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author veyseloglu
 */
public class Hashing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hashing\nWritten by Bahaddin Veyseloglu");
        
        // *** get the file location from user
        boolean fileInputNotAccepted = true; // true yap bunu
        File f;
        String fileLocation = "";
        
        while (fileInputNotAccepted)
        {
            if (fileLocation.equals(""))
            {
                fileLocation = "";

                System.out.println("\n[»] Please enter the location of your text file: ");
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
        
        // *** build the hash table
        
        cHash hash = new cHash(fileLocation, 512);
        
        // *** show menu
        
        while(true)
        {
            System.out.println("\n== PROGRAM MENU ==\n[1] Write hash table into the file. (Display)\n[2] Sort words and write into a text file. (Sort)\n[3] Check number of word. (NumofWord)\n[4] Show the most repeated word. (ShowMax)\n[5] Check a word in text. (CheckWord)");
            System.out.println("\n[»] Please enter your choice then press <enter>: "); 

            Scanner userRead = new Scanner(System.in);
            String userInput = userRead.nextLine();

            if (userInput.equals("1")) {
                System.out.println("\n[»] Please enter the location of output text file: ");
                hash.Display(new Scanner(System.in).nextLine());
            }
            else if (userInput.equals("2")){
                System.out.println("\n[»] Please enter the location of output text file: ");
                hash.Sort(new Scanner(System.in).nextLine());
            }
            else if (userInput.equals("3")) {
                System.out.println("\n[»] Please enter the word that you want to check: ");
                System.out.println("[»] Result: " + hash.NumofWord(new Scanner(System.in).nextLine()));
            }
            else if (userInput.equals("4")) {
                System.out.println("[»] Result: " + hash.ShowMax());
            }
            else if (userInput.equals("5")) {
                System.out.println("\n[»] Please enter the word that you want to check: ");
                System.out.println("[»] Result: " + hash.CheckWord(new Scanner(System.in).nextLine()));   
            }
            else {
                System.out.println("\n[!] Please check your input."); 
            }
            
            System.out.println("\n[i] Task performed. Press any key to return to the program menu.");
            Scanner userRead2 = new Scanner(System.in);
            userRead2.nextLine();
        }
        
    }
    
}
