package manager;

import useful_staff.ProgramStarter;
import useful_staff.VehicleList;

public class Info extends Command{

	private String str;
	
	@Override
	public void run() {
		String number = String.valueOf(VehicleList.vehList.size());
		String type = "Vehicle";
		String date = "2005";
		str = "Type: " + type + "\nNumber: " + number + "\nDate: " + date;
	}
	
	public String getString() {
		return str;
	}

}
