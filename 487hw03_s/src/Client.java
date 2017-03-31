//@author Yifu Zhou
//created by Mar 30 2017

import java.rmi.*;
import java.util.ArrayList;

public class Client {
	public static void main(String args[]) throws Exception 
	{
    	 while (true) {
    		 Thread.sleep(1000); //detect beacon for each second
    		 
    		 IService obj = (IService)Naming.lookup("ADD");
        	 String s = obj.getID();
        	 System.out.println("The ID is :" + s);
        	 
        	 int n = Integer.parseInt(s);
    		 
    		 BeaconListener beaconListener = new BeaconListener(n);
    		 beaconListener.start();
    		 
    		 
    		 
    		 }
    	 
    	 
      
    }
	}
class GlobalValue{
	private GlobalValue(){};
	static ArrayList<Integer> BeaconList = new ArrayList<Integer>();

}

class BeaconListener extends Thread {
	
	// put b to the list
	BeaconListener(int n)
	{
		boolean inList = false;
		for (int i = 0; i < GlobalValue.BeaconList.size(); i++) {
			if (GlobalValue.BeaconList.get(i) == n) {
			inList = true;
			break;
			}
		}
		if (!inList) GlobalValue.BeaconList.add(n);
		
		for (int i = 0; i < GlobalValue.BeaconList.size(); i++) {
			System.out.println(GlobalValue.BeaconList.get(i));
		}
		
	}
}

    
