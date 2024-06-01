package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBFunc {
	
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
	
	public void createCollectionTable(Connection conn) {
		Statement statement;
		try {
			String sql = "CREATE TABLE IF NOT EXISTS public.collection\r\n"
					+ "(\r\n"
					+ "    key bigint NOT NULL,\r\n"
					+ "    id_coll bigint NOT NULL,\r\n"
					+ "    name text COLLATE pg_catalog.\"default\" NOT NULL,\r\n"
					+ "    \"x_сoordinate\" bigint NOT NULL,\r\n"
					+ "    y_coordinate bigint NOT NULL,\r\n"
					+ "    date text COLLATE pg_catalog.\"default\" NOT NULL,\r\n"
					+ "    engine_power bigint NOT NULL,\r\n"
					+ "    capacity bigint NOT NULL,\r\n"
					+ "    vehicle_type text COLLATE pg_catalog.\"default\" NOT NULL,\r\n"
					+ "    fuel_type text COLLATE pg_catalog.\"default\" NOT NULL,\r\n"
					+ "    CONSTRAINT collection_pkey PRIMARY KEY (id_coll)\r\n"
					+ ")\r\n"
					+ "\r\n"
					+ "TABLESPACE pg_default;\r\n"
					+ "\r\n"
					+ "ALTER TABLE IF EXISTS public.collection\r\n"
					+ "    OWNER to postgres";
			statement = conn.createStatement();
			statement.executeUpdate(sql);
		}catch (Exception e){				
		}		
	}
		
	public void createUsersTable(Connection conn) {
		Statement statement;
		try {
			String sql = "CREATE TABLE IF NOT EXISTS public.users\r\n"
					+ "(\r\n"
					+ "    user_id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),\r\n"
					+ "    login text COLLATE pg_catalog.\"default\" NOT NULL,\r\n"
					+ "    password text COLLATE pg_catalog.\"default\" NOT NULL,\r\n"
					+ "    CONSTRAINT \"Users_pkey\" PRIMARY KEY (user_id)\r\n"
					+ ")\r\n"
					+ "\r\n"
					+ "TABLESPACE pg_default;\r\n"
					+ "\r\n"
					+ "ALTER TABLE IF EXISTS public.users\r\n"
					+ "    OWNER to postgres;";
			statement = conn.createStatement();
			statement.executeUpdate(sql);
		}catch (Exception e){				
		}				
	}
			
	public void createProxyTable(Connection conn) {
		Statement statement;
		try {
			String sql = "CREATE TABLE IF NOT EXISTS public.proxy\r\n"
					+ "(\r\n"
					+ "    user_id bigint NOT NULL,\r\n"
					+ "    coll_id bigint NOT NULL,\r\n"
					+ "    CONSTRAINT coll_con FOREIGN KEY (coll_id)\r\n"
					+ "        REFERENCES public.collection (id_coll) MATCH SIMPLE\r\n"
					+ "        ON UPDATE NO ACTION\r\n"
					+ "        ON DELETE CASCADE\r\n"
					+ "        NOT VALID,\r\n"
					+ "    CONSTRAINT user_con FOREIGN KEY (user_id)\r\n"
					+ "        REFERENCES public.users (user_id) MATCH SIMPLE\r\n"
					+ "        ON UPDATE NO ACTION\r\n"
					+ "        ON DELETE NO ACTION\r\n"
					+ ")\r\n"
					+ "\r\n"
					+ "TABLESPACE pg_default;\r\n"
					+ "\r\n"
					+ "ALTER TABLE IF EXISTS public.proxy\r\n"
					+ "    OWNER to postgres;";
			statement = conn.createStatement();
			statement.executeUpdate(sql);
		}catch (Exception e){		
		}
	}
}
