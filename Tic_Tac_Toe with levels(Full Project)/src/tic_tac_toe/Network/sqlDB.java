package tic_tac_toe.Network;

import java.sql.*;
import java.util.ArrayList;

public class sqlDB {
	// database parameters and credentials
	static final String USERNAME = "root";
	static final String PASSWORD = "hr";
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/tic_tac_toe";
        
        public static Boolean addUserDB(String user) {
		Connection con = null;
		int res;
		
		try {
			// connect to sql database
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		         
                        
                      // prepare sql query
		String query1 = "SELECT `id` FROM `player` WHERE `username` = ?";
		PreparedStatement statement1 = con.prepareStatement(query1);
		statement1.setString(1, user);
		
		// execute sql query
		ResultSet result1 = statement1.executeQuery(); 
		
		if (!result1.next()) {
			// prepare query
			String query = "INSERT INTO `player` (`username`) VALUES (?)";
                        
                        
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, user);
			
		
			// execute query
			res = statement.executeUpdate();
			
			
			
			// close resources
			statement.close();
			con.close();
		
			if (res == 0) {
				return false;
			} else {
				return true;
			}
		}else{
                // close connections
		result1.close();
                statement1.close();
		con.close();
                return false;
                }
		
                        
			
		} catch(SQLException se) {
			se.printStackTrace();
			return false;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			// close resources
			try {
				if (con != null) con.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
	
        }
        public static int getplayerID(String player) throws SQLException, ClassNotFoundException {
		Connection con = null;
		int playerID=0;
		
		// connect to sql database
		Class.forName(JDBC_DRIVER);
		con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	
		// prepare sql query
		String query = "SELECT `id` FROM `player` WHERE `username` = ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, player);
		
		// execute sql query
		ResultSet result = statement.executeQuery(); 
		
		while (result.next()) {
			playerID = result.getInt(1);
		}
		// close connections
		result.close();
		statement.close();
		con.close();
		
		return playerID;
	}
        
        public static String getplayerName(int player) throws SQLException, ClassNotFoundException {
		Connection con = null;
		String playerName="";
		
		// connect to sql database
		Class.forName(JDBC_DRIVER);
		con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	
		// prepare sql query
		String query = "SELECT `username` FROM `player` WHERE `id` = ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, player);
		
		// execute sql query
		ResultSet result = statement.executeQuery(); 
		
		while (result.next()) {
			playerName= result.getString(1);
		}
		// close connections
		result.close();
		statement.close();
		con.close();
		
		return playerName;
	}
        
        
        
        
        //sqlDB.addGameDB(fplayerID,splayerID,gameTimestamp,gameStatus,gameType);
        public static Boolean addGameDB(int fplayerID,int splayerID,String gameTimestamp , String gameStatus ,String gameType) {
		Connection con = null;
		int res;
		
		try {
                    System.out.println(gameTimestamp);
			// connect to sql database
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		
			// prepare query
			String query = "INSERT INTO `game` (`first_player_id`, `second_player_id`, `created`, `game_status`, `game_type`) VALUES (?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, fplayerID);
			statement.setInt(2, splayerID);
			statement.setString(3, gameTimestamp);
			statement.setString(4, gameStatus);
                        statement.setString(5, gameType);
		
			// execute query
			res = statement.executeUpdate();
			
			
			
			// close resources
			statement.close();
			con.close();
		
			if (res == 0) {
				return false;
			} else {
				return true;
			}
		} catch(SQLException se) {
			se.printStackTrace();
			return false;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			// close resources
			try {
				if (con != null) con.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
        
        public static int getgameID(String gameTimestamp) throws SQLException, ClassNotFoundException {
		Connection con = null;
                
		int gameID=0;
		
		// connect to sql database
		Class.forName(JDBC_DRIVER);
		con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	
		// prepare sql query
		String query = "SELECT `id` FROM `game` WHERE `created` = ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1,gameTimestamp );
		
		// execute sql query
		ResultSet result = statement.executeQuery(); 
		
		while (result.next()) {
			gameID = result.getInt(1);
		}
		// close connections
		result.close();
		statement.close();
		con.close();
		
		return gameID;
	}
        
         public static Boolean addmoveDB(int playerID,int gameID,int move) {
		Connection con = null;
		int res;
		
		try {
			// connect to sql database
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		
			// prepare query
			String query = "INSERT INTO `move` (`player_id`, `game_id`, `board_cell`) VALUES (?,?,?)";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, playerID);
			statement.setInt(2, gameID);
			statement.setInt(3, move);
			
		
			// execute query
			res = statement.executeUpdate();
			
			
			
			// close resources
			statement.close();
			con.close();
		
			if (res == 0) {
				return false;
			} else {
				return true;
			}
		} catch(SQLException se) {
			se.printStackTrace();
			return false;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			// close resources
			try {
				if (con != null) con.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public static String[] getHistory(int player) throws SQLException, ClassNotFoundException {
		Connection con = null;
		
		// connect to sql database
		Class.forName(JDBC_DRIVER);
		con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		
		// prepare query
		String query = "SELECT `first_player_id`,`second_player_id`,`game_status`,`created` FROM `game` WHERE `first_player_id` = ?";
		PreparedStatement statement = con.prepareStatement(query);
                statement.setInt(1,player );

		// execute query
		ResultSet result =  statement.executeQuery();
		
		// determine length of result
		int count = 0;
		result.last();
		count = result.getRow();
		result.beforeFirst();
		
		String[] historyArr = new String[count];
		int i = 0;
		while(result.next()) {
			//if (i == 0) result.first();
                        String fplayerName=getplayerName(result.getInt(1));
                                
                        String splayerName=getplayerName(result.getInt(2));
                        String gameStatus=result.getString(3);
                        String timeStamp=result.getString(4);
                        
			historyArr[i] =fplayerName+" VS "+splayerName+"  "+timeStamp;
			i++;
		}
                
		// release resources
		statement.close();
		con.close();
		return historyArr;
	}
        
         public static ResultSet getgameMoves(int playerID,int gameID) throws SQLException, ClassNotFoundException {
		Connection con = null;
                
		//int gameID=0;
		
		// connect to sql database
		Class.forName(JDBC_DRIVER);
		con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	
		// prepare sql query
		String query = "SELECT `board_cell` FROM `move` WHERE `player_id` = ? AND `game_id` = ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1,playerID );
                statement.setInt(2,gameID );
		
		// execute sql query
		ResultSet result = statement.executeQuery(); 
		/*
		while (result.next()) {
			gameID = result.getInt(1);
		}
		// close connections
		result.close();
		statement.close();
		con.close();
		*/
		return result;
	}
	
      
}
