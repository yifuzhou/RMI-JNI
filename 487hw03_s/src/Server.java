
import java.rmi.*; 
import java.rmi.server.*;
public class Server {
 public static void main(String args[]) throws Exception {
	 ServiceImpl bulbService = new ServiceImpl();
	 Naming.rebind("ADD", bulbService);
	 System.out.println("Start!");
 }
}