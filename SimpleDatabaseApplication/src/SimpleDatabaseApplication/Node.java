/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleDatabaseApplication;

/**
 *
 * @author veyseloglu
 */
public class Node {
    
    Node next;
    Device device;
    
    public Node(Device device)
    {
        this.device = device;
    }
    
    public void printNode()
    {
        System.out.println("Name: " + device.getName() + " // Type: " + device.getType() + " // Value: " + device.getValue() + " // Count: " + device.getCount());
    }
    
}
