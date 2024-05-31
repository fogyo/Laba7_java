package manager;

import contract.Vehicle;
import database.UserInfo;
import server.Server;
import useful_staff.EngagedId;

import useful_staff.VehicleList;

public class Insert extends Command{
	
	private Integer key;
	private Vehicle vehicle;
	private UserInfo uf;
	private String str;

	public Insert(Integer key, Vehicle vehicle, UserInfo uf) {
		this.key = key;
		this.vehicle = vehicle;
		this.uf = uf;
	}

	@Override
	public void run() {	 
		vehicle.setId(EngagedId.addId());	
		VehicleList.vehList.put(key, vehicle);		
		
		Server.db.add_vehicle(uf.getConn(), key, vehicle, uf.getUID());
		
		str = "Added to collection successfully";
		
	}
	public String getString() {
		return str;
	}
}
