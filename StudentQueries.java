
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
public class StudentQueries {
    private static Connection connection;
    private static PreparedStatement addStudent;
    private static PreparedStatement getAllStudents;
    private static ResultSet resultSet1;


public static void addStudentEntry(StudentEntry entry){
        connection = DBConnection.getConnection();
        try
        {
            addStudent = connection.prepareStatement("insert into app.Students (StudentID,FirstName,LastName) values (?,?,?)");
            addStudent.setString(1, entry.getID());
            addStudent.setString(2, entry.getFirstName());
            addStudent.setString(3, entry.getLastName());
            addStudent.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }    




public static ArrayList<StudentEntry> getAllStudents(){
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> Stud = new ArrayList<StudentEntry>();
        try
        {
            getAllStudents = connection.prepareStatement("select * from app.STUDENTS order by STUDENTID");
            
            resultSet1 = getAllStudents.executeQuery();
            
            while(resultSet1.next())
            {
                StudentEntry S=new StudentEntry(resultSet1.getString("STUDENTID"),resultSet1.getString("FIRSTNAME"),resultSet1.getString("LASTNAME"));
                Stud.add(S);
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return Stud;
        
    }
}
    
    
    
