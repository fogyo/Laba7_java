package contract;

import java.time.ZonedDateTime;


public class VehicleConverter {
	
	
	
	public String VehToStr(Vehicle vehicle) {
		String vehStr = String.valueOf(vehicle.getId())+" "
	+vehicle.getName()+" "+String.valueOf(vehicle.getCoordinates().getX())
	+" "+String.valueOf(vehicle.getCoordinates().getY())+" "+vehicle.getCreationDate()
	+" "+String.valueOf(vehicle.getEnginePower())+" "+String.valueOf(vehicle.getCapacity())+" "
	+vehicle.getVehicleType().toString()+" "+vehicle.getFuelType().toString();
		return vehStr;
	}
	public Vehicle StrToVeh(String vehStr) {
		String[] vehArr = vehStr.split(" ");
		Long id = Long.parseLong(vehArr[0]);
		String name = vehArr[1];
		int x = Integer.parseInt(vehArr[2]);
		int y = Integer.parseInt(vehArr[3]);
		Coordinates cords = new Coordinates(x, y);
		String now = vehArr[4];
		int enginePower = Integer.parseInt(vehArr[5]);
		int capacity = Integer.parseInt(vehArr[6]);
		
		String vehTypeStr = vehArr[7];
		VehicleType vehType = null;
		vehTypeStr = vehTypeStr.toUpperCase();
		if (vehTypeStr.equals("CAR")) {
			vehType = VehicleType.CAR;
		}
		else if(vehTypeStr.equals("DRONE")) {
			vehType = VehicleType.DRONE;
		}
		else if(vehTypeStr.equals("CHOPPER")) {
			vehType = VehicleType.CHOPPER;
		}
		else if(vehTypeStr.equals("HOVERBOARD")) {
			vehType = VehicleType.HOVERBOARD;
		}
		else if(vehTypeStr.equals("SPACESHIP")) {
			vehType = VehicleType.SPACESHIP;
		}
//		пропись эксепшенов
		
		String fuelTypeStr = vehArr[8];
		FuelType fuelType = null;
		fuelTypeStr = fuelTypeStr.toUpperCase();
		if (fuelTypeStr.equals("GASOLINE")) {
			fuelType = FuelType.GASOLINE;
		}
		else if(fuelTypeStr.equals("MANPOWER")) {
			fuelType = FuelType.MANPOWER;
		}
		else if(fuelTypeStr.equals("PLASMA")) {
			fuelType = FuelType.PLASMA;
		}
		else if(fuelTypeStr.equals("ANTIMATTER")) {
			fuelType = FuelType.ANTIMATTER;
		}
		
		Vehicle vehicle = new Vehicle(id, name, cords, now, enginePower, capacity, vehType, fuelType);
		return vehicle;
	}
	
}
