//    import java.rmi.Naming;  
//    public class Client {  
//        public static void main(String args[]) {  
//                try {  
//                    IService c = (IService) Naming.lookup("rmi://localhost:1098/IService");  
//                    System.out.println(c.add(3, 4));  
//                } catch (Exception e) {  
//                    e.printStackTrace();  
//                }  
//                System.exit(0);  
//      
//        }  
//    }  
    
    import java.rmi.*;
    public class Client {
     public static void main(String args[]) throws Exception {
    	 IService bulbService = (IService)Naming.lookup("ADD");
    	 int n = bulbService.add(5, 4);
    	 System.out.println("addition is :" + n);
    	 
      
    }
    }
    
