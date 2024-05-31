package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import contract.Vehicle;
import contract.VehicleConverter;
import database.UserInfo;
import server.Server;
import useful_staff.CompareVehs;
import useful_staff.EngagedId;
import useful_staff.ProgramStarter;
import useful_staff.VehicleList;

public class ReplaceIfGreater extends Command{
	
	private Integer key;
	private Vehicle vehicle;
	private UserInfo uf;
	private String str;
	
	public ReplaceIfGreater(Integer key, Vehicle vehicle, UserInfo uf) {
		this.key = key;
		this.uf = uf;
		this.vehicle = vehicle;
	}

	@Override
	public void run() {
		ArrayList<Integer> AvaIDs = Server.db.get_available_els(uf.getConn(), uf.getUID());
		int id = (int) VehicleList.vehList.get(key).getId();
		if (AvaIDs.contains(id)) {
			CompareVehs cv = new CompareVehs();
			VehicleConverter vc = new VehicleConverter();
			Vehicle vehicle2 = VehicleList.vehList.get(key);
			if (cv.compare(vehicle, vehicle2).equals(vehicle2)) {
				str = "Didn't replace cause the second element is smaller";
			}
			else {
				Server.db.delete_row_by_id(uf.getConn(), id);
				EngagedId.removeId(id);
				VehicleList.vehList.remove(key);
				
				vehicle.setId(EngagedId.addId());	
				VehicleList.vehList.put(key, vehicle);					
				Server.db.add_vehicle(uf.getConn(), key, vehicle, uf.getUID());
				str = "Element replaced successfully";
			}
				
		}
	}
	
	public String getString() {
		return str;
	}
}
