
import java.rmi.Remote;

//import java.rmi.RemoteException;  
public interface IService extends Remote {
	public boolean BeaconListener(Beacon b) throws Exception;

	public void JNI(Beacon b) throws Exception;

}