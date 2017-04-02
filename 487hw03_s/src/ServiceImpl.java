import java.rmi.Naming;
import java.rmi.server.*;
//import java.rmi.RemoteException;  
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl extends UnicastRemoteObject implements IService {

	public ServiceImpl() throws Exception {
		super();

	}

	public boolean BeaconListener(int n) throws Exception {
		boolean inList = false;
		GlobalValue.canStartCmdRegister = true;
		for (int i = 0; i < GlobalValue.BeaconList.size(); i++) {
			if (GlobalValue.BeaconList.get(i) == n) {
				inList = true;
				GlobalValue.canStartCmdRegister = false;
				GlobalValue.BeaconTimeRecorder.set(i, GlobalValue.std_TimeRecorder);
				break;
			}
		}
		if (!inList) {
			GlobalValue.BeaconList.add(n);
			GlobalValue.BeaconTimeRecorder.add(GlobalValue.std_TimeRecorder);
			System.out.println("this is " + n);
			// System.out.println(GlobalValue.canStartCmdRegister);
			GetLocalTime();
			// GetLocalTime t = new GetLocalTime();
			// t.start();
		}
		// //Question in here I cannot figue out why cannot output boolean value
		// if (inList)
		// System.out.println("hello");
		// else
		// System.out.println("hello no");

		System.out.println("Please show inList: " + inList);
		return inList;
	}

	public void GetLocalTime() throws Exception {
		System.out.println("Before GetLocalTime");

		// while (!GlobalValue.canStartCmd);
		// System.out.println("After GetLocalTime");
		IClient obj = (IClient) Naming.lookup("CMDDD");
		int getTime = obj.GetLocalTime();
		System.out.println(getTime);

		// GlobalValue.canStartCmd = false;

	}

	// public static void main(String[] args) throws Exception
	// {
	// ServiceImpl c = new ServiceImpl();
	// Naming.rebind("rmi://localhost:1098/IService", c);
	// }

}
//
// class GetLocalTime extends Thread {
//
// public GetLocalTime() throws Exception
// {
// System.out.println("Before GetLocalTime");
//
// while (!GlobalValue.canStartCmd);
// System.out.println("After GetLocalTime");
// IClient obj = (IClient)Naming.lookup("CMD");
// int getTime = obj.GetLocalTime();
// System.out.println(getTime);
//
// GlobalValue.canStartCmd = false;
//
// }
// }
//
