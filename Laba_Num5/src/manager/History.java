package manager;

import useful_staff.VehicleList;

public class History extends Command{

	private String str;
	
	@Override
	public void run() {
		str = VehicleList.history.toString();
	}
	
	public String getString() {
		return str;
	}
}
