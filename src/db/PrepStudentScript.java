package db;
import java.util.ArrayList;
import java.sql.*;

public class PrepStudentScript {
	
	private Connection conn = null;
	private Statement stmt = null;

	public PrepStudentScript(){
		String name = DBDetails.username;
		String pass = DBDetails.password;
		
		runSript(name, pass);   //Use to build out the required tables
		// deleteT(name,pass);     //Use to delete the tables completely
	}

	public void deleteT(String n, String p){
		try{
			Class.forName(DBDetails.JDBC_DRIVER);
		    conn = DriverManager.getConnection(DBDetails.DB_URL,n,p);
			stmt = conn.createStatement();

			stmt.executeUpdate("DROP TABLE Courses");
			stmt.executeUpdate("DROP TABLE SavedStudent");

			conn.close();
		}
		catch (Exception e){
			System.out.println(e);
		}

	}
	
	public void runSript(String n, String p){
		try{
			Class.forName(DBDetails.JDBC_DRIVER);
		    conn = DriverManager.getConnection(DBDetails.DB_URL,n,p);
		    stmt = conn.createStatement();
		    
		    //add Courses table
	        String sql = "CREATE TABLE IF NOT EXISTS Courses (\n"
	                + "	code text NOT NULL,\n"
	                + "	credit text,\n"
	                + "	name text,\n"
	                + "	prereq text\n"
	                + ");";
	        
	        //add SavedStudent table
	        String sql2 = "CREATE TABLE IF NOT EXISTS SavedStudent (\n"
	                + "	id text NOT NULL,\n"
	                + "	name text NOT NULL,\n"
	                + "	degree text,\n"
	                + "	course text\n"
	                + ");";
	        
			//System.out.println(sql); // echo the statement for debugging
			//System.out.println(sql2); // echo the statement for debugging
			
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
			
			stmt.close();
			conn.close();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	
	public static void main (String[] args){
		PrepStudentScript sInstance = new PrepStudentScript();
	}

}
