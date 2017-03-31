
import java.rmi.*; 
import java.rmi.server.*;
public class Server {
 public static void main(String args[]) throws Exception {
	 String ID = args[0];
	 ServiceImpl impl = new ServiceImpl(ID);
	 Naming.rebind("ADD", impl);
	 System.out.println("Start!");
 }
}