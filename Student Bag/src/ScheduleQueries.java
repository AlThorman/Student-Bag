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
public class ScheduleQueries {
    public static final String URL = "jdbc:mysql://127.0.0.1";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "12345678";
    
    private Connection connection = null;
    private PreparedStatement selectAllSec = null;
    private PreparedStatement selectStudentByLastName = null;
    private PreparedStatement InsertSun1 = null;
    private PreparedStatement InsertSun2 = null;
    private PreparedStatement InsertSun3 = null;
    private PreparedStatement InsertSun4 = null;
    private PreparedStatement InsertMon1 = null;
    private PreparedStatement InsertMon2 = null;
    private PreparedStatement InsertMon3 = null;
    private PreparedStatement InsertMon4 = null;
    private PreparedStatement InsertTue1 = null;
    private PreparedStatement InsertTue2 = null;
    private PreparedStatement InsertTue3 = null;
    private PreparedStatement InsertTue4 = null;
    private PreparedStatement InsertWed1 = null;
    private PreparedStatement InsertWed2 = null;
    private PreparedStatement InsertWed3 = null;
    private PreparedStatement InsertWed4 = null;
    private PreparedStatement InsertThu1 = null;
    private PreparedStatement InsertThu2 = null;
    private PreparedStatement InsertThu3 = null;
    private PreparedStatement InsertThu4 = null;
    private PreparedStatement login = null;
    private PreparedStatement course = null;
    private PreparedStatement update_course = null;
    
    ScheduleQueries()
    {
        try 
        {
            
          connection =  DriverManager.getConnection( URL, USERNAME, PASSWORD ); 
            
            selectAllSec = connection.prepareStatement( "SELECT * FROM Student Where email = ?" );
           
            //selectStudentByLastName = connection.prepareStatement("SELECT * FROM Student WHERE LastName = ?" );
            
            InsertSun1 = connection.prepareStatement("UPDATE  Student SET sun1 = ? WHERE email = ?" );
            InsertSun2 = connection.prepareStatement("UPDATE  Student SET sun2 = ? WHERE email = ?" );
            InsertSun3 = connection.prepareStatement("UPDATE  Student SET sun3 = ? WHERE email = ?" );
            InsertSun4 = connection.prepareStatement("UPDATE  Student SET sun4 = ? WHERE email = ?" );
            InsertMon1 = connection.prepareStatement("UPDATE  Student SET mon1 = ? WHERE email = ?" );
            InsertMon2 = connection.prepareStatement("UPDATE  Student SET mon2 = ? WHERE email = ?" );
            InsertMon3 = connection.prepareStatement("UPDATE  Student SET mon3 = ? WHERE email = ?" );
            InsertMon4 = connection.prepareStatement("UPDATE  Student SET mon4 = ? WHERE email = ?" );
            InsertTue1 = connection.prepareStatement("UPDATE  Student SET tue1 = ? WHERE email = ?" );
            InsertTue2 = connection.prepareStatement("UPDATE  Student SET tue2 = ? WHERE email = ?" );
            InsertTue3 = connection.prepareStatement("UPDATE  Student SET tue3 = ? WHERE email = ?" );
            InsertTue4 = connection.prepareStatement("UPDATE  Student SET tue4 = ? WHERE email = ?" );
            InsertWed1 = connection.prepareStatement("UPDATE  Student SET wed1 = ? WHERE email = ?" );
            InsertWed2 = connection.prepareStatement("UPDATE  Student SET wed2 = ? WHERE email = ?" );
            InsertWed3 = connection.prepareStatement("UPDATE  Student SET wed3 = ? WHERE email = ?" );
            InsertWed4 = connection.prepareStatement("UPDATE  Student SET wed4 = ? WHERE email = ?" );
            InsertThu1 = connection.prepareStatement("UPDATE  Student SET thu1 = ? WHERE email = ?" );
            InsertThu2 = connection.prepareStatement("UPDATE  Student SET thu2 = ? WHERE email = ?" );
            InsertThu3 = connection.prepareStatement("UPDATE  Student SET thu3 = ? WHERE email = ?" );
            InsertThu4 = connection.prepareStatement("UPDATE  Student SET thu4 = ? WHERE email = ?" );
            
            login = connection.prepareStatement("SELECT * FROM Student WHERE email = ? and password = ? " );
            
            
            
            
        }
        catch ( SQLException sqlException ) {
            sqlException.printStackTrace();
            System.exit( 1 );
            
        }
       
    }
    public List< Schedule_n > getAllSec(String email)
{
   List< Schedule_n > results = null;
   ResultSet resultSet = null;
try
   {
       selectAllSec.setString( 1, email );
       resultSet = selectAllSec.executeQuery();
      results = new ArrayList< Schedule_n >();
      while ( resultSet.next() )
      {

 results.add( new Schedule_n(
    resultSet.getString( "sun1" ),
    resultSet.getString( "sun2" ),
    resultSet.getString( "sun3" ),
    resultSet.getString( "sun4" ),    
    resultSet.getString( "mon1" ),
    resultSet.getString( "mon2" ),
    resultSet.getString( "mon3" ),
    resultSet.getString( "mon4" ),
    resultSet.getString( "tue1" ),
    resultSet.getString( "tue2" ),
    resultSet.getString( "tue3" ),
    resultSet.getString( "tue4" ),
    resultSet.getString( "wed1" ),
    resultSet.getString( "wed2" ),
    resultSet.getString( "wed3" ),
    resultSet.getString( "wed4" ),
    resultSet.getString( "thu1" ),
    resultSet.getString( "thu2" ),
    resultSet.getString( "thu3" ),
    resultSet.getString( "thu4" ) ) );
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
    
    public int addSun1(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertSun1.setString( 1, sun1 );
InsertSun1.setString( 2, email );


result = InsertSun1.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addSun2(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertSun2.setString( 1, sun1 );
InsertSun2.setString( 2, email );

result = InsertSun2.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addSun3(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertSun3.setString( 1, sun1 );
InsertSun3.setString( 2, email );

result = InsertSun3.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addSun4(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertSun4.setString( 1, sun1 );
InsertSun4.setString( 2, email );

result = InsertSun4.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addMon1(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertMon1.setString( 1, sun1 );
InsertMon1.setString( 2, email );

result = InsertMon1.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addMon2(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertMon2.setString( 1, sun1 );
InsertMon2.setString( 2, email );

result = InsertMon2.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addMon3(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertMon3.setString( 1, sun1 );
InsertMon3.setString( 2, email );

result = InsertMon3.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addMon4(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertMon4.setString( 1, sun1 );
InsertMon4.setString( 2, email );

result = InsertMon4.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addTue1(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertTue1.setString( 1, sun1 );
InsertTue1.setString( 2, email );

result = InsertTue1.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addTue2(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertTue2.setString( 1, sun1 );
InsertTue2.setString( 2, email );

result = InsertTue2.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addTue3(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertTue3.setString( 1, sun1 );
InsertTue3.setString( 2, email );

result = InsertTue3.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addTue4(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertTue4.setString( 1, sun1 );
InsertTue4.setString( 2, email );

result = InsertTue4.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addWed1(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertWed1.setString( 1, sun1 );
InsertWed1.setString( 2, email );

result = InsertWed1.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addWed2(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertWed2.setString( 1, sun1 );
InsertWed2.setString( 2, email );

result = InsertWed2.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addWed3(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertWed3.setString( 1, sun1 );
InsertWed3.setString( 2, email );

result = InsertWed3.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addWed4(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertWed4.setString( 1, sun1 );
InsertWed4.setString( 2, email );

result = InsertWed4.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addThu1(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertThu1.setString( 1, sun1 );
InsertThu1.setString( 2, email );

result = InsertThu1.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addThu2(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertThu2.setString( 1, sun1 );
InsertThu2.setString( 2, email );

result = InsertThu2.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addThu3(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertThu3.setString( 1, sun1 );
InsertThu3.setString( 2, email );

result = InsertThu3.executeUpdate();

 }
 catch ( SQLException sqlException )
 {
 sqlException.printStackTrace();
 close();
 } 

 return result;
 }
    public int addThu4(
 String sun1,String email )
 {
 int result = 0;

 
 try
 {
InsertThu4.setString( 1, sun1 );
InsertThu4.setString( 2, email );

result = InsertThu4.executeUpdate();

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
