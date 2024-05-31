package useful_staff;

import java.util.HashMap;

import contract.Vehicle;



public class VehicleList {
	
	public VehicleList() {
		
	}
	public static HashMap<Integer, Vehicle> vehList = new HashMap<>();
	public static SizedQue<String> history = new SizedQue<>(13);
	
	public static HashMap <Integer, String> idArr = new HashMap<>() {{
		for (int i = 1; i<100; i++) {
			put(i, "Free");
		}
	}};
	
	public static Integer getKeyByID(long id) {
		for (Integer key : VehicleList.vehList.keySet()) {
			Vehicle vehicle = VehicleList.vehList.get(key);
			long veh_id = vehicle.getId();
			if (veh_id==id) {
				return key;
			}
		}
		return null;
	}
	
}
