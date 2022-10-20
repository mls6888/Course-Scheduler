
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author micha
 */
public class ScheduleQueries {
    private static Connection connection;
    private static PreparedStatement getSchedule;
    private static PreparedStatement addSchedule;
    private static ResultSet resultSet;
    private static ScheduleEntry Entry;
    
    
      
    
    public static void addScheduleEntry(ScheduleEntry entry){
        connection = DBConnection.getConnection();
        try
        {
            addSchedule = connection.prepareStatement("insert into app.Schedule (Semester,CourseCode,StudentID,Status,TimeStamp) values (?,?,?,?,?)");
            addSchedule.setString(1, entry.getSemester());
            addSchedule.setString(3, entry.getStudentID());
            addSchedule.setString(2, entry.getCourseCode());
            addSchedule.setString(4, entry.getStatus());
            addSchedule.setTimestamp(5, entry.getTimeStamp());
            addSchedule.executeUpdate();
            //add schedule
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    public static ArrayList<ScheduleEntry> getScheduleByStudent(String semester, String studentID){
        
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> Schedule = new ArrayList<ScheduleEntry>();
        try
        {
            //order might be wrong//
            
            getSchedule = connection.prepareStatement("select * from app.SCHEDULE Where Semester=? AND StudentID=? order by coursecode");
            getSchedule.setString(1,semester);
            getSchedule.setString(2,studentID);
            resultSet = getSchedule.executeQuery();
            
            //Figure out//
            while(resultSet.next())
            {
                ScheduleEntry Entry=new ScheduleEntry(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getTimestamp(5));
                
                
                    Schedule.add(Entry);
                
            }
            
          
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    return Schedule;
    //gets scheudle by student
        
    
    }

}
    