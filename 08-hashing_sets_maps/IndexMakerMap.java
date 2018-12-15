//  Name:      date:
//  This program takes a text file, creates an index (by line numbers)
//  for all the words in the file and writes the index
//  into the output file.  The program prompts the user for the file names.

import java.io.*;
import java.util.*;

public class IndexMakerMap
{
   public static void main(String[] args) throws IOException
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("\nEnter input file name: ");
      String infileName = keyboard.nextLine().trim();
      Scanner inputFile = new Scanner(new File(infileName));
      String outfileName = "fishIndex.txt";
      PrintWriter outputFile = new PrintWriter(new FileWriter(outfileName));
      indexDocument(inputFile, outputFile);
      inputFile.close(); 						
      outputFile.close();
      System.out.println("Done.");
   }

   //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
   ///\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\
   ////\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
   /////\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\/
   //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
   ///\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\

   public static void indexDocument( Scanner inputFile, PrintWriter outputFile )
   {
      DocumentIndex index = new DocumentIndex(); 	
      int lineNum = 0;
      while(inputFile.hasNextLine())
      {
         lineNum++;
         index.addAllWords(inputFile.nextLine(), lineNum);
      }
      
      ArrayList<Integer> list = null;
      String listOfLineNumbers = null;
      
      for ( String key : index.keySet() )
      {
          list = index.get( key );
          listOfLineNumbers = list.toString();
          
          listOfLineNumbers = listOfLineNumbers.replace( "[", "" );          
          listOfLineNumbers = listOfLineNumbers.replace( "]", "" );
          
          outputFile.println( key + " " + listOfLineNumbers );
      }
   }
}

    //\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\\
   //\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\\
  //\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\\
 //\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\\
//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\\


class DocumentIndex extends TreeMap<String, ArrayList<Integer>>
{

   public void addWord( String word, int lineNum )
   {
      ArrayList<Integer> listOfLineNumbers = null;
      
      if ( this.containsKey( word ) )
      {
          listOfLineNumbers = this.get( word );
      }
      else
      { 
          listOfLineNumbers = new ArrayList<Integer>();     
      }
      
      listOfLineNumbers.add( lineNum );
      this.put( word, listOfLineNumbers );
   }


       
   public void addAllWords( String str, int lineNum ) 
   {      
      String fields[] = null;
      String word = null;
     
      str = str.trim();   
      fields = str.split( "[ .,\"!?]+" );
      
      if ( fields.length != 0 )
      {   
         System.out.println( "fields: " + Arrays.toString( fields ) );
         
         for ( int index = 0; index < fields.length; index++ )
         {
            word = fields[ index ].toUpperCase();
            
            if ( word.length() >= 1 )
            {
                addWord( word, lineNum );
            }
         } 
      } 
   }
   
   //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
   ////\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
   //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
   ////\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
   //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
   ////\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
   //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
   
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
      
   public String getWord()
   {
      return word;
   }
      
   public String toString()
   {
      String pie = word + " ";
      pie = pie + numsList.toString().substring(1,numsList.toString().length()-1);
      return pie;
   }

  }
}