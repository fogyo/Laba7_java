package manager;

import java.util.HashSet;

import contract.Vehicle;
import useful_staff.VehicleList;

public class PrintUniqueCapacity extends Command{

	private String str;
	@Override
	public void run() {
		HashSet<Integer> capSet = new HashSet<>();
		for (Integer key : VehicleList.vehList.keySet()) {
			Vehicle vehicle = VehicleList.vehList.get(key);	
			capSet.add(vehicle.getCapacity());
		}
		str = capSet.toString();
	}
	
	public String getString() {
		return str;
	}

}
