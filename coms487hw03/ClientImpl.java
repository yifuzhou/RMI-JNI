import java.rmi.server.*;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl extends UnicastRemoteObject implements IClient {

	public native Object CGetLocalTime(Object CmdObj);

	public native Object CGetVersion(Object CmdObj);

	static {
		System.loadLibrary("client");
	}

	public ClientImpl() throws Exception {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IClient#execute(java.lang.String, java.lang.Object) JNI with C code
	 */
	public Object execute(String CmdID, Object CmdObj) throws java.rmi.RemoteException {
		System.out.println(CmdID);
		if (CmdID.equals("GetLocalTime")) {
			return CGetLocalTime((GetLocalTime) CmdObj);

		} else if (CmdID.equals("GetVersion")) {
			return CGetVersion((GetVersion) CmdObj);

		} else {
			System.err.println("No such command");
			return new Object();

		}

	}

}

