
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
public class CourseEntry {
  private final String Semester;
  private final String CourseCode;
  private final String Description;
  private int Seats;
  public ArrayList<String> waitlist;
  
  public ArrayList<String> getWaitList(){
      return this.waitlist;
  }
  
  public int getseats(){
      return this.Seats;
}
    
  public String getCourseCode(){
      return this.CourseCode;
}
  public String getDescription(){
    return this.Description;
  }
  public String getSemester(){
      return this.Semester;
  }
  //getter methods//
  public void addwaitlist(String Entry){
      this.waitlist.add(Entry);
  }
  
  public CourseEntry(String semester,String CourseCode,String Description,int Seats){
      this.waitlist=new ArrayList<String>();
      this.Semester=semester;
      this.CourseCode=CourseCode;
      this.Description=Description;
      this.Seats=Seats;
      
}
}
