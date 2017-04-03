import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.Serializable;

class GetLocalTime implements Serializable
{
  int time;
  char valid;
}