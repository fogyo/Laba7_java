package contract;

import java.io.Serializable;


public class Request implements Serializable{
	
	
	private String command;
	private int argNum;
	private String args;
	private Vehicle vehicle;
	private int UID;
	
	public Request(String command, int argNum, String args, Vehicle vehicle, int UID) {
		this.command = command;
		this.args = args;
		this.vehicle = vehicle;
		this.argNum = argNum;
		this.UID = UID;
	}
	
	public String getCom() {
		return command;
	}
	public int getArgNum(){
		return argNum;
	}
	public String getArgs() {
		return args;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public int getUID() {
		return UID;
	}
	public void setCom(String command) {
		this.command = command;
	}
	public void setArgNum(int argNum) {
		this.argNum = argNum;
	}
	public void setArgs(String args) {
		this.args = args;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public void setUID(int UID) {
		this.UID = UID;
	}
}
