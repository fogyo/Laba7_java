package manager;


import java.util.ArrayList;

import database.UserInfo;
import server.Server;
import useful_staff.EngagedId;
import useful_staff.VehicleList;

public class Clear extends Command{

	private String str = "Permitted items were cleared";
	private UserInfo uf;
	
	public Clear(UserInfo uf) {
		this.uf = uf;
	}
	
	@Override
	public void run() {
		ArrayList<Integer> AvailableIds = Server.db.get_available_els(uf.getConn(), uf.getUID());
		for (Integer i : AvailableIds) {
			Server.db.delete_row_by_id(uf.getConn(), i);
			EngagedId.removeId(i);
			Integer key = VehicleList.getKeyByID((long) i);
			VehicleList.vehList.remove(key);
		}
	}
	public String getString() {
		return str;
	}
}
