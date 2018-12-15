 //name:    date:  
import java.util.*;
import java.io.*;

public class BSTobject_Driver
{
   public static BSTobject<String> tree = null;
   public static BSTobject<Widget> treeOfWidgets = null;
   public static int numberWidgets = 10;
   
   public static void main( String[] args ) 
   {
      //day one   
      
      tree = new BSTobject<String>();
      
      System.out.print( tree );
      System.out.println( "Size: " + tree.size() );
      System.out.println( "Is empty: " + tree.isEmpty() );
            
      tree = build( tree, "AMERICAN" );
      
      System.out.print( tree );
      System.out.println( "Size: " + tree.size() );
      System.out.println( "Is empty: " + tree.isEmpty() );
      
      BSTobject<Widget> widgeTree = new BSTobject<Widget>();
      System.out.println(widgeTree);
      System.out.println( "Size: " + widgeTree.size() );
      System.out.println( "Is empty: " + widgeTree.isEmpty() );
            
      File f = new File("widget.txt");      
      widgeTree = build(widgeTree, f);
      
      System.out.print( widgeTree );
      System.out.println( "Size: " + widgeTree.size() );
      System.out.println( "Is empty: " + widgeTree.isEmpty() );
      
   	////////////////////////////////////////////////////////////////////////////////////	
   	//day two><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
   	//	Your assignment the second day is to finish the BSTobject class.|.|.|.|.|.|.|.|.|
   	//	Specifically, prompt the user for a string, put the characters into a BST,\\\\\\\
   	//	call toString on this tree, and print the size of the tree.<<>><<>><<>><<>><<>><<
      //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
      //day two, Widget~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~			
   	//	Next, fill your BST with 57 Widget objects from widgets.txt.  Display the tree.\\ 
   	//	Then prompt the user to enter pounds and ounces.  If the tree contains that*.*.*.
   	//	Widget, delete it, of course restoring the BST order. Display the new tree\\\\\\\
   	// and its size. If the tree does not contain that Widget, print "Not found".-.*-.*-
      //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
      
     
   }
   
   
   // build the tree for Strings, Day 1
   public static BSTobject<String> build( BSTobject<String> t, String str )
   {
      String newString = null;
                  
      for ( int n = 0; n < str.length(); n++ )
      {
         newString = "" + str.charAt( n );
         t.add(newString);
      }
      
      return t;
         
   }
   
   
   //build the tree for Widgets, Day 2
   public static BSTobject<Widget> build( BSTobject<Widget> tree, File file )
   {
      Scanner infile = null;
      BSTobject<Widget> w = new BSTobject<Widget>();
      try{
         infile = new Scanner( file  );
      }
      catch (Exception e)
      {
         System.exit(0);
      }
      for(int i = 0; i < 10; i++)   
      {
         Widget newWidge = new Widget(infile.nextInt(), infile.nextInt());
         w.add(newWidge);   
      }
      return w;
   }
}




//.\\.//.\\.//.\\.//.\\.//.\\.//.\\.//.\\.//.\\.//.\\.//.\\.//.\\.//.\\.//.\\.//.\\.//.\\.//.\\.//.\\.//.\\.//.\\.//.\\.//.\\.//.\\
interface BSTinterface<E extends Comparable<E>>
{
   public E add( E element );     //returns the object
   public boolean contains( E element );
   public boolean isEmpty();
   public E delete( E element );  //returns the object, not a Node<E>
   public int size();
   public String toString();
}
//\\//\\//\\//\\//\\/\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\/\\//\\//\\//\\//






class BSTobject <E extends Comparable<E>> implements BSTinterface<E>
{ 
    // 2 fields 
    // 1 default constructor
        
   private Node<E> root;
   private int     size;
   
   
   public BSTobject()
   {
      root = null;
      size = 0;
   }
           
   //instance methods
   public E add( E obj )
   {
      root = add( root, obj );
      size++;
      
      return obj;
   }
   
     	/*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\
   	Recursive algorithm to build a BST:  if the node is null, insert the 
   	new node.  Else, if the item is less, set the left node and recur to 
   	the left.  Else, if the item is greater, set the right node and recur 
   	to the right.   
   	*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*/
      
   private Node<E> add( Node<E> t, E obj )
   {      
      Node<E> newNode = null;
      Node<E> currentNode  = t;
      E  currentValue = null;   
      newNode = new Node( obj );
      
      if ( t != null )
      {
         currentValue = currentNode.getValue();
         
         if ( obj.compareTo( currentValue ) < 0 )
         {
            newNode = add( t.getLeft(), obj );
            
            t.setLeft( newNode );
         }
            
         else if ( obj.compareTo( currentValue ) > 0 )
         {
            newNode = add( t.getRight(), obj );
            
            t.setRight( newNode );
         }
         
         else 
         {
            add(t.getRight(), obj);
         }    
      }
      else
      {
         t = new Node<E>(obj);
      }
      return t;
   }
   
   /* implement the interface here.  Use TreeNode as an example,
    but root is a field. You need add, contains, isEmpty, 
    delete, size, and toString.  */

   public boolean contains( E element )
   {
      return find( root, element );
   }
   
   private boolean find( Node<E> tree, E element )
   {
      boolean found = false;   //Assume not found
      
      if ( tree  != null )
      {
          if ( tree.getValue().compareTo( element ) > 0 )
              found = find( tree.getLeft(), element );
              
          else if ( tree.getValue().compareTo( element ) < 0)
              found = find( tree.getRight(), element );
              
          else
              found = true;
      }
      
      return found; 
   }
   
   public boolean isEmpty()
   {
      return ( size == 0 );
   }
   
   public E delete( E element )  //returns the object, not a Node<E>
   {
      return null;
   }
   
   public int size()
   {
      return size;
   }
   
   public String toString()
   {
       return display( root, 0 );
   }
   
   private String display( Node<E> tree, int level )
   { 
      String returnString = "";
      
      if ( tree != null )
      {   
          returnString += display( tree.getRight(), level+1 ); //recurse right
          
          for ( int k = 0; k < level; k++ )
             returnString += "\t";
             
          returnString += tree.getValue() + "\n";
          
          returnString += display( tree.getLeft(), level+1); //recurse left
      }
      
      return returnString;
   }
    
    /***************************private inner class **************/  
   private class Node<E>
   {
      // 3 fields 
      
      private E value;
      private Node<E> left;
      private Node<E> right;
         
      // 2 constructors, one-arg and three-arg
         
      public Node( E val )
      {
         value = val;
         left  = null;
         right = null;
      } 
      
      public Node( E val, Node<E> leftChild, Node<E> rightChild )
      {
         value = val;
         left  = leftChild;
         right = rightChild;
      }
                  
      //methods--Use TreeNode as an example. See the cheat sheet.
            
      public E getValue()
      {
         return value;
      }
      
      public Node<E> getRight()
      {
         return right;
      }
      
      public Node<E> getLeft()
      {
         return left;
      }
           
      public String toString()
      {
         return "" + value; 
      }      
           
      public void setValue(E val)
      {
         value = val;
      }
      
      public void setRight(Node<E> rightChild)
      {
         right = rightChild;
      }
      
      public void setLeft(Node<E> leftChild)
      {
         left = leftChild;
      }
   }
}