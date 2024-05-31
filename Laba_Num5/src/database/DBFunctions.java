package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import contract.Vehicle;



public class DBFunctions {
	
	protected static ArrayList<String> usernames = new ArrayList<>();
	protected static ArrayList<String> passwords = new ArrayList<>();
	protected static HashSet<Integer> UIds = new HashSet<>();
	
	public Connection connection_to_db(String dbname, String user, String pass) {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname, user, pass);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}	
	
	public void add_vehicle(Connection conn, int key, Vehicle vehicle, int UID) {
		Statement statement_collection;
		Statement statement_proxy;
		try {
			String sql_into_collection_table = String.format("INSERT INTO collection VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", key, vehicle.getId(), vehicle.getName(), vehicle.getCoordinates().getX(), 
					vehicle.getCoordinates().getY(), vehicle.getCreationDate(), vehicle.getEnginePower(), vehicle.getCapacity(),
					vehicle.getVehicleType(), vehicle.getFuelType());
			statement_collection = conn.createStatement();
			statement_collection.executeUpdate(sql_into_collection_table);
			
			String sql_into_proxy_table = String.format("INSERT INTO proxy (user_id, coll_id) VALUES ('%s', '%s')", UID, vehicle.getId());
			statement_proxy = conn.createStatement();
			statement_proxy.executeUpdate(sql_into_proxy_table);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void add_user(Connection conn, String name, String password) {
		Statement statement;
		try {
			String sql = "INSERT INTO users (login, password) VALUES ('"+name+"', '"+password+"')";
			statement = conn.createStatement();
			statement.executeUpdate(sql);
			usernames.add(name);
			passwords.add(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public UsersRow search_by_username(Connection conn, String name) {
		Statement statement;
		try {
			String sql = String.format("SELECT * FROM users WHERE login IN ('%s')", name);
			ResultSet rs = null;
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				UsersRow usr = new UsersRow(Integer.parseInt(rs.getString(1)), name, rs.getString(3));
				return usr;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Integer> read_coll_data(Connection conn) {
		Statement statement;
		ResultSet rs = null;
		ArrayList<Integer> IDs = new ArrayList<>();
		try {
			String sql = "SELECT * FROM collection";
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while(rs.next()) {
				IDs.add(Integer.parseInt(rs.getString(2)));
			}
			return IDs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Integer> get_available_els(Connection conn, int UID){
		Statement statement;
		ArrayList<Integer> AvailableIds = new ArrayList<>();
		ResultSet rs = null;		
		try {
			String sql = String.format("SELECT * FROM proxy WHERE user_id IN ('%s')", UID);
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while(rs.next()) {
				AvailableIds.add(Integer.parseInt(rs.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AvailableIds;
	}
	
	/*public ArrayList<Integer> getCollectionIds(Connection conn){
		Statement statement;
		ArrayList<Integer >
	}*/
	
	public void delete_row_by_id(Connection conn, Integer id) {
		Statement statement;
		try {
			String sql = String.format("DELETE FROM collection WHERE id_coll='%s'", id);
			statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String read_vehicle(Connection conn, Integer id) {
		Statement statement;
		String vehicle = "";
		String key = "";
		ResultSet rs = null;		
		try {
			String sql = String.format("SELECT * FROM collection WHERE id_coll IN ('%s')", id);
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while(rs.next()) {
				key = rs.getString(1);
				vehicle = rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8) 
				+ " " + rs.getString(9) + " " + rs.getString(10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key + "*" + vehicle;
	}
	
	
}


