    import java.rmi.Naming;  
    public class Client {  
        public static void main(String args[]) {  
                try {  
                    IService c = (IService) Naming.lookup("rmi://localhost:1098/IService");  
                    System.out.println(c.add(3, 4));  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
                System.exit(0);  
      
        }  
    }  