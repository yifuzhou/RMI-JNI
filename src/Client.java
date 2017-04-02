
//@author Yifu Zhou
//created by Mar 30 2017

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Client {
	public static void main(String args[]) throws Exception {
		String port = args[0];
		// String port = "22";

		int beacon = Integer.parseInt(port);

		ServiceImpl impl = new ServiceImpl();
		Naming.rebind("CMD", impl);
//		ClientImpl impl = new ClientImpl();
//		Registry registry = LocateRegistry.getRegistry();
//		registry.bind("CMD", impl);
		System.out.println("Cmd Start!");

		while (true) {
			IService obj = (IService) Naming.lookup("LISTENER");
			
			boolean isInList = obj.BeaconListener(beacon);

			// System.out.println("This is isInList :" + isInList);

			// System.out.println(GlobalValue.canStartCmdRegister);
			// if (!isInList) {
			// CmdRegister c = new CmdRegister();
			// c.start();
			// }

			// if (GlobalValue.canStartCmdRegister) {
			// System.out.println("Before Cmd");
			// //CmdRegister c = new CmdRegister();
			// //c.start();
			// }
			// System.out.println("The ID is :" + s);

		}

	}
}

class CmdRegister extends Thread {
	public CmdRegister() throws Exception {
		System.out.println("In Cmd");
		ClientImpl impl = new ClientImpl();

		Registry registry = LocateRegistry.getRegistry();
		registry.bind("CMD", impl);

		System.out.println("Cmd Start!");
	}

}
