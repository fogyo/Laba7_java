package contract;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Scanner;


public class Validator {
	
	public int commandValidator(String request) {
		if (isArgsList.containsKey(request.split(" ")[0])==true) {
			return isArgsList.get(request.split(" ")[0]);
		}
		else {
			return -1;
		}
	}
	
	public String getterVehicle() {
		boolean corFlag = false;
		Scanner sc = new Scanner(System.in);
		String strVeh = "";
		
		Long id = (long) 1;
		strVeh = strVeh+id.toString()+" ";
		
		System.out.println("Enter name");
		String name = sc.nextLine();
		strVeh = strVeh+name+" ";
		
		String x = "";
		while (corFlag == false) {
			System.out.println("Enter x");
			x = "";
			x = x + sc.nextLine();
			try {
				long xch = Long.parseLong(x);
				corFlag = true;
			}
			catch(NumberFormatException e) {
				System.out.println("x should be long");
				corFlag = false;
				}
		}
		strVeh = strVeh + x + " ";
		
		corFlag = false;
		String y = "";
		while (corFlag == false) {
			System.out.println("Enter y");
			y = "";
			y = y + sc.nextLine();
			try {
				int ych = Integer.parseInt(y);
				corFlag = true;
			}
			catch(NumberFormatException e) {
				System.out.println("y should be integer");
				corFlag = false;
				}
		}
		strVeh = strVeh + y + " "; 
		
		ZonedDateTime now = ZonedDateTime.now();
		strVeh = strVeh+now.toString()+" ";
		
		corFlag = false;
		String engPow = "";
		while (corFlag == false) {
			engPow = "";
			System.out.println("Enter engine power");
			engPow = engPow + sc.nextLine();
			try {
				float engPowCh = Float.parseFloat(engPow);
				corFlag = true;
			}
			catch(NumberFormatException e) {
				System.out.println("engine power should be float");
				corFlag = false;
				}
		}
		strVeh = strVeh + engPow + " "; 
					
		corFlag = false;
		String cap = "";
		while (corFlag == false) {
			cap = "";
			System.out.println("Enter capacity");
			cap = cap + sc.nextLine();
			try {
				long cpach = Long.parseLong(cap);
				corFlag = true;
			}
			catch(NumberFormatException e) {
				System.out.println("capacity should be long");
				corFlag = false;
				}
		}
		strVeh = strVeh + cap + " "; 
		
		corFlag = false;
		String vehType = "";
		while (corFlag == false) {		
			vehType = "";
			System.out.println("Enter vehicle type:\r\n"+"1 - CAR,\r\n"
					+ "2 - DRONE,\r\n"
					+ "3 - CHOPPER,\r\n"
					+ "4 - HOVERBOARD,\r\n"
					+ "5 - SPACESHIP;");
			String vehNumType = String.valueOf(sc.nextLine());
			if ("1 2 3 4 5".contains(vehNumType.toLowerCase())) {
				corFlag = true;
				if (vehNumType.equals("1")) {
					vehType = vehType + "car";
				}
				else if (vehNumType.equals("2")) {
					vehType = vehType + "drone";
				}
				else if (vehNumType.equals("3")) {
					vehType = vehType + "chopper";
				}
				else if (vehNumType.equals("4")) {
					vehType = vehType + "hoverboard";
				}
				else if (vehNumType.equals("5")) {
					vehType = vehType + "spaceship";
				}
			}
			else {
				System.out.println("Enter number");
			}
		}
		strVeh = strVeh+vehType+" ";
		
		corFlag = false;
		String fuelType = "";
		while (corFlag == false) {		
			fuelType = "";
			System.out.println("Enter fuel type:\r\n"+"1 - GASOLINE,\r\n"
					+ "2 - MANPOWER,\r\n"
					+ "3 - PLASMA,\r\n"
					+ "4 - ANTIMATTER;");
			String fuelNumType = String.valueOf(sc.nextLine());
			if ("1 2 3 4".contains(fuelNumType.toLowerCase())) {
				corFlag = true;
				if (fuelNumType.equals("1")) {
					fuelType = fuelType + "gasoline";
				}
				else if (fuelNumType.equals("2")) {
					fuelType = fuelType + "manpower";
				}
				else if (fuelNumType.equals("3")) {
					fuelType = fuelType + "plasma";
				}
				else if (fuelNumType.equals("4")) {
					fuelType = fuelType + "antimatter";
				}
			}
			else {
				System.out.println("Wrong type");
			}
		}
		strVeh = strVeh+fuelType+" ";
		return strVeh;
	}

	private final HashMap<String, Integer> isArgsList = new HashMap<>() {{
		put("help", 0);
		put("show", 0);
		put("insert", 3);
		put("info", 0);
		put("update", 3);
		put("remove_key", 2);
		put("clear", 1);
		//put("execute_script", 1);
		put("exit", 0);
		put("history", 0);
		put("replace_if_greater", 3);
		put("remove_lower_key", 2);
		put("sum_of_engine_power", 0);
		put("print_unique_capacity", 0);
		put("print_field_descending_engine_power", 0);
	}};
}
