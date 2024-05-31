package manager;


import contract.Vehicle;
import useful_staff.VehicleList;

public class SumOfEnginePower extends Command{

	private String str;
	
	@Override
	public void run(){
		float sum = 0;
		for (Integer key : VehicleList.vehList.keySet()) {
			Vehicle vehicle = VehicleList.vehList.get(key);
			sum = sum + vehicle.getEnginePower();
		}
		str = String.valueOf(sum);
	}

	public String getString() {
		return str;
	}
	
}
