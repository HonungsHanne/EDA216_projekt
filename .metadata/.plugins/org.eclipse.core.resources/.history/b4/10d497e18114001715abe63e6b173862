package dbtLab3;

import java.sql.*;
import java.util.*;

/**
 * Database is a class that specifies the interface to the movie
 * database. Uses JDBC.
 */
public class Database {

    /**
     * The database connection.
     */
    private Connection conn;
    
    private String username;

    /**
     * Create the database interface object. Connection to the
     * database is performed later.
     */
    public Database() {
        conn = null;
    }

    /**
     * Open a connection to the database, using the specified user
     * name and password.
     */
    public boolean openConnection(String filename) {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + filename);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Close the connection to the database.
     */
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if the connection to the database has been established
     * 
     * @return true if the connection has been established
     */
    public boolean isConnected() {
        return conn != null;
    }
    
    public boolean login(String s){
        String sqlcommand = "SELECT username \n" 
        		+ "FROM users " + "WHERE username='" + s + "'";
        
        Statement st;
        ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sqlcommand);
			
			if(rs.next()) {
				username = rs.getString("username");
				
				return true;
			}
			
			else {
				return false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
        return false;
    }
    public ArrayList<String> getMovies(){
    	ArrayList<String> temp = new ArrayList<String>();
    	String sqlcommand = "SELECT name\n"
    			+ "FROM movies";
    	
    	Statement st;
    	ResultSet rs;
    	try {
    		st = conn.createStatement();
			rs = st.executeQuery(sqlcommand);
			while (rs.next()){
				temp.add(rs.getString("name"));
				
			}
			return temp;
			
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}
		return null;
    	
    	
    }
    public ArrayList<String> getDates(String movie){
    	ArrayList<String> temp = new ArrayList<String>();
    	String sqlcommand = "SELECT day\n"
    			+ "FROM performances \n"
    			+ "WHERE movie_name='" + movie + "'";
    	
    	Statement st;
    	ResultSet rs;
    	try {
    		st = conn.createStatement();
			rs = st.executeQuery(sqlcommand);
			while (rs.next()){
				temp.add(rs.getString("day"));
				
			}
			return temp;
			
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}
		return null;
    	
    }
    
    public int getFreeSeats(String theater) {
    	String sql =
    				"SELECT seats\n"
    			+ 	"FROM theaters\n"
    			+ 	"WHERE name = '" + theater + "'";
    	
    	Statement st;
    	ResultSet rs;
    	
    	try {
    		st = conn.createStatement();
    		rs = st.executeQuery(sql);
    		
    		if(!rs.next()) {
    			return 0;
    		}
    		
    		return rs.getInt("seats");
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return -1;
    }
    
    public ArrayList<String> getMovieInformation(String movie, String day) {
    	ArrayList<String> information = new ArrayList<>();
    	
    	String sql =
    			  "SELECT *\n"
    			+ "FROM performances\n"
    			+ "WHERE day = '" + day + "'\n"
    			+ "	AND movie_name = '" + movie + "'";
    	
    	Statement st;
    	ResultSet rs;
    	try {
    		st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			if(!rs.next()) {
				return null;
			}
			
			information.add(rs.getString("movie_name"));
			information.add(rs.getString("day"));
			information.add(rs.getString("theater_name"));
			
			int bookings = getSeats(movie, day);
			int seats = getFreeSeats(information.get(2)) - bookings;
			//int seats = rs.getInt("theater_seats") - getSeats(movie, day);
			
			information.add(Integer.toString(seats));
			
			return information;
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
    public int createReservation(String name, String day){
    	String user = CurrentUser.instance().getCurrentUserId();
    	String sql = "INSERT INTO reservations " 
  
    				+ "VALUES(null, '" + name + "', '" + day+ "', '" + user + "')";

    	String sql2 = "SELECT reservation_number\n"
    				+ "FROM reservations \n"
    				+ "WHERE movie_name= '" + name + "'\n"
    				+ "AND day = '" + day + "'\n"
    				+ "AND username = '" + user + "'\n"; 
    				
    				Statement st;
    		    	ResultSet rs;
    		    	try {
    		    		conn.setAutoCommit(false);
    		    		st = conn.createStatement();
    		    		PreparedStatement ps = conn.prepareStatement(sql);
    		    		int result = ps.executeUpdate();
    		    		rs = st.executeQuery(sql2);	
    					int nbr = 0;
    					
    					if(result == 0) {
    						conn.rollback();
 
    					}
    					
    					else {
    						while(rs.next()) {
        						nbr = rs.getInt("reservation_number");
        					}
    						
    						conn.commit();
    					}
    					
    					conn.setAutoCommit(true);
    					
    					return nbr;
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
    	return 0;
    }
    
    private int getSeats(String movie, String day) {
    	String sql =
	  			  "SELECT COUNT(*) as bookings\n"
	  			+ "FROM reservations\n"
	  			+ "WHERE day = '" + day + "'\n"
	  			+ "	AND movie_name = '" + movie + "'";
	  	
	  	Statement st;
	  	ResultSet rs;
	  	try {
	  		st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				return rs.getInt("bookings");
	  	}catch (SQLException e) {
	  		e.printStackTrace();
	  	}
	  	
	  	return -1;
	}

    /* --- insert own code here --- */
}
