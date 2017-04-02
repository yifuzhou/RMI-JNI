
     import java.rmi.Remote;  
    //import java.rmi.RemoteException;  
    public interface IClient extends Remote {  
    	public int GetLocalTime() throws Exception;  
      
    }  