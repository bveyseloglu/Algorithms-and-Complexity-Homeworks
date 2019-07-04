/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleDatabaseApplication;

import java.util.Scanner;

/**
 *
 * @author veyseloglu
 */
public class SimpleDatabaseApplication {

    /**
     * @param args the command line arguments
     */
    
    public static Inventory InventoryOne = new Inventory();
    
    public static void main(String[] args) {
        
        /* YOU CAN EDIT HERE TO MANIPULATE THE INVENTORY MANUALLY */
        
        /*InventoryOne.addResistor("10k", 10);
        InventoryOne.addCapacitor("5 uF","Type A", 10);
        InventoryOne.addInductor("12 mH", 10);
        InventoryOne.addTransistor("BJT", 10);

        InventoryOne.deleteResistor("10k", 1);
        InventoryOne.deleteCapacitor("5 uF","Type A", 1);
        InventoryOne.deleteInductor("12 mH", 1);
        InventoryOne.deleteTransistor("BJT", 1);
        
        InventoryOne.printInventory();
        System.out.println("\n***\n");*/
        
        System.out.println("Simple Database Application\nWritten by Bahaddin Veyseloglu");
        
        while(true)
        {
            showMenu();
        }
    }
    
    private static void showMenu()
    {
        System.out.println("\n== PROGRAM MENU ==\n[1] Add/Remove Resistors (val, cnt)\n[2] Add/Remove Capacitors (val, typ, cnt)\n[3] Add/Remove Inductors (val, cnt)\n[4] Add/Remove Transistors (typ, cnt)\n[5] Print all inventory");
        System.out.println("\n[>>] Please enter your choice then press <enter>: "); 
        
        Scanner userRead = new Scanner(System.in);
        String userInput = userRead.nextLine();
        
        if (userInput.equals("1"))
            userAddRemoveResistor();
        else if (userInput.equals("2"))
            userAddRemoveCapacitor();
        else if (userInput.equals("3"))
            userAddRemoveInductor();
        else if (userInput.equals("4"))
            userAddRemoveTransistor();
        else if (userInput.equals("5"))
            InventoryOne.printInventory();
        else {
            System.out.println("\n[!] Please check your input."); 
        }
        
    }
    
    private static void userAddRemoveResistor()
    {
        System.out.println("\n[i] To add a resistor, please specify it by using commas (e.g: 10k, 5)\n[i] To remove resistor, please type the count negative (e.g: 10k, -5)\n[i] Everytime you press <enter> you will promted to input a new resistor. To return menu, simply type \"menu\" then press <enter>.");
        
        Scanner userRead = new Scanner(System.in);
        String userInput;
        
        while (true) {
            userInput = userRead.nextLine();
            
           if (userInput.equals("menu") ||  userInput.equals("\"menu\"") ||  userInput.equals("MENU") ||  userInput.equals("\"MENU\"")) break;
            
            try {
                String[] splitStr = userInput.trim().replace("\n", "").split(", ");
            
                if (Integer.parseInt(splitStr[1].trim()) > 0)
                    InventoryOne.addResistor(splitStr[0].trim(), Integer.parseInt(splitStr[1].trim()));
                else {
                    int res = InventoryOne.deleteResistor(splitStr[0].trim(), -1 * Integer.parseInt(splitStr[1].trim()));
                    if (res == -1)
                        System.out.print("[Error: The specified device does not exists or the amount of the device is less than the amount that you want to delete. Nothing has changed.]\n");
                    else
                        System.out.print("[The amount of that resistor has been decreased to " + res + "]\n");
                }

                //System.out.print("[OK]\n");
            }
            catch (Exception ex) {
                System.out.print("[Ups.. Did you miss space character after the comma?]\n");
            }
        }
        
        return;
    }
    
    private static void userAddRemoveCapacitor()
    {
        System.out.println("\n[i] To add a capacitor , please specify it by using commas (e.g: 10 uF, Type A, 5)\n[i] To remove a capacitor, please type the count negative (e.g: 10 uF, Type A, -5)\n[i] Everytime you press <enter> you will promted to input a new resistor. To return menu, simply type \"menu\" then press <enter>.");
        
        Scanner userRead = new Scanner(System.in);
        String userInput;
                
        while (true) {
            userInput = userRead.nextLine();
            
           if (userInput.equals("menu") ||  userInput.equals("\"menu\"") ||  userInput.equals("MENU") ||  userInput.equals("\"MENU\"")) break;
            
            try {
                String[] splitStr = userInput.trim().replace("\n", "").split(", ");
            
                if (Integer.parseInt(splitStr[2].trim()) > 0)
                    InventoryOne.addCapacitor(splitStr[0].trim(), splitStr[1].trim(), Integer.parseInt(splitStr[2].trim()));
                else {
                    int res = InventoryOne.deleteCapacitor(splitStr[0].trim(), splitStr[1].trim(), -1 * Integer.parseInt(splitStr[2].trim()));
                    if (res == -1)
                        System.out.print("[Error: The specified device does not exists or the amount of the device is less than the amount that you want to delete. Nothing has changed.]\n");
                    else
                        System.out.print("[The amount of that capacitor has been decreased to " + res + "]\n");
                }
                
                //System.out.print("[OK]\n");
            }
            catch (Exception ex) {
                System.out.print("[Ups.. Did you miss space character after the commas?]\n");
            }
        }
        
        return;
    }
    
    private static void userAddRemoveInductor()
    {
        System.out.println("\n[i] To add an inductor, please specify it by using commas (e.g: 10 mH, 5)\n[i] To remove an inductor, please type the count negative (e.g: 10 mH, -5)\n[i] Everytime you press <enter> you will promted to input a new resistor. To return menu, simply type \"menu\" then press <enter>.");
        
        Scanner userRead = new Scanner(System.in);
        String userInput;
        
        while (true) {
            userInput = userRead.nextLine();
            
           if (userInput.equals("menu") ||  userInput.equals("\"menu\"") ||  userInput.equals("MENU") ||  userInput.equals("\"MENU\"")) break;
            
            try {
                String[] splitStr = userInput.trim().replace("\n", "").split(", ");
            
                if (Integer.parseInt(splitStr[1].trim()) > 0)
                    InventoryOne.addInductor(splitStr[0].trim(), Integer.parseInt(splitStr[1].trim()));
                else {
                    int res = InventoryOne.deleteInductor(splitStr[0].trim(), -1 * Integer.parseInt(splitStr[1].trim()));
                    if (res == -1)
                        System.out.print("[Error: The specified device does not exists or the amount of the device is less than the amount that you want to delete. Nothing has changed.]\n");
                    else
                        System.out.print("[The amount of that inductor has been decreased to " + res + "]\n");
                }
                
                //System.out.print("[OK]\n");
            }
            catch (Exception ex) {
                System.out.print("[Ups.. Did you miss space character after the comma?]\n");
            }
        }
        
        return;
    }
    
    private static void userAddRemoveTransistor()
    {
        System.out.println("\n[i] To add a transistor, please specify it by using commas (e.g: BJT, 5)\n[i] To remove a transistor, please type the count negative (e.g: BJT, -5)\n[i] Everytime you press <enter> you will promted to input a new resistor. To return menu, simply type \"menu\" then press <enter>.");
        
        Scanner userRead = new Scanner(System.in);
        String userInput;
        
        while (true) {
            userInput = userRead.nextLine();
            
           if (userInput.equals("menu") ||  userInput.equals("\"menu\"") ||  userInput.equals("MENU") ||  userInput.equals("\"MENU\"")) break;
            
            try {
                String[] splitStr = userInput.trim().replace("\n", "").split(", ");
            
                if (Integer.parseInt(splitStr[1].trim()) > 0)
                    InventoryOne.addTransistor(splitStr[0].trim(), Integer.parseInt(splitStr[1].trim()));
                else {
                    int res = InventoryOne.deleteTransistor(splitStr[0].trim(), -1 * Integer.parseInt(splitStr[1].trim()));
                    if (res == -1)
                        System.out.print("[Error: The specified device does not exists or the amount of the device is less than the amount that you want to delete. Nothing has changed.]\n");
                    else
                        System.out.print("[The amount of that transistor has been decreased to " + res + "]\n");
                }
                
                //System.out.print("[OK]\n");
            }
            catch (Exception ex) {
                System.out.print("[Ups.. Did you miss space character after the comma?]\n");
            }
        }
        
        return;
    }
    
}
