import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.Serializable;

class GetLocalOS implements Serializable
{
  String OS;
  char valid;
}