//@author Yifu Zhou
//created by Mar 30 2017

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Client {
	public static void main(String args[]) throws Exception {
//		String port = args[0];
//		// String port = "22";
//
//		int beacon = Integer.parseInt(port);
		
		Beacon b = new Beacon();
		b.setID(Integer.parseInt(args[0]));
	    b.setCmdAgent(args[1]);

	    try {
		ClientImpl impl = new ClientImpl();
		Registry registry = LocateRegistry.getRegistry();
		registry.bind(b.CmdAgentID, impl);
		System.out.println("Cmd Start!");
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	      }

		while (true) {
			try {
			IService obj = (IService) Naming.lookup("LISTENER");
			
			boolean isInList = obj.BeaconListener(b);
			}
			catch (Exception e) {
			      e.printStackTrace();
			    }

		}

	}
}

//class CmdRegister extends Thread {
//	public CmdRegister() throws Exception {
//		ClientImpl impl = new ClientImpl();
//		Registry registry = LocateRegistry.getRegistry();
//		registry.bind("CMDER", impl);
//		System.out.println("Cmd Start!");
//		while (true);
//	}
//}
//    
