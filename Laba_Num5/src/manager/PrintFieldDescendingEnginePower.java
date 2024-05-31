package manager;

import java.util.Arrays;
import java.util.Collections;

import useful_staff.VehicleList;

public class PrintFieldDescendingEnginePower extends Command{

	private String str;
	
	@Override
	public void run() {
		str = "";
		Integer[] engPowArr = new Integer[100];
		int k = 0;
		for (Integer key : VehicleList.vehList.keySet()) {
			engPowArr[k] = VehicleList.vehList.get(key).getEnginePower();
			k = k + 1;
		}
		Arrays.sort(engPowArr, Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			str = str + engPowArr[i].toString()+" ";
		}
	}
	
	public String getString() {
		return str;
	}

}
