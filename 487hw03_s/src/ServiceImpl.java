import java.rmi.Naming;
import java.rmi.server.*; 
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl extends UnicastRemoteObject implements IService {
	public ServiceImpl() throws Exception {
		super();
	}

	public boolean BeaconListener(int n) throws Exception {
		boolean inList = false;
		for (int i = 0; i < GlobalValue.BeaconList.size(); i++) {
			if (GlobalValue.BeaconList.get(i) == n) {
				inList = true;
				GlobalValue.BeaconTimeRecorder.set(i, GlobalValue.std_TimeRecorder);
				break;
			}
		}
		if (!inList) {
			GlobalValue.BeaconList.add(n);
			GlobalValue.BeaconTimeRecorder.add(GlobalValue.std_TimeRecorder);
			System.out.println("this is " + n);

			//If detect a beacon sent from new Client, RMI client' function
			GetLocalTime();
		}
		return inList;
	}

	public void GetLocalTime() throws Exception {
		System.out.println("I am try to look up GetLocalTime");

		IClient obj = (IClient) Naming.lookup("CMDER");
		int getTime = obj.GetLocalTime();
		System.out.println("The Time is : " + getTime);

	}

}