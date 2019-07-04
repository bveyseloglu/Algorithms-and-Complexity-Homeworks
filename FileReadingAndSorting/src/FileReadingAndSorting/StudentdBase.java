/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReadingAndSorting;

import java.io.PrintWriter;
import static FileReadingAndSorting.FileReadingAndSorting.dbFileLocation;

/**
 *
 * @author veyseloglu
 */
public class StudentdBase {
        
    public Student[] StudentArray;
    private int StudentCount;
    
    public StudentdBase(int stdCount)
    {
        StudentArray = new Student[stdCount];
        StudentCount = stdCount;
    }
    
    public void printAllStudents()
    {
        for (int i=0; i< StudentCount;i++)
            StudentArray[i].printStudentInfo();
    }
    
    public int getStudentCount() { return StudentCount; }
    
    public void sort_ID()
    {
        for (int i=1; i < StudentCount; i++) {
            int tempIndex = i-1;
            long tempValue = StudentArray[i-1].getID();
            
            for (int ii=i; ii < StudentCount; ii++) {
                if (StudentArray[ii].getID() < tempValue) {
                    tempValue = StudentArray[ii].getID();
                    tempIndex = ii;
                }
            }
            
            SwapStudentOrders(i-1, tempIndex);
        }
    }
    
    public void sort_Year()
    {
        for (int i=1; i < StudentCount; i++) {
            int tempIndex = i-1;
            int tempValue = StudentArray[i-1].getAdmYear();
            
            for (int ii=i; ii < StudentCount; ii++) {
                if (StudentArray[ii].getAdmYear() < tempValue) {
                    tempValue = StudentArray[ii].getAdmYear();
                    tempIndex = ii;
                }
            }
            
            SwapStudentOrders(i-1, tempIndex);
        }
    }
    
    public void sort_Age()
    {
        for (int i=1; i < StudentCount; i++) {
            int tempIndex = i-1;
            int tempValue = StudentArray[i-1].getAge();
            
            for (int ii=i; ii < StudentCount; ii++) {
                if (StudentArray[ii].getAge() < tempValue) {
                    tempValue = StudentArray[ii].getAge();
                    tempIndex = ii;
                }
            }
            
            SwapStudentOrders(i-1, tempIndex);
        }
    }
    
    private void SwapStudentOrders(int firstIndex, int secondIndex)
    {
        Student tempStudent = new Student();
        tempStudent = StudentArray[firstIndex];
        StudentArray[firstIndex] = StudentArray[secondIndex];
        StudentArray[secondIndex] = tempStudent;
    }
    
    boolean updateDBFile(String fileLocation)
    {
        try {
            PrintWriter writer = new PrintWriter(dbFileLocation);
            writer.println(StudentCount);
            
            for (int i=0; i < StudentCount; i++) {
                writer.println(StudentArray[i].getStudentInfo());
            }
            
            writer.close();
            
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
        
    }
    
}
