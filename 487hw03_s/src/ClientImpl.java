import java.rmi.server.*;
//import java.rmi.RemoteException;  
    import java.rmi.server.UnicastRemoteObject;  
    public class ClientImpl extends UnicastRemoteObject implements IClient {  

        public native Object CGetLocalTime(Object CmdObj);
        public native Object CGetLocalOS(Object CmdObj);
        static {
          System.loadLibrary("client");
        }
        
        public ClientImpl() throws Exception {  
        	super(); 
        }  
        
        public Object execute(String CmdID, Object CmdObj) throws java.rmi.RemoteException {
          System.out.println(CmdID);
          if (CmdID.equals("GetLocalTime")) {
            return CGetLocalTime((GetLocalTime)CmdObj);
        	  //return 13;
          } else if (CmdID.equals("GetLocalOS")) {
            return CGetLocalOS((GetLocalOS)CmdObj);
        	  //return 15;
          } else {
            System.err.println("No such command");
            return new Object();
            //return 17;
          }
        	//System.out.println("I am in execute");
        	//return 2020;
        }
		@Override
		public int GetLocalTime() throws Exception {
			// TODO Auto-generated method stub
			return 1010;
		}

      
        
    }
    

