
//@author Yifu Zhou
//created by Mar 30 2017

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Client {
	public static void main(String args[]) throws Exception {
		// receive beacon
		Beacon b = new Beacon();
		b.setID(Integer.parseInt(args[0]));
		b.setCmdAgent(args[1]);

		// register for CMD
		try {
			ClientImpl impl = new ClientImpl();
			Registry registry = LocateRegistry.getRegistry();
			registry.bind(b.CmdAgentID, impl);
			System.out.println("Cmd Start!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				IService obj = (IService) Naming.lookup("LISTENER");
				boolean isInList = obj.BeaconListener(b);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
