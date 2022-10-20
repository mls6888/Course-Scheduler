/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author micha
 */
public class StudentEntry {
    private final String StudentID;
    private final String FirstName;
    private final String Lastname;
    //defines all the attributes of this class//
    
    public String getID(){
        return this.StudentID;
    }
    public String getFirstName(){
        return this.FirstName;
        
    }
    public String getLastName(){
        return this.Lastname;
    }
    //getter functions//
    public StudentEntry(String ID,String Name,String LastName){
        this.StudentID=ID;
        this.FirstName=Name;
        this.Lastname=LastName;
        //constructor for this class/
}
}
