import java.io.Serializable;

class Beacon implements Serializable {
  int ID;
  int StartUpTime;
  String CmdAgentID;
  Beacon() {
    ID = 0;
    StartUpTime = 0;
    CmdAgentID = "";
  }
  public void setID(int id) {
    this.ID = id;
  }
  public void setCmdAgent(String agent) {
    this.CmdAgentID = agent;
  }
  public void setStartUpTime(int t) {
    this.StartUpTime = t;
  }
  public void print() {
    System.out.println("ID: "+ID);
    System.out.println("StartUpTime: "+StartUpTime);
    System.out.println("CmdAgentID: "+CmdAgentID);
  }
}