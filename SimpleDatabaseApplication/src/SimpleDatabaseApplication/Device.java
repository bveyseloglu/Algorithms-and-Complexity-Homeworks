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
public class Device {
    
    private String Name;
    private String Type;
    private String Value;
    private Integer Count;
    
    public Device(String n, String t, String v, Integer c){
        Name = n;
        Type = t; //bjt falan
        Value = v;
        Count = c;
    }
    
    public String getName() { return Name; } 
    public String getType() { return Type; } 
    public String getValue() { return Value; } 
    public int getCount() { return Count; }
    
    public void setName(String name) { Name = name; } 
    public void setType(String type) { Type = type; } 
    public void setValue(String value) { Value = value; } 
    public void setCount(int count) { Count = count; }
    
    public void increaseCount(int count) { Count += count; }
    public boolean decreaseCount(int count) { 
        if (Count - count < 0) return false;
        else Count -= count;
        
        return true;
    }
    
}
