//Name: Rayyan Khan   date:  9/12/16

//done except for identifying quotation marks as punctuation & weird compile error

    public class Sentence_Driver
   {
       public static void main(String[] args)
      {
         System.out.println("PALINDROME TESTER");
         Sentence s = new Sentence( "\"Hello there!\" she said." );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
         
         s = new Sentence( "A Santa lived as a devil at NASA." );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
        
      
         s = new Sentence( "Flo, gin is a sin! I golf." );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
         
      
         s = new Sentence( "Eva, can I stab bats in a cave?" );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
      
         s = new Sentence( "Madam, I'm Adam." );
         System.out.println( s.getSentence());
         System.out.println( s.getNumWords());
         System.out.println( s.isPalindrome() );
         System.out.println();
         
      // Lots more test cases.  Test every line of code.  Test
      // the extremes, test the boundaries.  How many test cases do you need?
      
      }
   }
    class Sentence
   {
      private String mySentence;
      private int myNumWords;
      
      //Constructor.  Creates sentence from String str.
      //						Finds the number of words in sentence.
      //Precondition:  Words in str separated by exactly one blank.
       public Sentence( String str )
      { 
         mySentence = str;
         int c = 0;
         for(int a = 0; a<str.length(); a++)
         {
            String b = "" + str.charAt(a);
            if(isBlank(b) == true)
            {
               c++;
               //System.out.println(b + " ," + c);
            }
         }  
         myNumWords = c+1;     
      }
      
       public int getNumWords()
      {  
         return myNumWords;  
      }
      
       public String getSentence()
      {
         return mySentence; 
      }
      
      //Returns true if mySentence is a palindrome, false otherwise.
       public boolean isPalindrome()
      {
          if(isPalindrome(mySentence) == true)
            return true;
          else
            return false;        
      }
      //Precondition: s has no blanks, no punctuation, and is in lower case.
      //Returns true if s is a palindrome, false otherwise.
       
       
       private static boolean isPalindrome( String s )  //works, but doesn't use recursion
      {  
         s = removeBlanks(s);
         //System.out.println(s + " -- Remove blanks.");
         s = lowerCase(s);
         //System.out.println(s + " -- To lowercase.");
         s = removePunctuation(s);
         //System.out.println(s + " -- Remove punctuation.");

         boolean pal = true;
         int a = 0;
         for(int b = s.length()-1; b>0; b--)
           {
               String c = "" + s.charAt(a);
               String d = "" + s.charAt(b);
              // System.out.println(c + ", " + d);
               if(!c.equals(d))
               {
                  pal = false;
               }
               a++;
            }
         
         // if(pal == true)
//             System.out.println("True");
//          else
//             System.out.println("False");   
         return pal;     
      }
      
      private static boolean isPalindrome( String s, int start, int end )
      {  
         s = removeBlanks(s);
//         System.out.println(s + " -- Remove blanks.");
         s = lowerCase(s);
//         System.out.println(s + " -- To lowercase.");
         s = removePunctuation(s);
//         System.out.println(s + " -- Remove punctuation.");
         
         boolean pal = true;
         start = 0;
         end = s.length()-1;
         
        String c = "" + s.charAt(start);
        String d = "" + s.charAt(end);
        String e = "" + start;
        String f = "" + end;
//          System.out.println(c + ", " + d);
//          System.out.println(e + ", " + f);   
            
         if(s.length()<2)
             pal = true;
         else if(c.equals(d))
         {
            s = s.substring(start+1, end);
            //System.out.println(s);
            isPalindrome(s, start, end);
         }
         else
            pal = false;  
         
         return pal;      
      }

      //Returns copy of String s with all blanks removed.
      //Postcondition:  Returned string contains just one word.
       private static String removeBlanks( String s )
      {  
         String n = "";
         for(int a = 0; a<s.length(); a++)
         {
            String b = "" + s.charAt(a);
            if(isBlank(b) == true)
            {  
               n = n;
            }
            else
            {
               n+=b;
            }
         }
         //System.out.println(n + " remove blanks");
         return n;         
      }
      
      //Returns copy of String s with all letters in lowercase.
      //Postcondition:  Number of words in returned string equals
      //						number of words in s.
       private static String lowerCase( String s )
      {  
         s = s.toLowerCase();
         return s;
      }
      
      //Returns copy of String s with all punctuation removed.
      //Postcondition:  Number of words in returned string equals
      //						number of words in s.
       private static String removePunctuation( String s )
      { 
         String a = "";
         for(int b = 0; b<s.length()-1; b++)
         {
            String c = "" + s.charAt(b); 
            if(isPunct(c) == true)
            {
               a = a;
            }
            else
            {
               a+=c;
            }
         } 
         //System.out.println(a + " remove punctuation");
         return a;    
      }
      public static boolean isPunct(String s)
      {
         if(s.equals(",") || s.equals(".") || s.equals("!") || s.equals("'") || s.equals("\""))
            return true;
         else 
            return false;
      }
      public static boolean isBlank(String s)
      {
         if(s.equals(" "))
            return true;
         else
            return false;
      }
   }
