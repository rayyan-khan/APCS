// name:  Rayyan Khan   date: 9/20/16
import java.util.List;

public class LogMessageTest
{
  public static void main(String[] args)
  {
    String[] messages = {
        "CLIENT3:security alert - repeated login failures",
        "Webserver:disk offline",
        "SERVER1:file not found",
        "SERVER2:read error on disk DSK1",
        "SERVER1:write error on disk DSK2",
        "Webserver:error on /dev/disk",
        "True:disk",
        "True:error on disk",
        "True:error on /dev/disk disk",
        "True:error on disk DSK1",
        "False:DISK",
        "False:error on disk3",
        "False:error on /dev/disk",
        "False:diskette"};

    // Parts A and B
    for (String s : messages)
    {
      LogMessage msg = new LogMessage(s);
      System.out.println(msg.getMachineId() + ":" + msg.getDescription() + " ==> " + msg.containsWord("disk"));
    }
    
	 // Part C
//     SystemLog theLog  = new SystemLog(messages);
//     LogMessage[] removed = theLog.removeMessages("disk");
//     
//     System.out.println();
// 
//     System.out.println("Removed messages:\n");
//     for (LogMessage msg : removed)
//       System.out.println(msg);
//     System.out.println();
// 
//     System.out.println("Remaining messages:\n");
//     System.out.println(theLog);


    
  }
}

class LogMessage
{
   private String machineId;
   private String description;

   /* Part (a) */
   public LogMessage(String message)
   {
      String[] message1 = message.split(":");
      machineId = message1[0];
      description = message1[1];
   }

   /* Part (b) */
   public boolean containsWord(String keyword)
   {
      String[] words = description.split(" ");
      String s = " " + keyword + " ";
      
      if(keyword.equals(words[0])) 
      {
         return true;
      }
      else if(description.contains(s) == true)
      {
         return true;
      }
      else if(keyword.equals(words[words.length-1]))
      {
         return true;
      }
      else
         return false;
   }

   public String getMachineId()
   { 
      return machineId; }

   public String getDescription()
   { 
      return description; }

   public String toString()
   {
      return getMachineId() + ":" + getDescription();
   }
}

class SystemLog
{
  private LogMessage[] messageList;

  public SystemLog(String[] messages)
  {
    messageList = new LogMessage[messages.length];
    for (int i=0;i<messages.length; i++)
      messageList[i]=(new LogMessage(messages[i]));
  }

  /* Part (c) */

//  public LogMessage[] removeMessages(String keyword)
//   {
//     
//             
//       
//   }    
//}

  public String toString()
  {
    String s = "";
    for (LogMessage msg : messageList)
      s += msg + "\n";
    return s;
  }

}

