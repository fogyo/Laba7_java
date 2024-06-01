package main;

import java.sql.Connection;

public class CreateDB {

	public static void main(String[] args) {
		DBFunc db = new DBFunc();
    	Connection connect = db.connection_to_db("test", "postgres", "1234");
    	db.createCollectionTable(connect);
    	db.createUsersTable(connect);
    	db.createProxyTable(connect);
	}

}
