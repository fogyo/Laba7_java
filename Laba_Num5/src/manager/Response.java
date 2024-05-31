/*package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.util.Scanner;

import useful_staff.EngagedId;
import useful_staff.ProgramStarter;
import useful_staff.VehicleList;

public class Response {
	
	
	public String getArgumentsFromFile(String filename) {
		File file = new File(filename);
		int lineNum = 0;
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNext()) {
				String name = sc.nextLine();
				lineNum = lineNum + 1;
				if (lineNum>ExecuteScript.lineNum) {
					String strVeh = "";
					
					Long id = EngagedId.addId();
					strVeh = strVeh+id.toString()+" ";
					
					
					strVeh = strVeh+name+" ";
					
					String x = ""; 
					x = x + sc.nextLine();
					strVeh = strVeh+x+" ";	
					
					
					String y = "";
					y = y + sc.nextLine();
					strVeh = strVeh + y + " "; 
					
					ZonedDateTime now = ZonedDateTime.now();
					strVeh = strVeh+now.toString()+" ";
					
					String engPow = "";		
					engPow = engPow + sc.nextLine();
					strVeh = strVeh + engPow + " "; 
								
					String cap = "";
					cap = cap + sc.nextLine();	
					strVeh = strVeh + cap + " "; 
					
					String vehType = "";
					vehType = vehType + sc.nextLine();
					strVeh = strVeh+vehType+" ";
					
					String fuelType = "";
					fuelType = fuelType + sc.nextLine();
					strVeh = strVeh+fuelType+" ";
					return strVeh;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}	
}*/
