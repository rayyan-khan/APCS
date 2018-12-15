public class Test
{
   public static void main(String[] args)
   {
      //String s = "Hello";
      //System.out.println(s.charAt(s.length()-1));
      
      // vowel("String");          //Determines the first vowel in a string. Used for piglatin
//       if(isAVowel("t") == true) 
//       {
//          System.out.println("is a vowel");
//       }
//       else
//       {
//          System.out.println("not a vowel");
//       }

      //String s = "racecar";
      //System.out.println(isPalindrome(s, 0, 6)); //Determines whether or not string is a palindrome. used in Sentence. 
      //System.out.println(s.length());
      //System.out.println(s.charAt(6));
      
      // String a1 = "*";
//       String a2 = "*pig*";
//       String a3 = "pig";
//       String a4[] = a2.split(a3);
//       String a5 = a4[0];
//       String a6 = a4[1];
//       System.out.println(a5 + " " + a6);

      // String a = "123456.txt";
//       String[] split = a.split(".txt");
//       System.out.println(split[0]);

         LogMessage log = new LogMessage("Server 1:error on disk");
         System.out.println(log.getMachineId());
         System.out.println(log.getDescription());
         System.out.println(log.containsWord("disk"));
               
   }
   
   public static void vowel(String s)
      {  
         int c = 0;
         boolean isVowel = false;
         while(isAVowel(s.substring(c, c+1)) == false)
         {
            c++;
         }
         System.out.println(s.substring(c,c+1));
      }
      
      public static boolean isAVowel(String s) //whether or not a letter is a vowel
      {
         if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u"))
         {
            return true;
         }
         else
         {
            return false;
         }
      }
   
   /*private static void isPalindrome( String s, int start, int end ) //palindrome w/out recursion
      {
         boolean pal = true;
         int a = start;
         for(int b = end; b>start; b--)
           {
               String c = "" + s.charAt(a);
               String d = "" + s.charAt(b);
               System.out.println(c + ", " + d);
               if(!c.equals(d))
               {
                  pal = false;
               }
               a++;
            }
         
         if(pal == true)
            System.out.println("True");
         else
            System.out.println("False");        
      }*/
      
      private static boolean isPalindrome( String s, int start, int end )
      {  
         boolean pal = true;
         start = 0;
         end = s.length()-1;
         
         String c = "" + s.charAt(start);
         String d = "" + s.charAt(end);
//          String e = "" + start;
//          String f = "" + end;
//          System.out.println(c + ", " + d);
//          System.out.println(e + ", " + f);
         
            
         if(s.length()<2)
             pal = true;
         else if(c.equals(d))
         {
            s = s.substring(start+1, end);
            System.out.println(s);
            isPalindrome(s, start, end);
         }
         else
            pal = false;  
         
         return pal;      
      }

}