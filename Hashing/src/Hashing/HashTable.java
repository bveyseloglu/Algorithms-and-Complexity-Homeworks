/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

/**
 *
 * @author veyseloglu
 */
public class HashTable {
    
    public LinkedListNode[] hashTableFirstItems;
    public int[] rowItemCount;
    public int rowCount;
    
    public HashTable(int tableSize)
    {
        hashTableFirstItems = new LinkedListNode[tableSize];        
        rowItemCount = new int[tableSize];
        
        this.rowCount = tableSize;
    }
    
    public void AddItem(int hash, String word, int wordLocation)
    {
        //check the existance of the first word at the <hash>th row of the hash table
        
        // if no word exits, put the new word
        if(rowItemCount[hash] == 0) {
            rowItemCount[hash]++;
            LinkedListNode newWordNode = new LinkedListNode(word, wordLocation, hash);
            hashTableFirstItems[hash] = newWordNode;
        }
        // if one or more word exists in the <hash>th row of the hash table
        else {            
            // search the word
            LinkedListNode dumb = hashTableFirstItems[hash];
            while(true) {
                // if word found, add new location
                if(dumb.word.equals(word)) {
                    dumb.FoundNewWordLocation(wordLocation);
                    break;
                }
                // if word not found yet
                else {
                    // if next element is null, insert a new node that contains the new word then exit the loop
                    if (dumb.next == null) {
                        rowItemCount[hash]++;
                        LinkedListNode newWordNode = new LinkedListNode(word, wordLocation, hash);
                        dumb.next = newWordNode;
                        break;
                    }
                    // if next element is not null, check the forward node by repeating the loop
                    else
                        dumb = dumb.next;
                }
            }
        }
    }

}
