import java.rmi.server.*;
//import java.rmi.RemoteException;  
    import java.rmi.server.UnicastRemoteObject;  
    public class ClientImpl extends UnicastRemoteObject implements IClient {  

        public ClientImpl() throws Exception {  
        	super(); 
        	    
        }  
        
        public int GetLocalTime()
    	{
    		int time = 1010;
    		
    		return time;
    	}
      
        
//        public static void main(String[] args) throws Exception
//        {
//        	ServiceImpl c = new ServiceImpl();
//        	Naming.rebind("rmi://localhost:1098/IService", c);
//        }
      
        
    }
    

