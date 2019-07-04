/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

import java.util.Arrays;

/**
 *
 * @author veyseloglu
 */
public class LinkedListNode {
    
    public String word;
    public int[] wordLocations;
    public LinkedListNode next;
    public int wordFoundCount;
    public int hash;
    
    public LinkedListNode(String word, int wordLocation, int hash){
        wordLocations = new int[1];
        this.word = word;
        next = null;
        wordLocations[0] = wordLocation;
        wordFoundCount = 1;
        this.hash = hash;
    }
    
    public void FoundNewWordLocation(int location)
    {
        wordLocations = IncreaseArrayCapacity(wordLocations, 1);
        wordLocations[wordFoundCount] = location;
        wordFoundCount++;
    }
    
    private int[] IncreaseArrayCapacity(int[] arrayToEnlarge, int addLenght)
    {
        int[] newArray = Arrays.copyOf(arrayToEnlarge, arrayToEnlarge.length + addLenght);
        return newArray;
    }
    
}
