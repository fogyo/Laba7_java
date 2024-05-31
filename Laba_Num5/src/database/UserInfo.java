package database;

import java.sql.Connection;

public class UserInfo {
	
	private Connection conn;
	private int UID;
	
	public UserInfo(Connection conn, int UID) {
		this.conn = conn;
		this.UID = UID;
	}
	

	public Connection getConn() {
		return conn;
	}
	public int getUID() {
		return UID;
	}

}
