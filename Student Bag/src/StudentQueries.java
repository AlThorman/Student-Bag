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
public class StudentQueries {
    public static final String URL = "jdbc:mysql://127.0.0.1";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "12345678";
    
    private Connection connection = null;
    private PreparedStatement selectAllStudent = null;
    private PreparedStatement selectStudentByLastName = null;
    private PreparedStatement insertNewStudent = null;
    private PreparedStatement login = null;
    
    StudentQueries()
    {
        try 
        {
            
          connection =  DriverManager.getConnection( URL, USERNAME, PASSWORD ); 
            
            selectAllStudent = connection.prepareStatement( "SELECT * FROM Student" );
           
            selectStudentByLastName = connection.prepareStatement("SELECT * FROM Student WHERE LastName = ?" );
            
            insertNewStudent = connection.prepareStatement("INSERT INTO Student " +"( FirstName, LastName, Password ,Email ,PhoneNumber ) " +"VALUES ( ?, ?, ?,?, ? )"  );
            
            login = connection.prepareStatement("SELECT * FROM Student WHERE email = ? and password = ? " );
            

            
            
            
            
        }
        catch ( SQLException sqlException ) {
            sqlException.printStackTrace();
            System.exit( 1 );
            
        }
       
    }
    
    public List< Student > getAllPeople()
{
   List< Student > results = null;
   ResultSet resultSet = null;
try
   {
       resultSet = selectAllStudent.executeQuery();
      results = new ArrayList< Student >();
      while ( resultSet.next() )
      {

 results.add( new Student(
    resultSet.getInt( "addressID" ),
    resultSet.getString( "FirstName" ),
    resultSet.getString( "LastName" ),
    resultSet.getString( "Password" ),    
    resultSet.getString( "Email" ),
    resultSet.getString( "PhoneNumber" ) ) );
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
 public List< Student > getPeopleByLastName( String name )
{
   List< Student > results = null;
   ResultSet resultSet = null;
try
{
selectStudentByLastName.setString( 1, name );
resultSet = selectStudentByLastName.executeQuery();

results = new ArrayList< Student >();
while ( resultSet.next() )
{
   results.add( new Student( resultSet.getInt( "addressID" ),
      resultSet.getString( "FirstName" ),
      resultSet.getString( "LastName" ),
      resultSet.getString( "Password" ),     
      resultSet.getString( "Email" ),
      resultSet.getString( "PhoneNumber" ) ) );
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
 
 public List< Student > login (String email,String pass  )
{
   List< Student > results = null;
   ResultSet resultSet = null;
try
   {
       login.setString( 1, email );
       login.setString( 2, pass );
       resultSet = login.executeQuery();
      results = new ArrayList< Student >();
      while ( resultSet.next() )
      {

 results.add( new Student(
    resultSet.getInt( "addressID" ),
    resultSet.getString( "FirstName" ),
    resultSet.getString( "LastName" ),
    resultSet.getString( "Password" ),    
    resultSet.getString( "Email" ),
    resultSet.getString( "PhoneNumber" ) ) );
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
 
 public int addStudent(
 String fname, String lname,String password ,String email, String num )
 {
 int result = 0;

 
 try
 {
insertNewStudent.setString( 1, fname );
insertNewStudent.setString( 2, lname );
insertNewStudent.setString( 3, password );
insertNewStudent.setString( 4, email );
insertNewStudent.setString( 5, num );

result = insertNewStudent.executeUpdate();

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
  
