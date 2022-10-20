
import java.security.Timestamp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author micha
 */
public class ScheduleEntry {
    private final String Semester;
    private  final String CourseCode;
    private final String StudentID;
    private final String Status;
    private java.sql.Timestamp Time;
    //defines all the attributes of this class//
    
    public String getSemester(){
        return this.Semester;
    }
    public String getCourseCode(){
        return this.CourseCode;
    }
    public String getStudentID(){
        return this.StudentID;
    }
    public String getStatus(){
        return this.Status;
    }
    public java.sql.Timestamp getTimeStamp(){
        return this.Time;
    //getter functions//
    }
    
    public ScheduleEntry(String Semester,String CourseCode,String ID,String Status,java.sql.Timestamp Time){
        this.Semester=Semester;
        this.CourseCode=CourseCode;
        this.StudentID=ID;
        this.Status=Status;
        this.Time=Time;
        //constructor that sets the attributes of this object//
    }
}
