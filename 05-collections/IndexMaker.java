//  Name:      date:
//  This program takes a text file, creates an index (by line numbers)
//  for all the words in the file and writes the index
//  into the output file.  The program prompts the user for the file names.

import java.util.*;
import java.io.*;

public class IndexMaker
{
   public static void main(String[] args) throws IOException
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("\nEnter input file name: ");
      String inFileName = keyboard.nextLine().trim();
      Scanner inputFile = new Scanner(new File(inFileName));
      String outFileName = "fishIndex.txt";
      PrintWriter outputFile = new PrintWriter(new FileWriter(outFileName));
      indexDocument(inputFile, outputFile);
      inputFile.close(); 						
      outputFile.close();
      System.out.println("Done.");
   }
   public static void indexDocument(Scanner inputFile, PrintWriter outputFile)
   {
      DocumentIndex index = new DocumentIndex();
      String line = null;
      int lineNum = 0;
      while(inputFile.hasNextLine())
      {
         lineNum++;
         index.addAllWords(inputFile.nextLine(), lineNum);
      }
      for(IndexEntry entry : index)
         outputFile.println(entry);
   }   
}
class DocumentIndex extends ArrayList<IndexEntry>
{
    //constructors
   public DocumentIndex()
   {
      super();
   }
   public DocumentIndex(int n)
   {
      super(n);
   }
   
   /** calls foundOrInserted, which returns an index.  At that position,  
   updates that IndexEntry's list of line numbers with num. */
   public void addWord(String word, int num)
   {
      if(word.equals(""))
      { 
         return;
      }
      int i = foundOrInserted(word);
      get(i).add(num);
   }
      
    /** extracts all the words from str, skipping punctuation and whitespace 
    and for each word calls addWord(word, num).  A good way to skip punctuation 
    and whitespace is to use String's split method, e.g., split("[., \"!?]") */
   public void addAllWords(String str, int num) 
   {
      removePunctuation(str);
      String[] oatmeal = str.split("[., \"!?]");
      for(int raisin = 0; raisin<oatmeal.length; raisin++)
      {
         addWord(oatmeal[raisin], num);
      }
   }
   public String removePunctuation( String s )
   {
      String i = "";
      for(int n = 0; n<s.length(); n++)
      {
         String c = "" + s.charAt(n);
         if(isPunctuation(c) == false)
            i+= c;
      }
      return i; 
   }
   public boolean isPunctuation(String s)
   {
      boolean b = false;
      if(!(s.equalsIgnoreCase("a") || s.equalsIgnoreCase("b") || s.equalsIgnoreCase("c") || s.equalsIgnoreCase("d") || s.equalsIgnoreCase("e") || s.equalsIgnoreCase("f") || s.equalsIgnoreCase("g") || s.equalsIgnoreCase("h") || s.equalsIgnoreCase("i") || s.equalsIgnoreCase("j") || s.equalsIgnoreCase("k") || s.equalsIgnoreCase("l") || s.equalsIgnoreCase("m") || s.equalsIgnoreCase("n") || s.equalsIgnoreCase("o") || s.equalsIgnoreCase("p") || s.equalsIgnoreCase("q") || s.equalsIgnoreCase("r") || s.equalsIgnoreCase("s") || s.equalsIgnoreCase("t") || s.equalsIgnoreCase("u") || s.equalsIgnoreCase("v") || s.equalsIgnoreCase("w") || s.equalsIgnoreCase("x") || s.equalsIgnoreCase("y") || s.equalsIgnoreCase("z") || s.equals(" ")))
         b = true;
      return b;
   }

    /** traverses this DocumentIndex and compares word to the words in the 
    IndexEntry objects in this list, looking for the correct position of 
    word. If an IndexEntry with word is not already in that position, the 
    method creates and inserts a new IndexEntry at that position. The 
    method returns the position of either the found or the inserted 
    IndexEntry.*/
   private int foundOrInserted(String word)
   {
      word = word.toUpperCase();
      int line = 0;
      if(size() == 0)
      {
         IndexEntry i = new IndexEntry(word);
         this.add(i);
         return 0;
      }
      for(int n = 0; n<this.size(); n++)
      {
         if(this.get(n).getWord().equals(word))
         {
            return n;
         }
         else if(this.get(n).getWord().compareTo(word)>0)
         {
            IndexEntry i = new IndexEntry(word);
            this.add(n, i);
            return n;
         }
      } 
      IndexEntry i = new IndexEntry(word);
      this.add(i);
      return this.size()-1;
   }
}
   
class IndexEntry implements Comparable<IndexEntry>
{
     //fields
   ArrayList<Integer> numsList;
   private String word;
     //constructors
   public IndexEntry(String s)
   {
      word = s.toUpperCase();
      numsList = new ArrayList<Integer>();
   }
   
   public int compareTo(IndexEntry cookie)
   {
      return word.compareTo(cookie.getWord());
   }
     /**  appends num to numsList, but only if it is not already in that list.    
          */
   public void add(int num)
   {
      boolean inList = false;
      for(int n = 0; n<numsList.size(); n++)
      {
         if(numsList.get(n) == num)
            inList = true;
      }
      if(inList == false)
         numsList.add(num);
   }
      
   	/** this is a standard accessor method  */
   public String getWord()
   {
      return word;
   }
      
     /**  returns a string representation of this Index Entry.  */
   public String toString()
   {
      String ellis = word + " ";
      ellis = ellis + numsList.toString().substring(1,numsList.toString().length()-1);
      return ellis;
   }
}

