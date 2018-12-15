//name: Rayyan Khan date: 9/12/16 

import java.util.*;
import java.io.*;
public class PigLatin
{
   public static void main(String[] args) throws IOException
   {
      part_1_using_pig();
      //part_2_using_piglatenizeFile();      
   }
   
   ///////////////////////////////////////////////////////////////////////////////////////
   //       part 1 stuff
   ///////////////////////////////////////////////////////////////////////////////////////   
   
   public static void part_1_using_pig()
   {
      Scanner sc = new Scanner(System.in);
      while(true)
      {
         System.out.print("\nWhat word? ");
         String s = sc.next();
         if (s.equals("-1")) 
            System.exit(0);
         String p = pig(s);
         System.out.println("***** " + p + " *****");
      }		
   }
   public static String pig(String s)
   {
      boolean isAWord = false;
      boolean isVowel = false;
      String pig = "INVALID";
      String[] vowel = new String[6];
      vowel[0] = "a";
      vowel[1] = "e";
      vowel[2] = "i";
      vowel[3] = "o";
      vowel[4] = "u";
      vowel[5] = "y";
      
      if(s.length() == 2)
      {
        String o = "" + s.charAt(0);
        String p = "" + s.charAt(1);
        if(isAVowel(o) == true)
        {  
           pig = fixCap(s + "way");
           return pig;
        }
        else if(isAVowelincludesY(p) == true)
        {
           if(isCap(s) == true)
           {
               pig = fixCap(p.toUpperCase() + o + "ay");
           }
           else
           {
              pig = fixCap(p + o + "ay");
              return pig;
           }
         }
      }
      
      else
      {
         for(int a = 0; a<s.length(); a++)//checks for vowels
         {  
            for(int b = 0; b<vowel.length; b++)
            {
               if(isAWord == true)
               {
                  if(hasQuotes(s) == true && includesPunctuation(s) == true)//quotes and punctuation
                  {
                     //System.out.println("has punctuation");
                     s = s.substring(1,s.length()-1);
                     if(isCap(s) == true) //if capital first letter
                       {
                           s.toLowerCase();
                           String q = pig(s);
                           String r = "" + s.charAt(0);
                           r.toUpperCase();
                           q.substring(1,q.length());
                           pig = fixCap(r + s);
                       }
                     else
                       {                  
                           //System.out.println(includesPunctuation(s) + " INCLUDES PUNCTUATION");
                           String beginning1 = "";
                           String middle1 = "";
                           String end1 = "";
                           int i1 = 0;
                           String string1 = s;
                           
                           for(int apple1 = 0; apple1<string1.length(); apple1++)
                           {
                              String pomme1 = "" + s.charAt(apple1);
                              if(isPunc(pomme1) == true)
                              {
                                 beginning1 = beginning1 + pomme1;
                                 i1++;
                              }
                              else
                                 break;
                           }
                           for(int cookie1 = i1; cookie1<s.length(); cookie1++)
                           {
                               //System.out.println("cookie");
                               String biscuit1 = "" + s.charAt(cookie1);
                               //System.out.println(biscuit + isPunc(biscuit));
                               if(isPunc(biscuit1) == false)
                               {
                                 middle1 = middle1+biscuit1;
                               }
                               else
                                 break;
                            }
                            //System.out.println(middle1);
                            
                            end1 = string1;
                            //System.out.println("1. B: " + beginning1 + " M: " + middle1 + " E: " + end1);
                            //System.out.println("");
                            String end21 = "";
                            String[] end11 = end1.split(middle1);
                            if(end11.length == 2)
                              end21 = end11[1]; 
                                                         
                            //System.out.println("2. Split: end11[0] = " + end11[0] + " end11[1] = " + end11[1]);      
                             
                            middle1 = pig(middle1);
                            
                            //System.out.println("3. B: " + beginning1 + " M: " + middle1 + " E: " + end11[1]);
                            //System.out.println("");
      
                             //System.out.println("4. pig middle: " + pig(middle1));
                             return beginning1 + middle1 + end21;
                             }
                        }
                        
                        if(includesPunctuation(s) == true) //when the word just has punctuation
                        {
                           //System.out.println(includesPunctuation(s) + " INCLUDES PUNCTUATION");
                           String beginning = "";
                           String middle = "";
                           String end = "";
                           int i = 0;
                           String string = s;
                           
                           for(int apple = 0; apple<string.length(); apple++)
                           {
                              String pomme = "" + s.charAt(apple);
                              if(isPunc(pomme) == true)
                              {
                                 beginning = beginning + pomme;
                                 i++;
                              }
                              else
                                 break;
                           }
                           for(int cookie = i; cookie<s.length(); cookie++)
                           {
                               //System.out.println("cookie");
                               String biscuit = "" + s.charAt(cookie);
                               //System.out.println(biscuit + isPunc(biscuit));
                               if(isPunc(biscuit) == false)
                               {
                                 middle = middle+biscuit;
                               }
                               else
                                 break;
                            }
                            //System.out.println(middle);
                            
                            end = string;
                            //System.out.println("1. B: " + beginning + " M: " + middle + " E: " + end);
                            //System.out.println("");
                            String end2 = "";
                            String[] end1 = end.split(middle);
                            if(end1.length == 2)
                              end2 = end1[1];  
                            
                            //System.out.println("2. Split: end1[0] = " + end1[0] + " end1[1] = " + end1[1]);      
                             
                            middle = pig(middle);
                            
                            //System.out.println("3. B: " + beginning + " M: " + middle + " E: " + end1[1]);
                            //System.out.println("");
      
                             //System.out.println("4. pig middle: " + pig(middle));
                             return beginning + middle + end2;
                  }
                  
                  if(hasQuotes(s) == true)//if the word has quotes
                  {
                     s = s.substring(1,s.length()-1);
                     
                     s = fixCap(pig(s));
                     pig = "\"" + s + "\"";
                     return pig;
                  }
                  
                   
                  if(s.startsWith("y")) //IF THE WORD STARTS WITH A Y
                  {  ///finding the first vowel and appending stuff 
                     int c = 0;
                     //boolean isVowel = false;
                     while(isAVowel(s.substring(c, c+1)) == false)
                     {
                        c++;
                     }
                     
                     String f = s.substring(c); //beginning
                     String g = s.substring(0,c); // middle
                     pig = fixCap(f + g + "ay");                     
                  }
                  else if(isAVowel(s.substring(0,1)) == true)//IF THE WORD STARTS WITH A VOWEL
                  {
                     pig = fixCap(s + "way");
                     s = s.substring(0); //gets rid of weird infinite loop
                  }
                  else
                  {
                     int h = 0;
                     //boolean isVowel = false;
                     while(isAVowelincludesY(s.substring(h, h+1)) == false)
                     {
                        h++;
                     }
                                                         
                     if(s.substring(h,h+1).equals("u") && s.substring(h-1, h).equals("q")) // STARTS WITH A QU
                     {
                        String k = s.substring(h+1);//beginning
                        String l = s.substring(0,h+1);//middle
                        pig = fixCap(k + l + "ay");
                     }
                     
                     else //NORMAL WORDS
                     {
                        String m = s.substring(h); //beginning
                        String n = s.substring(0, h);//middle
                        pig = fixCap(m + n + "ay");
                     }
                  }
               }
               else if(s.toLowerCase().contains(vowel[b]))
               {
                  isAWord = true;
                  //System.out.println("");       //testing
                  //System.out.println(s.charAt(b));
               }
            }
         }
      }  
      return pig;
   }
   public static boolean isAVowel(String s) //whether or not a letter is a vowel
   {
      if(s.equalsIgnoreCase("a") || s.equalsIgnoreCase("e") || s.equalsIgnoreCase("i") || s.equalsIgnoreCase("o") || s.equalsIgnoreCase("u"))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   public static boolean isAVowelincludesY(String s) //whether or not a letter is a vowel, including y
   {
      if(s.equalsIgnoreCase("a") || s.equalsIgnoreCase("e") || s.equalsIgnoreCase("i") || s.equalsIgnoreCase("o") || s.equalsIgnoreCase("u") || s.equalsIgnoreCase("y"))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   public static boolean includesPunctuation(String s)
   {
      boolean b = false;
      for(int x = 0; x<s.length(); x++)
      {
         String pie = ""+s.charAt(x);
         if(isPunc(pie) == true)
            b = true; 
      } 
      return b;       
   }
   
   public static boolean isPunc(String s) //if a letter is punctuation
   {
      boolean b = false;
      if(!(s.equalsIgnoreCase("a") || s.equalsIgnoreCase("b") || s.equalsIgnoreCase("c") || s.equalsIgnoreCase("d") || s.equalsIgnoreCase("e") || s.equalsIgnoreCase("f") || s.equalsIgnoreCase("g") || s.equalsIgnoreCase("h") || s.equalsIgnoreCase("i") || s.equalsIgnoreCase("j") || s.equalsIgnoreCase("k") || s.equalsIgnoreCase("l") || s.equalsIgnoreCase("m") || s.equalsIgnoreCase("n") || s.equalsIgnoreCase("o") || s.equalsIgnoreCase("p") || s.equalsIgnoreCase("q") || s.equalsIgnoreCase("r") || s.equalsIgnoreCase("s") || s.equalsIgnoreCase("t") || s.equalsIgnoreCase("u") || s.equalsIgnoreCase("v") || s.equalsIgnoreCase("w") || s.equalsIgnoreCase("x") || s.equalsIgnoreCase("y") || s.equalsIgnoreCase("z") || s.equals("\"")))
         b = true;
      return b;
   }
   public static boolean hasQuotes(String s) //if there are quotation marks or not
   {
      if(s.startsWith("\"") && s.endsWith("\""))
         return true;
      else
         return false;
   }
   public static String fixCap(String s) //fixes capitalization
   {  
      boolean cap = false;
      for(int x = 0; x<s.length(); x++)   //if there is a capital letter
      {
         String a = "" + s.charAt(x);
         if(a.toUpperCase().equals(a))
            cap = true;
      }
      
      if(cap == true) //if there is a capital letter, make first letter uppercase and rest lowercase
      {
         String firstLetter = "" + s.charAt(0);
         String r = s.substring(1);
         //System.out.println(s);
         s = firstLetter.toUpperCase() + r.toLowerCase();
         //System.out.println(s);
      }
      return s;
   }
   public static boolean isCap(String s) //if a letter is uppercase
   {
      String a = "" + s.charAt(0);
      if(a.equals(a.toUpperCase()))
         return true;
      else 
         return false;
   }
   public static int lastLetter(String s) //last non-punctuation letter in a string
   {
      int lastLetter = 0;
      boolean firstLetter = false;
      for(int x = 0; x<s.length(); x++)
      {
         String n = "" + s.charAt(x);
         if(isPunc(n) == false)
         {
            firstLetter = true;
         }
         
         if(firstLetter == true)
         {
            if(isPunc(n) == true)
            lastLetter = x-1;
         }
      }
      return lastLetter;
   }
   public static int numPunc(String s)
   {
      int x = 0;
      for(int n = 0; n<s.length(); n++)
      {
         String m = "" + s.charAt(n);
         System.out.println(m);
         if(isPunc(m) == true)
         {
            System.out.println("true");
            x++;
         }
      }
      return x;
   }
  
   //////////////////////////////////////////////////////////////////////////////////////////////////////
   //               part 2 stuff
   //////////////////////////////////////////////////////////////////////////////////////////////////////
   
   public static void part_2_using_piglatenizeFile() throws IOException 
   {
      //add try-catch
      try{  
            Scanner sc = new Scanner(System.in);
            System.out.print("What filename? ");
            String filename = sc.next();
            Scanner infile = new Scanner(new File(filename));  //PigLatin.txt
            piglatenizeFile( infile, filename );
            System.out.println("Piglatin done!");
            sc.close();
         } 
      catch(IOException e)
         {
            System.err.println("Caught IOException: " + e.getMessage());
         }
   }
   /****************************** 
   *  take in a filename, and creates a file that is the inputted file
   *  fully piglatenized. The outputFile should be in piglatin form
   *  PigLatin.txt should become IgLatinpay.txt.
   *
   *  Note: filename will have .txt on it.
   ******************************/
   public static void piglatenizeFile(Scanner infile, String filename) throws IOException
   {
      int numLines = 0;
      String[] lines;
      
      //Pig the filename
      String [] split = filename.split(".txt");
      String newName = pig(split[0]);
      //System.out.println("1. " + newName);
      
      //create file
      PrintStream file = new PrintStream(new FileOutputStream(newName + ".txt"));
      
      //count the number of lines
      while(infile.hasNextLine())
      {
         numLines++;
         infile.nextLine();
      }
      
      //scanner #2
      Scanner infile2 = new Scanner(new File(filename));
      System.out.println(infile2.nextLine());
      lines = new String[numLines];
      
      //put each line in an array
      for(int a = 0; a<numLines-1; a++)
      {
         lines[a] = infile2.nextLine();
      }
      
      //pig each word in a line, then print it with a space. println each new line
      for(int b = 0; b<numLines; b++)
      {  
         //new array words, each index has 1 word from the line
         String[] words = lines[b].split(" ");
         
         //set lines index b to empty 
         lines[b] = "";
         
         //go through the words from lines[b] and pig them
         for(int c = 0; c<words.length; c++)
         {
            //if-else to account for blank lines
            if(words[c].equals(""))
               words[c] = words[c];
            else
               words[c] = pig(words[c]);
            //System.out.println(words[c]);
         }
         
         //add pigged words back to line[b]
         for(int d = 0; d<words.length; d++)
         {
            lines[b]+=words[d] + " ";
         }
         
         //println line[b]
         file.println(lines[b]);
      }
      
   }
   
}
