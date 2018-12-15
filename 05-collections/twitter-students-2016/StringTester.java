public class StringTester
{
   public static void main(String[] args)
   {
      String s = "abcdefghijklmnop";
      String n = "123!!!#?:";
      String k = "!abcd!efgh?ijkl}mnop+";
      System.out.println(removePunctuation(s));
      System.out.println(removePunctuation(n));
      System.out.println(removePunctuation(k));
   }
   
   public static String removePunctuation( String s )
      {
         String str = "";
          for(int n = 0; n<s.length(); n++)
         {
            String c = "" + s.charAt(n);
            if(!c.equalsIgnoreCase("a") ||!c.equalsIgnoreCase("b") ||!c.equalsIgnoreCase("c") ||!c.equalsIgnoreCase("d") ||!c.equalsIgnoreCase("e") ||!c.equalsIgnoreCase("f") ||!c.equalsIgnoreCase("g") ||!c.equalsIgnoreCase("h") ||!c.equalsIgnoreCase("i") ||!c.equalsIgnoreCase("j") ||!c.equalsIgnoreCase("k") ||!c.equalsIgnoreCase("l") ||!c.equalsIgnoreCase("m") ||!c.equalsIgnoreCase("n") ||!c.equalsIgnoreCase("o") ||!c.equalsIgnoreCase("p") ||!c.equalsIgnoreCase("q") ||!c.equalsIgnoreCase("r") ||!c.equalsIgnoreCase("s") ||!c.equalsIgnoreCase("t") ||!c.equalsIgnoreCase("u") ||!c.equalsIgnoreCase("v") ||!c.equalsIgnoreCase("w") ||!c.equalsIgnoreCase("x") ||!c.equalsIgnoreCase("y") ||!c.equalsIgnoreCase("z") ||!c.equalsIgnoreCase(" "))
            {
               String[] parts = s.split(c);
               for(int m = 0; m<parts.length; m++)
               {
                  str += parts[m];
               } 
            }
         }
         return str;
      }
}