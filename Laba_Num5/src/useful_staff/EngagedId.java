package useful_staff;

import java.util.HashMap;

public class EngagedId {
	
	public EngagedId() {
	}
	
	public static int addId() {
		int id =0;
		for (int i = 1; i<VehicleList.idArr.size(); i++) {
			
			if (VehicleList.idArr.get(i).equals("Free")) {
				VehicleList.idArr.put(i, "Engaged");
				id = i;
				return id;
			}
		}
		if (id == 0){
			id = VehicleList.idArr.size()+1;
			VehicleList.idArr.put(id, "Engaged");
			return id;
		}
		return 0;
	}
	public static void removeId(int id) {
		VehicleList.idArr.put(id, "Free");
	}
	
	public static void removeAllIds() {
		for (int i = 1; i<VehicleList.idArr.size();i++) {
			VehicleList.idArr.put(i, "Free");
		}
	}
	public static void busiedId(int id) {
		VehicleList.idArr.put(id, "Engaged");
	}
	
}
