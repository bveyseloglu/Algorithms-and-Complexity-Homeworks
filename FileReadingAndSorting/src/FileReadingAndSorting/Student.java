/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReadingAndSorting;

/**
 *
 * @author veyseloglu
 */
public class Student {
       
    private int age; 
    private long ID;
    private int admYear; 
    private String name; 
    private String surname;
    
    public void setStudentInfo(int std_age, long std_id, int std_admYear, String std_name, String std_surname)
    {
        age = std_age;
        ID = std_id;
        admYear = std_admYear;
        name = std_name;
        surname = std_surname;
    }
    
    public int getAge() { return age; }
    public long getID() { return ID; }
    public int getAdmYear() { return admYear; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    
    public void printStudentInfo()
    {
        System.out.println(ID + " " + name + " " + surname + " " + age + " " + admYear);
    }
    
    public String getStudentInfo()
    {
        return ID + " " + name + " " + surname + " " + age + " " + admYear;
    }
    
    public Student readStudent()
    {
        Student std = new Student();
        
        std.age = age;
        std.ID = ID;
        std.admYear = admYear;
        std.name = name;
        std.surname = surname;
        
        return std;
    }
    
}
