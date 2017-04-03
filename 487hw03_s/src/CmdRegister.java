//class CmdRegister implements CmdAgent {
//  public native Object CGetLocalTime(Object CmdObj);
//  public native Object CGetLocalOS(Object CmdObj);
//  static {
//    System.loadLibrary("client");
//  }
//  public Object execute(String CmdID, Object CmdObj) {
//    System.out.println(CmdID);
//    if (CmdID.equals("GetLocalTime")) {
//      return CGetLocalTime((GetLocalTime)CmdObj);
//    } else if (CmdID.equals("GetLocalOS")) {
//      return CGetLocalOS((GetLocalOS)CmdObj);
//    } else {
//      System.err.println("No such command");
//      return new Object();
//    }
//  }
//}