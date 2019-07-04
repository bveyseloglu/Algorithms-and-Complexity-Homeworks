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
public interface HashingInterface {
    
    void BuildHash(String filename, int size);
    long ConvertInt(String mystring);
    int FindHash(long myvalue);
    void InsertHash(String mystring, int location);
    void Display(String Outputfile);
    int NumofWord(String myword);
    String ShowMax ();
    int CheckWord(String myword);
    void Sort(String Outfile);
    
}
