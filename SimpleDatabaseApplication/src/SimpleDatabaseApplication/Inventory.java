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
public class Inventory implements InventoryInterface {

    LinkedList inventoryDB = new LinkedList();
    
    @Override
    public void addResistor(String val, Integer cnt) {
        inventoryDB.insertItem(new Device("Resistor", "", val, cnt));
    }

    @Override
    public void addCapacitor(String val, String typ, Integer cnt) {
        inventoryDB.insertItem(new Device("Capacitor", typ, val, cnt));
    }

    @Override
    public void addInductor(String val, Integer cnt) {
        inventoryDB.insertItem(new Device("Inductor", "", val, cnt));
    }

    @Override
    public void addTransistor(String typ, Integer cnt) {
        inventoryDB.insertItem(new Device("Transistor", typ, "", cnt));
    }

    @Override
    public int deleteResistor(String val, Integer cnt) {
        return inventoryDB.deleteItem(new Device("Resistor", "", val, 0), cnt);
    }

    @Override
    public int deleteCapacitor(String val, String typ, Integer cnt) {
        return inventoryDB.deleteItem(new Device("Capacitor", typ, val, 0), cnt);
    }

    @Override
    public int deleteInductor(String val, Integer cnt) {
        return inventoryDB.deleteItem(new Device("Inductor", "", val, 0), cnt);
    }

    @Override
    public int deleteTransistor(String typ, Integer cnt) {
        return inventoryDB.deleteItem(new Device("Transistor", typ, "", 0), cnt);
    }

    @Override
    public void printInventory() {
        inventoryDB.printAllItems();
    }
    
    
    
}
