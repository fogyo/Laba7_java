package contract;

import java.io.Serializable;

public class Vehicle implements Serializable, Comparable<Vehicle>{
    private long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private String creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int enginePower; //Значение поля должно быть больше 0
    private int capacity; //Поле может быть null, Значение поля должно быть больше 0
    private VehicleType type; //Поле не может быть null
    private FuelType fuelType; //Поле может быть null
    
    public Vehicle(long id, String name, Coordinates cords,String creationDate, int enginePower, int capacity,VehicleType type, FuelType fuelType) {
    	this.id = id;
    	this.name = name;
    	this.creationDate = creationDate;
    	coordinates = cords;
    	this.enginePower = enginePower;
    	this.capacity = capacity;
    	this.type = type;
    	this.fuelType = fuelType;
    }
    
    public long getId() {
    	return id;
    }
    public String getName() {
    	return name;
    }
    public Coordinates getCoordinates() {
    	return coordinates;
    }
    public String getCreationDate(){
    	return creationDate;
    }
    public int getEnginePower() {
    	return enginePower;
    }
    public int getCapacity() {
    	return capacity;
    }
    public VehicleType getVehicleType() {
    	return type;
    }
    public FuelType getFuelType() {
    	return fuelType;
    }
    public void setId(long id) {
    	this.id = id;
    }
    
    @Override
    public int compareTo(Vehicle veh) {
    	String name1 = this.name;
    	String name2 = veh.getName();
    	int sum1 = 0;
    	int sum2 = 0;
    	for (int i = 0; i < min(name1.length(), name2.length()); i++) {
    		sum1 += (int) name1.charAt(i);
    	}
    	for (int i = 0; i < min(name1.length(), name2.length()); i++) {
    		sum2 += (int) name2.charAt(i);
    	}
    	return sum1 - sum2;
    }
    
    private int min(int a, int b) {
    	if (a<b) {
    		return a;
    	}
    	else {
    		return b;
    	}
    }
    
}