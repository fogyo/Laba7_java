/*package manager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import contract.Vehicle;
import contract.VehicleConverter;
import useful_staff.HashMapToJSON;
import useful_staff.ProgramStarter;
import useful_staff.VehicleList;

public class Save extends Command{
	
	private String str = "Collection saved to file";

	@Override
	public void run() {
		VehicleConverter vc = new VehicleConverter();
		HashMapToJSON hm = new HashMapToJSON();
		String filename = ProgramStarter.filenameForAll;
		try (BufferedWriter writter = new BufferedWriter(new FileWriter(filename))) {
			writter.write("Info\n");
			writter.write(hm.writeFile("Type", ProgramStarter.getType()));
			writter.write(hm.writeFile("Number", ProgramStarter.getNumber()));
			writter.write(hm.writeFile("Date", ProgramStarter.getDate()));
			writter.write("Collection\n");
			for (Integer key : VehicleList.vehList.keySet()) {
				Vehicle vehicle = VehicleList.vehList.get(key);
				
				writter.write(hm.writeFile(key.toString(), vc.VehToStr(vehicle)));
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getString() {
		return str;
	}
}*/
