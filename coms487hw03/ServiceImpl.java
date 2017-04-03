import java.rmi.Naming;
import java.rmi.server.*; 
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl extends UnicastRemoteObject implements IService {
	public ServiceImpl() throws Exception {
		super();
	}

	public boolean BeaconListener(Beacon b) throws Exception {
		boolean inList = false;
		for (int i = 0; i < GlobalValue.BeaconList.size(); i++) {
			if (GlobalValue.BeaconList.get(i).ID == b.ID) {
				inList = true;
				GlobalValue.BeaconTimeRecorder.set(i, GlobalValue.std_TimeRecorder);
				break;
			}
		}
		if (!inList) {
			GlobalValue.BeaconList.add(b);
			GlobalValue.BeaconTimeRecorder.add(GlobalValue.std_TimeRecorder);
			System.out.println("Receive new Client with ID " + b.ID);
			System.out.println("The Cmd Port is: " + b.CmdAgentID);

			//If detect a beacon sent from new Client, RMI client' function
			JNI(b);
		}
		return inList;
	}

	public void JNI(Beacon b) throws Exception {
		System.out.println("I am trying to look up GetLocalTime and Version");
		try {

		IClient obj = (IClient) Naming.lookup(b.CmdAgentID);
		
		GetLocalTime gt = new GetLocalTime();
        gt = (GetLocalTime)obj.execute("GetLocalTime", gt);

        GetVersion go = new GetVersion();
        go = (GetVersion)obj.execute("GetVersion", go);
        System.out.println("Client Local Time: "+gt.time);
        System.out.println("Client Version: "+go.version);

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();	
		}	

	}


}