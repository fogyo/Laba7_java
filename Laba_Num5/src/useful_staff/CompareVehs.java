package useful_staff;

import contract.Vehicle;

public class CompareVehs {

	public Vehicle compare(Vehicle vehicle1, Vehicle vehicle2) {
		float engPow1 = vehicle1.getEnginePower();
		float engPow2 = vehicle2.getEnginePower();
		long cap1 = vehicle1.getCapacity();
		long cap2 = vehicle2.getCapacity();
		float sum1 = (float) cap1 + engPow1;
		float sum2 = (float) cap2 + engPow2;
		if (sum1 >= sum2) {
			return vehicle1;
		}
		else {
			return vehicle2;
		}
	}
}
