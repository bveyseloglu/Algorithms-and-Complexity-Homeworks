/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 *
 * @author veyseloglu
 */
public class cHash implements HashingInterface {

    HashTable hashTable;
    int hashTableSize;
    
    public cHash(String filename, int size)
    {
        BuildHash(filename, size);
    }
    
    @Override
    public void BuildHash(String filename, int size) {
        hashTable = new HashTable(size);
        hashTableSize = size;
        
        // read text from file
        String[] words = ReadTextFile(filename);
        
        // build the hash table
        for (int i = 0; i < words.length; i++){ 
            if (!words[i].equals("")) // omit empty
                hashTable.AddItem(FindHash(ConvertInt(words[i])), words[i], i);
        }
       
    }
    
    private String[] ReadTextFile(String fileLocation)
    {
        String textFile = "";
        
        BufferedReader reader;
        
        try {
            reader = new BufferedReader(new FileReader(fileLocation));
            
            String line =  reader.readLine();
            while(line != null) {
                textFile += line;
                line =  reader.readLine();
            }
            reader.close();
            
            System.out.println("\n[i] Text file read successfully.\n");
        }
        catch (Exception ex) {
            System.out.println("\n[!] Something went wrong while reading the text file: " + ex.getMessage());
        }
        
        // parse string
        textFile = textFile.replaceAll("\\p{Punct}", "\n"); // remove punctuation
        textFile = textFile.replaceAll("\n", " ");
        String[] textWords = textFile.split(" |\n");    
        
        return textWords;
    }

    @Override
    public long ConvertInt(String mystring) {
        long result = 0;
        
        for(int i = 1; i <= mystring.length(); i++) {
           result +=  ((int)mystring.charAt(i-1)) * i; // 
        }
        
        return result;
    }

    @Override
    public int FindHash(long myvalue) {
        // Return the mod of myvalue to make fit into hash table.
        // Note: The size of hash table is fixed to 512. Changing the size of hash table changes the hash value.
        // To avoid this, choose a constant value rather than a table size. e.g.
        // return (int)(myvalue % 500); 
        
        return (int)(myvalue % (hashTableSize - 1)); 
    }

    @Override
    public void InsertHash(String mystring, int location) { 
        int hashOfString = FindHash(ConvertInt(mystring));
        hashTable.AddItem(hashOfString, mystring, location);
    }

    @Override
    public void Display(String Outputfile) {
        String outText = "";
        
        for (int i = 0; i < hashTableSize; i++) {
            if (hashTable.rowItemCount[i] != 0){
                LinkedListNode dumb = hashTable.hashTableFirstItems[i];
                
                while (true){
                    outText += "Word: " + dumb.word + " - ";
                    outText += "Hash: " + dumb.hash + " - ";
                    outText += "Repetition: " + Integer.toString(dumb.wordFoundCount) + " - Location(s): ";
                    for (int x = 0; x < dumb.wordFoundCount - 1; x++) {
                        outText += dumb.wordLocations[x] + ", ";
                    }
                    outText += dumb.wordLocations[dumb.wordFoundCount - 1] + "\r\n";
                    
                    if (dumb.next != null) dumb = dumb.next;
                    else break;
                }
            }
        }
        
        // *** write the output file
        WriteTextFile(outText, Outputfile);
        
    }

    @Override
    public int NumofWord(String myword) {
        int wordHash = FindHash(ConvertInt(myword));
        LinkedListNode dumb = hashTable.hashTableFirstItems[wordHash];
        
        while(true) {
            // if current element is null, break the operation
            if (dumb == null) 
                return -1;
            // if next element is not null, check the node and then seek forward
            else{
                if (dumb.word.equals(myword))
                    return dumb.wordLocations.length;
                dumb = dumb.next;
            }      
        }
    }

    @Override
    public String ShowMax() {
        LinkedListNode result = new LinkedListNode("",0,0);
        result.wordFoundCount = 0;
        
        for (int i = 0; i < hashTable.rowCount; i++) {
            LinkedListNode dumb;
            
            if(hashTable.rowItemCount[i] != 0) {      
                // search the word
                dumb = hashTable.hashTableFirstItems[i];
                while(true) {
                    // if current element is null, break the operation
                    if (dumb == null) 
                        break;
                    // if next element is not null, check the node and then seek forward
                    else{
                        if (dumb.wordFoundCount > result.wordFoundCount)
                            result = dumb;
                        dumb = dumb.next;
                    }
                    
                }
            }         
        }
        
        return result.word;
    }

    @Override
    public int CheckWord(String myword) {
        int wordHash = FindHash(ConvertInt(myword));
        LinkedListNode dumb = hashTable.hashTableFirstItems[wordHash];
        
        while(true) {
            // if current element is null, break the operation
            if (dumb == null) 
                return -1;
            // if next element is not null, check the node and then seek forward
            else{
                if (dumb.word.equals(myword))
                    return dumb.wordLocations[0];
                dumb = dumb.next;
            }      
        }
        
    }

    @Override
    public void Sort(String Outfile) {
        // find the repetition of the most repeated word
        int mostRepetition = NumofWord(ShowMax());
        
        // *** list words
        
        String word[][] = new String[mostRepetition+1][0];

        for (int i = 0; i < hashTable.rowCount; i++) {
            LinkedListNode dumb;
            
            if(hashTable.rowItemCount[i] != 0) {      
                // search the word
                dumb = hashTable.hashTableFirstItems[i];
                while(true) {
                    // if current element is null, break the operation
                    if (dumb == null) 
                        break;
                    // if next element is not null, check the node and then seek forward
                    else{
                        word[dumb.wordFoundCount] = IncreaseArrayCapacity(word[dumb.wordFoundCount],1);
                        word[dumb.wordFoundCount][word[dumb.wordFoundCount].length - 1] = dumb.word;
                        dumb = dumb.next;
                    }
                    
                }
            }         
        }
        
        // *** list array
        
        String outText = "";
        
        for (int i = 1; i < mostRepetition + 1; i++) {
            if (word[i].length != 0) {
                for (int ii = 0; ii < word[i].length; ii++) {
                    outText += word[i][ii];
                    outText += "\r\n";
                }
            }
        }
        
        // *** write the output file
        WriteTextFile(outText, Outfile);
        
    }
    
    private void WriteTextFile(String textToWrite, String fileLocation)
    {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileLocation), "utf-8"));
            
            String[] lines = textToWrite.split(System.getProperty("line.separator"));
            
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        }
        catch (Exception ex) {
            System.out.println("Something went wrong while writing into file:\n" + ex.getMessage());
        }
    }
    
    private String[] IncreaseArrayCapacity(String[] arrayToEnlarge, int addLenght)
    {
        String[] newArray = Arrays.copyOf(arrayToEnlarge, arrayToEnlarge.length + addLenght);
        return newArray;
    }
    
    
    
}
