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
public class LinkedList {
    Node head = null;
    int devicesCount = 0;
    
    private void addIndex(Device device)
    {
        this.devicesCount++;
        Node tempNode = head;
        
        if (head == null) {
            head = new Node(device);
            return;
        }
        
        while (tempNode.next != null)
            tempNode = tempNode.next;
        
        tempNode.next = new Node(device);
    }
    
    public void removeIndex(int index)
    {
        devicesCount--;
        Node prevNode = head;
        
        for (int i = 0; i < index; i++){
            prevNode = prevNode.next;
        }
        
        Node nextNode = prevNode.next.next;
        
        prevNode.next = nextNode;
    }
    
    public void insertItem(Device device)
    {
        Node tempNode = head;
        
        if (head == null) {
            head = new Node(device);
            this.devicesCount++;
            return;
        }
        
        while (tempNode.next != null) {
            if (tempNode.device.getName().equals(device.getName())  && tempNode.device.getType().equals(device.getType()) && tempNode.device.getValue().equals(device.getValue())) {
                tempNode.device.increaseCount(device.getCount());
                return;
            } 
            
            tempNode = tempNode.next;
        }

        if (tempNode.device.getName().equals(device.getName())  && tempNode.device.getType().equals(device.getType()) && tempNode.device.getValue().equals(device.getValue())) {
                tempNode.device.increaseCount(device.getCount());
                return;
        }
        
        tempNode.next = new Node(device);
        this.devicesCount++;
    }
    
    
    public Node readItem(int index)
    {
        Node returnNode = head;
        
        for (int i = 0; i < index + 1; i++){
            returnNode = returnNode.next;
        }
        
        return returnNode;
    }
    
    public int deleteItem(Device device, int count)
    {
        Node tempNode = head;
        
        if (head == null) return -1;
        
        while (tempNode.next != null) {
            if (tempNode.device.getName().equals(device.getName())  && tempNode.device.getType().equals(device.getType()) && tempNode.device.getValue().equals(device.getValue())) {
                if(tempNode.device.decreaseCount(count))
                    return tempNode.device.getCount();
                else
                    return -1;
            } 
            
            tempNode = tempNode.next;
        }

        if (tempNode.device.getName().equals(device.getName())  && tempNode.device.getType().equals(device.getType()) && tempNode.device.getValue().equals(device.getValue())) {
              if(tempNode.device.decreaseCount(count))
                    return tempNode.device.getCount();
                else
                    return -1;
        }
        
        return -1;
    }
    
    public void printAllItemsIgnoreOrder()
    {
        Node tempNode = head;
        
        for (int i = 0; i<devicesCount;i++){
            tempNode.printNode();
            tempNode = tempNode.next;
        }
        
    }
    
    public void printAllItems()
    {
        Device tempDevice;
        Node tempNode = head;
        
        LinkedList resistors = new LinkedList();
        LinkedList capacitors = new LinkedList();
        LinkedList inductors = new LinkedList();
        LinkedList transistors = new LinkedList();
        
        for (int i = 0; i < devicesCount; i++){
            if (tempNode.device.getName() == "Resistor")
                resistors.addIndex(tempNode.device);
            if (tempNode.device.getName() == "Capacitor")
                capacitors.addIndex(tempNode.device);
            if (tempNode.device.getName() == "Inductor")
                inductors.addIndex(tempNode.device);
            if (tempNode.device.getName() == "Transistor")
                transistors.addIndex(tempNode.device);
            
            tempNode = tempNode.next;
        }
        
        if (resistors.devicesCount > 0) resistors.printAllItemsIgnoreOrder(); else System.out.println("[i] You have no resistors in your inventory.");
        if (capacitors.devicesCount > 0) capacitors.printAllItemsIgnoreOrder(); else System.out.println("[i] You have no capacitors in your inventory.");
        if (inductors.devicesCount > 0) inductors.printAllItemsIgnoreOrder(); else System.out.println("[i] You have no inductors in your inventory.");
        if (transistors.devicesCount > 0) transistors.printAllItemsIgnoreOrder(); else System.out.println("[i] You have no transistors in your inventory.");

    }
    
}
