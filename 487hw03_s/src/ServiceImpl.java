     import java.rmi.Naming;
import java.rmi.RemoteException;  
    import java.rmi.server.UnicastRemoteObject;  
    public class ServiceImpl extends UnicastRemoteObject implements IService {  
     
        public ServiceImpl() throws RemoteException {  
            super();  
        }  
      
        public int add(int a, int b) throws RemoteException {  
            return a + b;  
        }  
        
        public static void main(String[] args) throws Exception
        {
        	ServiceImpl c = new ServiceImpl();
        	Naming.rebind("rmi://localhost:1098/IService", c);
        }
      
        
    }  