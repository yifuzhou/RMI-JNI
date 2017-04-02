//@author Yifu Zhou
//created by Mar 30 2017

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

public class Client {
	public static void main(String args[]) throws Exception 
	{
		String port = args[0];
		//String port = "22";
		
		int beacon = Integer.parseInt(port);
		while (true) {
				System.out.println(GlobalValue.canStartCmdRegister);
    		 IService obj = (IService)Naming.lookup("LISTENER");
        	 obj.BeaconListener(beacon);
        	 System.out.println(GlobalValue.canStartCmdRegister);
        	 
        	 if (GlobalValue.canStartCmdRegister) {
        		 System.out.println("Before Cmd");
        		 //CmdRegister c = new CmdRegister();
        		 //c.start();
        	 }
        	 //System.out.println("The ID is :" + s);
    		 		 
    		 }
    	  
    }
	}

class CmdRegister extends Thread {
	public CmdRegister() throws Exception {
		System.out.println("In Cmd");
		ClientImpl impl = new ClientImpl();
		LocateRegistry.createRegistry(8888);
		Naming.rebind("CMD", impl);
		System.out.println("Cmd Start!");
		GlobalValue.canStartCmd = true;
	}

}


    
