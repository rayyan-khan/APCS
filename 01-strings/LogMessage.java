public class LogMessage
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
