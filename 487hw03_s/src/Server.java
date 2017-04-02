
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import java.rmi.server.*;
import java.util.ArrayList;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Remote {
	public static void main(String args[]) throws Exception {
		//create a agent monitor to detect beacon
		AgentMonitor m = new AgentMonitor();
		m.start();

		System.out.println("Waiting Server to register...");

		//Server registers
		ServiceImpl impl = new ServiceImpl();
		Naming.rebind("LISTENER", impl);
//		ServiceImpl impl = new ServiceImpl();
//		Registry registry = LocateRegistry.getRegistry();
//		registry.bind("BLISTENER", impl);

		System.out.println("You can start Clients now!");
	}
}

class GlobalValue {
	private GlobalValue() {
	};

	static ArrayList<Integer> BeaconList = new ArrayList<Integer>();
	static ArrayList<Integer> BeaconTimeRecorder = new ArrayList<Integer>();
	static int std_TimeRecorder = 0;
	static boolean canStartCmd = false;
	static boolean canStartCmdRegister = false;
}

class AgentMonitor extends Thread {
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				GlobalValue.std_TimeRecorder++;
				//System.out.println(GlobalValue.std_TimeRecorder);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < GlobalValue.BeaconTimeRecorder.size(); i++) {
				if (GlobalValue.std_TimeRecorder == GlobalValue.BeaconTimeRecorder.get(i) + 10)
					System.out.println("A Client is dead!(more than two beacons are missing) ");
			}
		}
	}
}