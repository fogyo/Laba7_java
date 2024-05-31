package manager;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import contract.Vehicle;
import contract.VehicleConverter;
import useful_staff.VehicleList;

public class Show extends Command{
	
	private String str;

	@Override
	public void run() {
		String strToPrint = "";
		HashMap<Integer, Vehicle> sortedVehList = VehicleList.vehList.entrySet().stream().sorted(Entry.comparingByValue()).collect(Collectors.toMap(Entry::getKey, Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));
		VehicleConverter vc = new VehicleConverter();
		for (Integer key : sortedVehList.keySet()) {
			Vehicle vehicle = sortedVehList.get(key);
			strToPrint = strToPrint+key.toString()+" "+vc.VehToStr(vehicle)+"\n"; 
		}
		str = "Collection\n"+strToPrint;
	}
	
	public String getString() {
		return str;
	}

}
