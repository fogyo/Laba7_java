/*package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import contract.Validator;
import contract.Vehicle;
import contract.VehicleConverter;
import server.Server;
import useful_staff.ScriptList;


public class ExecuteScript extends Command{

	protected static String filename;
	protected static int lineNum = 0;
	
	private String strex = "Script file used recently";
	private String str;
	
	public ExecuteScript(String filename) {
		this.filename = filename;
	}
	
	@Override
	public void run() {
		Server.script = true;
		str = "";
		boolean flag = true;
		for(int i = 0; i<ScriptList.scr_lst.size();i++) {
			
			if (ScriptList.scr_lst.get(i).equals(filename)) {
				flag = false;
			}
		}
		if (flag) {
			ScriptList.scr_lst.add(filename);
			File file = new File(filename);
			Validator vd = new Validator();
			try {
				Scanner sc = new Scanner(file);
				while(sc.hasNextLine()) {
					String sreq = sc.nextLine();
					int num_args = vd.commandValidator(sreq);
					lineNum = lineNum + 1;
					try {
						if (num_args == 2){
							Response response = new Response();
							VehicleConverter vc = new VehicleConverter();
		    				Vehicle vehicle = vc.StrToVeh(response.getArgumentsFromFile(filename));
		    				CommandManager cm = new CommandManager(sreq.split(" ")[0], num_args, sreq.split(" ")[1], vehicle);
							cm.startCommand();
							str = str + cm.getCMS() + "\n";
						}
						else if(num_args == 1) {
							CommandManager cm = new CommandManager(sreq.split(" ")[0], num_args, sreq.split(" ")[1], null);
							cm.startCommand();
							str = str + cm.getCMS() + "\n";
						}
						else if(num_args == 0) {
							CommandManager cm = new CommandManager(sreq.split(" ")[0], num_args, null, null);
							cm.startCommand();
							str = str + cm.getCMS() + "\n";
						}
						
					}
					catch(NullPointerException e) {
					}
				}
	
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ScriptList.scr_lst.remove(filename);
		}	
		else {
			str = str + strex + "\n";
		}
		
		Server.script = false;
	}
	public String getString() {
		return str;
	}
}*/
