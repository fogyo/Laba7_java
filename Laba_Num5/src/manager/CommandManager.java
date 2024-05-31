package manager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import contract.Vehicle;
import contract.VehicleConverter;
import database.UserInfo;
import server.Server;
import useful_staff.SizedQue;
import useful_staff.VehicleList;

public class CommandManager {
	
	private String strCommand;
	private String args;
	private Vehicle vehicle;
	private int numargs;
	private String reply = "";
	private UserInfo uf;
	
	public CommandManager(String strCommand, int numargs, String args, Vehicle vehicle, UserInfo uf) {
		this.strCommand = strCommand;
		this.args = args;
		this.vehicle = vehicle;
		this.numargs = numargs;
		this.uf = uf;
	}
	
	public void startCommand() {
		VehicleConverter vc = new VehicleConverter();
		if (commList.containsKey(strCommand)==true) {
			reply="";
			VehicleList.history.add(strCommand);
			String[] adress = commList.get(strCommand).toString().split(" ");
	
	//0 аргов			
			if (numargs == 0) { 
				try {
					Class clazz = Class.forName(adress[1]);
					
					Method run = null;
					Method getString = null;
					try {
						run = clazz.getDeclaredMethod("run");
						getString = clazz.getDeclaredMethod("getString");
					} catch (NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
					Object command = clazz.newInstance();
					run.invoke(command);
					reply = reply + getString.invoke(command) + " ";
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				}	         
			}
			
	//1 аргумент, UserInfo (Conn, UID)		
			else if(numargs == 1) {
				try {
					Class clazz = Class.forName(adress[1]);
					
					Class[] oneArg = {UserInfo.class};
					Method run = null;
					Method getString = null;
					try {
						run = clazz.getDeclaredMethod("run");
						getString = clazz.getDeclaredMethod("getString");
						Object command = clazz.getConstructor(oneArg).newInstance(uf);
						run.invoke(command);
						reply = reply + getString.invoke(command) + " ";
					} catch (NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
	
					
				
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				}
			}
			
	//2 аргумента (Integer - ключ, int UID) 
			else if(numargs == 2) {
	
				if (Server.script == false) {
					try {
						Class clazz = Class.forName(adress[1]);
						Integer key = Integer.parseInt(args);
						Class[] twoArgs = {Integer.class, UserInfo.class};
						Method run = null;
						Method getString = null;
						try {
							run = clazz.getDeclaredMethod("run");
							getString = clazz.getDeclaredMethod("getString");
							try {
								Object command = clazz.getConstructor(twoArgs).newInstance(key, uf);
								run.invoke(command);
								reply = reply + getString.invoke(command) + " ";
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
									| InstantiationException e) {
							}
						} catch (NoSuchMethodException | SecurityException e) {
						}
					} catch (ClassNotFoundException e) {
					}
				}
				else {
					try {
						Class clazz = Class.forName(adress[1]);
						Integer key = Integer.parseInt(args);
						Class[] twoArgs = {Integer.class, Vehicle.class};
						Method run = null;
						Method getString = null;
						try {
							run = clazz.getDeclaredMethod("run");
							getString = clazz.getDeclaredMethod("getString");
							try {
								Object command = clazz.getConstructor(twoArgs).newInstance(key, vehicle);
								run.invoke(command);
								reply = reply + getString.invoke(command) + " ";
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
									| InstantiationException e) {
								e.printStackTrace();
							}
						} catch (NoSuchMethodException | SecurityException e) {
							e.printStackTrace();
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
			else if(numargs == 3) {
				try {
					Class clazz = Class.forName(adress[1]);
					Integer key = Integer.parseInt(args);
					Class[] threeArgs = {Integer.class, Vehicle.class, UserInfo.class};
					Method run = null;
					Method getString = null;
					try {
						run = clazz.getDeclaredMethod("run");
						getString = clazz.getDeclaredMethod("getString");
						try {
							Object command = clazz.getConstructor(threeArgs).newInstance(key, vehicle, uf);
							run.invoke(command);
							reply = reply + getString.invoke(command) + " ";
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
								| InstantiationException e) {
						}
					} catch (NoSuchMethodException | SecurityException e) {
					}
				} catch (ClassNotFoundException e) {
				}
			}
		}
	}
	
	
	private static final HashMap<String, Class> commList = new HashMap<>() {{
		put("help", Help.class);
		put("show", Show.class);
		put("insert", Insert.class);
		put("info", Info.class);
		put("update", Update.class);
		put("remove_key", RemoveKey.class);
		put("clear", Clear.class);
		//put("save", Save.class);
		//put("execute_script", ExecuteScript.class);
		put("exit", Exit.class);
		put("history", History.class);
		put("replace_if_greater", ReplaceIfGreater.class);
		put("remove_lower_key", RemoveLowerKey.class);
		put("sum_of_engine_power", SumOfEnginePower.class);
		put("print_unique_capacity", PrintUniqueCapacity.class);
		put("print_field_descending_engine_power", PrintFieldDescendingEnginePower.class);
	}};
	
	public String getCMS() {
		return reply;
	}

}
