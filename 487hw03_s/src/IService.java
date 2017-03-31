
     import java.rmi.Remote;  
    //import java.rmi.RemoteException;  
    public interface IService extends Remote {  
        public int add(int a, int b) throws Exception;  
      
    }  