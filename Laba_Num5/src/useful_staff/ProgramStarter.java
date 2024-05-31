package useful_staff;

import java.sql.Connection;
import java.util.ArrayList;

import contract.Vehicle;
import contract.VehicleConverter;
import server.Server;

public class ProgramStarter {
	
	private Connection conn;
	
	public ProgramStarter(Connection conn){
		this.conn = conn;
	}
	
	public void startProgram() {
		VehicleConverter vc = new VehicleConverter();
		ArrayList<Integer> IDs = Server.db.read_coll_data(conn);
		
		for (Integer i : IDs) {
			String key_veh = Server.db.read_vehicle(conn, i);
			Integer key = Integer.parseInt(key_veh.split("\\*")[0]);
			String veh_String = key_veh.split("\\*")[1];
			Vehicle vehicle = vc.StrToVeh(veh_String);
			VehicleList.vehList.put(key, vehicle);
			EngagedId.busiedId(i);
		}
		
		
	}
}
	
	
