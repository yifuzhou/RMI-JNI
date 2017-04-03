import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.Serializable;

class GetVersion implements Serializable
{
  int version;
}