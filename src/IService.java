
import java.rmi.Remote;

//import java.rmi.RemoteException;  
public interface IService extends Remote {
	public boolean BeaconListener(int n) throws Exception;

	public void GetLocalTime() throws Exception;

}