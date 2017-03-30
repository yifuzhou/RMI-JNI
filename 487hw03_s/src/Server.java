    import java.rmi.Naming;  
    public class Server {  
        public static void main(String[] args) throws Exception {  
            try {  
                // 创建远程对象  
                IService testRemote = new ServiceImpl();  
                // 奖名称绑定到对象  
                Naming.rebind("rmi://localhost:1099/server", testRemote);  
                System.out.println("RMI服务器正在运行。。。。。。");  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
    }  