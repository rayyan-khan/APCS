 //name:    date:
 /*  Assignment:  This hashing program results in collisions.
     You are to implement three different collision schemes: linear 
     probing, rehashing, and chaining.  Then implement a search 
     algorithm that is appropriate for each collision scheme.
 */
import java.util.*;
import javax.swing.*;

public class Hashing
{
   public static void main(String[] args)
   {
      int arrayLength = Integer.parseInt(JOptionPane.showInputDialog(
                         "Hashing!\n"+
                         "Enter the size of the array:  "));  //20
       
      int numItems = Integer.parseInt(JOptionPane.showInputDialog(
                         "Add n items:  "));                 //15
     
      int scheme = Integer.parseInt(JOptionPane.showInputDialog(
           "The Load Factor is " + (double)numItems/arrayLength +
           "\nWhich collision scheme?\n"+
           "1. Linear Probing\n" +
           "2. Rehashing\n"+
           "3. Chaining"));
      Hashtable table = null;
      switch( scheme )
      {
         case 1:   
            table = new HashtableLinearProbe(arrayLength);
            break;
         case 2: 
            table = new HashtableRehash( arrayLength );
            break;
         case 3:  
            table = new HashtableChaining(arrayLength);
            break;
         default:  System.exit(0);    
      }
      
      for ( int i = 0; i < numItems; i++ )
         table.add( "Item" + i );
         
      int itemNumber = Integer.parseInt(JOptionPane.showInputDialog(
                       "Search for:  Item0" + " to "+ "Item"+(numItems-1)));
      while( itemNumber != -1 )
      {
         String key = "Item" + itemNumber;
         
         int index = table.indexOf( key ); 
         
         if( index >= 0)    //found it
            System.out.println(key + " found  at index " + index);
         else
            System.out.println(key + " not found!");
         itemNumber = Integer.parseInt( JOptionPane.showInputDialog(
                       "Search for:  Item0" + " to "+ "Item"+(numItems-1) ) );                           
      } 
      System.exit(0);
   }
}
/*********************************************/
interface Hashtable
{
   void add(Object obj);
   int indexOf(Object obj);
}
/***************************************************/ 
class HashtableLinearProbe implements Hashtable
{
   private Object[] array;
   public HashtableLinearProbe(int size)
   {
      array = new Object[ size ];
   }
   
   public void add( Object obj )
   {
      int code = obj.hashCode();
      int index = Math.abs( code % array.length );
      
      /////////////////////////////////////////////////////////////////
        
      if ( array[ index ] ==  null )  //array index is available (empty)              
      {
         array[ index ] = obj; 
         
         System.out.println( obj + "\t String HashCode: " + code + "\t Inserted at index: " + index );
      }
      else   //collision -- index already taken
      {
         System.out.println( obj + "\t" + code + "\tCollision at "+ index );
         
         index = linearProbe( index );  //Attempt to find index to insert
         
         if ( index >= 0 )
         {
            array[ index ] = obj;
            
            System.out.println( obj + "\t" + code + "\t" + index );
         }
         else
            System.out.println( "Array is full -- No room in array to insert new item!" );         
      }
   }  
   
   public int linearProbe( int index )
   {
      final int ITEM_NOT_INSERTED = -1;
      
      int hashIndex = index;         //Keep track of original hash index   
      
      /*** Iterate thru array until open index is found or end of array ***/
         
      while ( ( index < array.length ) && 
              ( array[ index ] != null ) )
      {
          index++;
      }
         
      if ( array[ index ] != null )   // Empty so available
      {
          /*** Start from beginning to original hash index ***/
            
          index = 0;
            
          while ( ( index < hashIndex ) && ( array[ index ] != null ) )
          {
             index++;
          }
            
          if ( index >= hashIndex )  // array is full
             index = ITEM_NOT_INSERTED;                
      }
      
      return index;
   }
   
   public int indexOf( Object obj )     
   {
      final int NOT_FOUND = 1;
      
      int     hashIndex = 0;
      int     returnIndex = NOT_FOUND;
      int     index = 0;
      boolean done = false;     //Assume not done
      
      /*** Calculate hash index ***/
      
      hashIndex = Math.abs( obj.hashCode() % array.length );
      
      /*** Check to see what exists at that index ***/
      
      if ( array[ hashIndex ] != null )  //Index has an item in it
      {
         if ( array[ hashIndex ].equals( obj ) )  //if item matches -- found it
         {
            returnIndex = hashIndex;
         }
         else  //Item does not match, means there was a collision
         {
              index = hashIndex;
              
              /*** Iterate thru array until obj is found or null is found or end of array ***/
         
              while ( ( index < array.length ) &&  !done )
              {
                  if ( array[ index ] == null ) //Item not found
                     done = true;
                  
                  else if (  array[ index ].equals( obj ) )
                  {
                     done = true;
                     returnIndex = index;
                  }
                  else        
                     index++;
              }
         
              if ( !done )  //Ran out of indexes in array, so start at beginning
              {                            
                 index = 0;
            
                 while ( ( index < hashIndex ) &&  !done )
                 {
                    if ( array[ index ] == null ) //Item not found
                        done = true;
                  
                    else if (  array[ index ].equals( obj ) )
                    {
                        done = true;
                        returnIndex = index;
                    }
                    else        
                       index++;
                 }
              }
          }
      }
            
      return returnIndex;
   }
}
/*****************************************************/

class HashtableRehash implements Hashtable
{
   private Object[] array;
   private int constant = 2;
   
   public HashtableRehash( int size )
   {
                             //constructor
                             //find a constant that is relatively prime to the size of the array
       /*** Instantiate array ***/

       array = new Object[ size ];
       
       /*** Find first relative prime between 2 and size of array -- set up for rehash ***/                      
                             
       constant = findRelativePrime( constant, size );
       
       System.out.println( "First relative prime: " + constant ); 
   }
   
   private int findRelativePrime( int number1, int number2 )
   {
       /*** Local Variables ***/
       
       int remainder = 0;
       
       for ( int i = constant; i <= number2; i++ )
       {
          remainder = i % number1;
          
          if ( remainder > 0 )
             return i;
       }
       
       return 3;   //Should never happen!!!??????
   }
   
   public void add( Object obj )
   {
      int code = obj.hashCode();
      int index = Math.abs( code % array.length );  //Original Hash
      
      if ( array[ index ] == null )  //empty
      {
          /*** Insert item at this location ***/
          
          array[ index ] = obj;
          
          System.out.println(obj + "\t" + code + "\t" + index);
      }
      else   //collision
      {
         System.out.println(obj + "\t" + code + "\tCollision at "+ index);
         
         index = rehash( index );
         
         array[ index ] = obj;
         
         System.out.println(obj + "\t" + code + "\t" + index);
      }
   } 
    
   public int rehash( int index )
   {  
      /*** Find relative prime to use as part of rehash ***/
          
      index = ( ( index + constant ) % array.length );
      
      while ( array[ index ] != null )
      {   
         index = ( index + constant ) % array.length;         
      }
          
      return index;
   }
   
   public  int indexOf( Object obj )
   {
      /*** Local Constants ***/
      
      final int NOT_FOUND = -1;
      
      /*** Calculate hash index ***/
      
      int index = Math.abs( obj.hashCode() % array.length );
      
      /*** Search array, rehashing until found or empty ***/
      
      while ( array[ index ] != null )
      {
         if ( array[ index ].equals( obj ) )  //found it
         {
            return index;
         }
         else //search for it in a rehashing manner
         {
            index = ( index + constant ) % array.length;  
            
            System.out.println( "Looking at index " + index );
         }
      }
       
      return NOT_FOUND;
   }
}

/********************************************************/

class HashtableChaining implements Hashtable
{
   private LinkedList[] array;
   public HashtableChaining(int size)
   {
                            //instantiate the array
       array = new LinkedList[ size ];                   
                            //instantiate the LinkedLists
       for ( int i = 0; i < array.length; i++ )
       {
           array[ i ] = new LinkedList();
       }                          
   }
   
   public void add( Object obj )
   {
      int code = obj.hashCode();
      int index = Math.abs(code % array.length);
      
      /*** Inserts obj at beginning of linkedlist ***/
      
      array[ index ].addFirst( obj );
      
      System.out.println(obj + "\t" + code + " " + " at " +index + ": "+ array[index]);
   }  
   
   public int indexOf( Object obj )
   {
      final int NOT_FOUND = -1;
      
      int index = Math.abs(obj.hashCode() % array.length);
      
      if ( !array[ index ].isEmpty() )
      {
         /*** Look at first element in list to see if it matches ***/
         
         if ( ( array[ index ].get( 0 ) ).equals( obj ) )   //found it -- 
         {
            return index;
         }
         else   //search for it in a chaining manner
         {
            /*** Check to see if obj is in linked list ***/
            
            for ( int i = 1; i < array[ index ].size(); i++ )
            {
               if ( ( array[ index ].get( i ) ).equals( obj ) ) 
                  return index;            
            }
         }
      }
      
      return NOT_FOUND;
   }
}