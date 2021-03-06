
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
		try {
		ServiceImpl impl = new ServiceImpl();
		Naming.rebind("LISTENER", impl);

		System.out.println("You can start Clients now!");
		}
		catch (Exception e) {
		      e.printStackTrace();
		    }
	}
}

class GlobalValue {
	private GlobalValue() {
	};

	static ArrayList<Beacon> BeaconList = new ArrayList<Beacon>();
	static ArrayList<Integer> BeaconTimeRecorder = new ArrayList<Integer>();
	static int std_TimeRecorder = 0;
}
/*
 * Agent Monitor, to detect received beacon
 * If the beacon is already in the list, updata received time
 * If not, add into the list
 * If do not receive the same beacon for 20 seconds, output that client is dead  
 */
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
				if (GlobalValue.std_TimeRecorder == GlobalValue.BeaconTimeRecorder.get(i) + 20) {
					System.out.println("A Client is dead!(do not receive beacon for 20 seconds) ");
					GlobalValue.BeaconList.remove(i);
					GlobalValue.BeaconTimeRecorder.remove(i);
				}
			}
		}
	}
}