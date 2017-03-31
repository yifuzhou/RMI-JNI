import java.rmi.server.*;
//import java.rmi.RemoteException;  
    import java.rmi.server.UnicastRemoteObject;  
    public class ServiceImpl extends UnicastRemoteObject implements IService {  
    	public String ID;
     
        public ServiceImpl(String ID) throws Exception {  
        	super(); 
        	this.ID = ID;
            
        }  
      
        public String getID() throws Exception {  
            return ID;  
        }  
        
//        public static void main(String[] args) throws Exception
//        {
//        	ServiceImpl c = new ServiceImpl();
//        	Naming.rebind("rmi://localhost:1098/IService", c);
//        }
      
        
    }  