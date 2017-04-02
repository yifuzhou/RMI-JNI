
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;
import java.util.ArrayList;
public class Server {
 public static void main(String args[]) throws Exception {
	 
	 AgentMonitor m = new AgentMonitor();
	 m.start();

	 
	 System.out.println("Before Start!");
	 ServiceImpl impl = new ServiceImpl();
	 //LocateRegistry.createRegistry(7654);
	 Naming.rebind("LISTENER", impl);
	 System.out.println("Start!");
 }
}

class GlobalValue{
	private GlobalValue(){};
	static ArrayList<Integer> BeaconList = new ArrayList<Integer>();
	static ArrayList<Integer> BeaconTimeRecorder = new ArrayList<Integer>();
	static int std_TimeRecorder = 0;
	static boolean canStartCmd = false;
	static boolean canStartCmdRegister = false;
}

class AgentMonitor extends Thread {
	@Override
	public void run()
	{
		while (true)
		{
			try {
	            Thread.sleep(1000);
	            GlobalValue.std_TimeRecorder ++;
				//System.out.println(GlobalValue.std_TimeRecorder);
				
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			for (int i =0; i< GlobalValue.BeaconTimeRecorder.size(); i++)
			{
				if (GlobalValue.std_TimeRecorder == GlobalValue.BeaconTimeRecorder.get(i) + 10)
					System.out.println(" is dead!(more than two beacons are missing) ");
			}
		}
		
	}
}

