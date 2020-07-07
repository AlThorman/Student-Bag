/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author althorman
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
public class InstructorQueries {
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/OOP2 Project";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "Asy25874";
    
    private Connection connection = null;
    private PreparedStatement selectAllInstructor = null;
    private PreparedStatement selectInstructorByLastName = null;
    private PreparedStatement insertNewInstructor = null;
    
    InstructorQueries()
    {
        try 
        {
            
          connection =  DriverManager.getConnection( URL, USERNAME, PASSWORD ); 
            
            selectAllInstructor = connection.prepareStatement( "SELECT * FROM Instructor" );
           
            selectInstructorByLastName = connection.prepareStatement("SELECT * FROM Instructor WHERE LastName = ?" );
            
            insertNewInstructor = connection.prepareStatement("INSERT INTO Instructor " +"( FirstName, LastName, Email, Course,Department ) " +"VALUES ( ?, ?, ?, ?,? )"  );
            
            
            
            
        }
        catch ( SQLException sqlException ) {
            sqlException.printStackTrace();
            System.exit( 1 );
            
        }
       
    }
    
    public List< Instructor > getAllInstructor()
{
   List< Instructor > results = null;
   ResultSet resultSet = null;
try
   {
       resultSet = selectAllInstructor.executeQuery();
      results = new ArrayList< Instructor >();
      while ( resultSet.next() )
      {

 results.add( new Instructor(
    resultSet.getInt( "ID" ),
    resultSet.getString( "FirstName" ),
    resultSet.getString( "LastName" ),
    resultSet.getString( "Email" ),
    resultSet.getString( "Course" ),
    resultSet.getString( "Department" ) ) );
      }
   }

 
catch ( SQLException sqlException )
{
   sqlException.printStackTrace();
} 
finally
{
try
   {
      resultSet.close();
} 
    
    


catch ( SQLException sqlException )
{

 sqlException.printStackTrace();
 close();

}
}

   return results;

}
 public List< Instructor > getInstructorByLastName( String name )
{
   List< Instructor > results = null;
   ResultSet resultSet = null;
try
{
selectInstructorByLastName.setString( 1, name );
resultSet = selectInstructorByLastName.executeQuery();

results = new ArrayList< Instructor >();
while ( resultSet.next() )
{
   results.add( new Instructor(
    resultSet.getInt( "ID" ),
    resultSet.getString( "FirstName" ),
    resultSet.getString( "LastName" ),
    resultSet.getString( "Email" ),
    resultSet.getString( "Course" ),
    resultSet.getString( "Department" ) ) );
}
}
 
catch ( SQLException sqlException )
{
   sqlException.printStackTrace();
} 
finally
{
try
   {
      resultSet.close();
   } 
   catch ( SQLException sqlException )
   {

 sqlException.printStackTrace();
close();
   }
}
   return results;
 

    
    
}
 public int addInstructor(
 String fname, String lname, String email, String course, String department )
 {
 int result = 0;

 
 try
 {
insertNewInstructor.setString( 1, fname );
insertNewInstructor.setString( 2, lname );
insertNewInstructor.setString( 3, email );
insertNewInstructor.setString( 4, course );
insertNewInstructor.setString( 5, department );

result = insertNewInstructor.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 } 

 
 public void close()
 {
 try
 {
 connection.close();
 }
 catch ( SQLException sqlException )
 {
     sqlException.printStackTrace();

 }
 }

    
    }
  
    

