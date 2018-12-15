// Name:    Date:
import java.util.*;
import java.io.*;
public class SetsOfLetters
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner sc = new Scanner(System.in);
      System.out.print( "Enter the file name: " );
      String fileName = sc.next();
      
      //String fileName = "declarationLast.txt";
      fillTheSets(fileName);
   }
   public static void fillTheSets( String fn ) throws FileNotFoundException
   {
      Scanner scanner = null;
      
      TreeSet<Character> lcTreeSet    = new TreeSet<Character>();
      TreeSet<Character> ucTreeSet    = new TreeSet<Character>();      
      TreeSet<Character> otherTreeSet = new TreeSet<Character>(); 
      
      TreeSet<Character> lcIntersection    = new TreeSet<Character>();
      TreeSet<Character> ucIntersection    = new TreeSet<Character>();
      TreeSet<Character> otherIntersection = new TreeSet<Character>();
                        
      String line = null;      
      char character;
      boolean firstPass = true; 
      scanner = new Scanner( new File( fn ) );
      
      while ( scanner.hasNextLine() )
      {  
         line = scanner.nextLine();
            
         for ( int i = 0; i < line.length(); i++ )
         {
            character = line.charAt( i );
            
            if ( character >= 'a' && character <= 'z' )   
               lcTreeSet.add( character );
                    
            else if ( character >= 'A' && character <= 'Z' )  
               ucTreeSet.add( character );
                    
            else
               otherTreeSet.add( character );        
         }
             
         System.out.println( line );
         System.out.println( "Lower Case: " + lcTreeSet );      
         System.out.println( "Upper Case: " + ucTreeSet );
         System.out.println( "Other: "      + otherTreeSet );  
         System.out.println();  
                                 
         if ( firstPass )
         {
            lcIntersection.addAll(    lcTreeSet    );
            ucIntersection.addAll(    ucTreeSet    ); 
            otherIntersection.addAll( otherTreeSet );  
                             
            firstPass = false;    
         }       
         else
         {
            lcIntersection.retainAll(    lcTreeSet    );
            ucIntersection.retainAll(    ucTreeSet    ); 
            otherIntersection.retainAll( otherTreeSet );                                 
         }
                       
         lcTreeSet.clear();
         ucTreeSet.clear();
         otherTreeSet.clear();                                  
      }
    
      System.out.println( "Common Lower Case: " + lcIntersection );      
      System.out.println( "Common Upper Case: " + ucIntersection );
      System.out.println( "Common Other: "      + otherIntersection );     
   }
}