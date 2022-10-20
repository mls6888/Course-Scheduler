
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
public class CourseQueries {
    
    
    private static Connection connection;
    private static PreparedStatement getSeats;
    private static PreparedStatement getAllCourseCodes;
    private static PreparedStatement getAllCourses;
    private static PreparedStatement addCourse;
    private static ResultSet resultSet1;
    private static ResultSet resultSet2;
    private static ResultSet resultSet3;
    private static ArrayList<CourseEntry> Courses;
    private static ArrayList<String> CourseCodes;
    
    public static ArrayList<CourseEntry> getAllCourses(String semester){
        connection = DBConnection.getConnection();
        Courses=new ArrayList<CourseEntry>();
        
        try
        {
            getAllCourses = connection.prepareStatement("select * from app.COURSES where SEMESTER=?");
            getAllCourses.setString(1,semester);
            resultSet1 = getAllCourses.executeQuery();
            
            while(resultSet1.next())
            {
                CourseEntry Course=new CourseEntry(semester,resultSet1.getString("COURSECODE"),resultSet1.getString("DESCRIPTION"),resultSet1.getInt("SEATS"));
                Courses.add(Course);
                
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return Courses;
        
    }
    //gets all courses
    
    public static ArrayList<String> getAllCourseCodes(String semester){
            {
        connection = DBConnection.getConnection();
        CourseCodes=new ArrayList<String>();
        try
        {
            getAllCourseCodes = connection.prepareStatement("select CourseCode from app.COURSES Where SEMESTER=?");
            getAllCourseCodes.setString(1,semester);
            resultSet2 = getAllCourseCodes.executeQuery();
            
            while(resultSet2.next())
            {
                
                CourseCodes.add(resultSet2.getString(1));
            }
        }
        //gets all codes
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return CourseCodes;
        
    }

    
    }
    //might be static//
    public static void addCourse(CourseEntry course){
        connection = DBConnection.getConnection();
        try
        {
            addCourse = connection.prepareStatement("insert into app.Courses (Semester,CourseCode,Description,seats) values (?,?,?,?)");
            addCourse.setString(1, course.getSemester());
            addCourse.setString(2, course.getCourseCode());
            addCourse.setString(3, course.getDescription());
            addCourse.setInt(4, course.getseats());
            addCourse.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    //adds course
    public static int getCourseSeats(String semester, String courseCode){
        connection = DBConnection.getConnection();
        int CourseSeats = 0;
        try
        {
            //might be wrong//
            getSeats = connection.prepareStatement("select Seats from app.COURSES Where Semester=? AND CourseCode=? order by COURSECODE");
            getSeats.setString(1,semester);
            getSeats.setString(2,courseCode);
            resultSet3 = getSeats.executeQuery();
            //Check if right//
            while(resultSet3.next())
            {
                CourseSeats=resultSet3.getInt("SEATS");
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return CourseSeats;
        
    }

//gets seats
public static int getAvailableCourseSeats(String semester, String courseCode){
    connection = DBConnection.getConnection();
        int CourseSeats = 0;
        try
        {
            //might be wrong//
            
            getSeats = connection.prepareStatement("select count(studentID) from app.schedule where semester = ? and courseCode = ?");
            getSeats.setString(1,semester);
            getSeats.setString(2,courseCode);
            resultSet3 = getSeats.executeQuery();
            //Check if right//
            while(resultSet3.next())
            {
                CourseSeats=resultSet3.getInt(1);
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        if ((getCourseSeats(semester,courseCode)-CourseSeats)<0){
            return 0;
        }


        return (getCourseSeats(semester,courseCode)-CourseSeats);
        
}
//gets available seats
}


    
    
    
 
    
   

