
     import java.rmi.Remote;  
    //import java.rmi.RemoteException;  
    public interface IService extends Remote {  
        public String getID() throws Exception;  
      
    }  