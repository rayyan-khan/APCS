//name:    date:  
import java.util.*;
/****************************************************************
	Make an ArrayList of input strings.  Build the Binary Search Trees 
(using TreeNodes) from the letters in the string.   Display it as a sideways 
tree (take the code from TreeLab).  Prompt the user for a target and 
search the BST for it.  Display the tree's minimum and maximum values.  
Print the letters in order from smallest to largest.
	*****************************************************************/
public class BinarySearchTree
{
   public static Scanner keyboard = new Scanner(System.in);
   
   public static void main(String[] args)
   {
      ArrayList<String> str = new ArrayList<String>();
      TreeNode root = null;
      String target = null;
      
      str.add("AB");
      str.add("MAENIRAC");
      str.add("AMERICAN");
      str.add("AACEIMNR");
   
      for ( String s : str )
      {
         /*** Debug ***/
         
         System.out.println( "String: "  + s );
         
         root = buildTree( root, s );
         
         System.out.println( display( root, 0 ) );
         
         System.out.print( "Input target: " );
         
         target =  keyboard.next();    //"I"
         
         boolean itemFound = find(root, target);
         
         if(itemFound)
            System.out.println("found: " + target);
         else
            System.out.println(target +" not found.");
         
         System.out.println("Min = " + min(root));
         System.out.println("Max = " + max(root));	
      
         System.out.print("In Order: ");
         System.out.println( smallToLarge(root) );
         System.out.println("\n---------------------");
      }
   }
   
   public static TreeNode buildTree( TreeNode t, String s )
   {
      /*** Local Variables ***/
   
      String newString = null;
      
      /*** Create tree from individual chars of string ***/
      
      for ( int n = 0; n < s.length(); n++ )
      {
         newString = "" + s.charAt( n );
         t = insert( t, newString );
      }
      
      return t;
   }
     	/**************************
   	Recursive algorithm to build a BST:  if the node is null, insert the 
   	new node.  Else, if the item is less, set the left node and recur to 
   	the left.  Else, if the item is greater, set the right node and recur 
   	to the right.   
   	*****************************/
      
   private static TreeNode insert( TreeNode t, String s )
   {  	
      TreeNode temp = t;
      TreeNode tn = new TreeNode(s);
      if(t == null)
      {
         return tn;
      }
      while(true)
      {
         if(((String)(t.getValue())).compareTo(s)  > 0)
         {
            if(t.getLeft() == null)
            {  
               t.setLeft(tn);
               return temp;
            }
            else
               t = t.getLeft();
         }
         else
         {
            if(t.getRight() == null)
            {
               t.setRight(tn);
               return temp;
            }
            else
               t = t.getRight();
         }
      }
   }
   
   /* copy the code that is in TreeLab  */
   public static String display(TreeNode t, int level)
   {  
      String toRet = "";
      if(t == null)
         return "";
      toRet += display(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         toRet += "\t";
      toRet += t.getValue() + "\n";
      toRet += display(t.getLeft(), level + 1); //recurse left
      return toRet;

   }
   	/********************
      Iterative algorithm:  create a temporary pointer p at the root.  
   	While p is not null, if the p's value equals the target, return true.  
   	If the target is less than the p's value, go left, otherwise go right.   
   	If the target is not found, return false. 
      
   	Find the target. Recursive algorithm:  If the tree is empty, 
   	return false.  If the target is less than the current node 
   	value, return the left subtree.  If the target is greater, return 
   	the right subtree.  Otherwise, return true.   
    	*****************************/    
   public static boolean find(TreeNode t, Comparable x)
   {
      if(t==null)
         return false;
      else if(((Comparable)(t.getValue())).compareTo(x) > 0)
         return find(t.getLeft(), x);
      else if(((Comparable)(t.getValue())).compareTo(x) < 0)
         return find(t.getRight(), x);
      else
         return true; 
   }
      /**************************
   	starting at the root, return the min value in the BST.   
   	Use iteration.   Hint:  look at several BSTs. Where are 
   	the min values always located?  
   	******************************/
   public static Object min(TreeNode t)
   {
      if(t==null)
         return null;
      else
      {
         TreeNode temp = t;
         while(temp.getLeft() != null)
            temp = temp.getLeft();
       return temp.getValue();  
      }
   }
      /*****************
   	starting at the root, return the max value in the BST.  
   	Use recursion!
   	********************/
   public static Object max(TreeNode t)
   {
       if(t==null)
         return null;
      else if(t.getRight() == null)
         return t.getValue();
      else
      {
         return max(t.getRight());
      }
   }
   public static String smallToLarge(TreeNode t)
   {
      String re = "";
      if(t == null)
         return "";
      re += smallToLarge(t.getLeft()); //recurse left
      re += t.getValue() + " ";           //inorder visit
      re += smallToLarge(t.getRight());//recurse right
      return re;

   }
}
   /***************************************
 String: MAENIRAC
 		R
 	N
 M
 			I
 		E
 			C
 	A
 		A
 Input target: I
 found: I
 Min = A
 Max = R
 In Order: A A C E I M N R 
 ---------------------
 String: AMERICAN
 		R
 			N
 	M
 			I
 		E
 			C
 A
 	A
 Input target: I
 found: I
 Min = A
 Max = R
 In Order: A A C E I M N R 
 ---------------------
 String: AACEIMNR
 						R
 					N
 				M
 			I
 		E
 	C
 A
 	A
 Input target: i
 i not found.
 Min = A
 Max = R
 In Order: A A C E I M N R 
 ---------------------   
 ************************************/