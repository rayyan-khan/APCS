//name:    date:  
import java.util.*;         //for the queue interface
public class TreeLab
{
   public static TreeNode root = null;
   //public static String s = "XCOMPUTERSCIENCE";
   //public static String s = "XThomasJeffersonHighSchool"; 
   public static String s = "XAComputerScienceTreeHasItsRootAtTheTop"; 
   public static void main(String[] args)
   {
      root = buildTree( root, s );
      System.out.print( display(root, 0) );
   
      System.out.print("\nPreorder: " + preorderTraverse(root));
      System.out.print("\nInorder: " + inorderTraverse(root));
      System.out.print("\nPostorder: " + postorderTraverse(root));
   
      System.out.println("\n\nNodes = " + countNodes(root));
      System.out.println("Leaves = " + countLeaves(root));
      System.out.println("Grandparents = " + countGrands(root));
      System.out.println("Only childs = " + countOnlys(root));	
   
      System.out.println("\nHeight of tree = " + height(root));
      System.out.println("Width = " + width(root));
      System.out.println("Min = " + min(root));
      System.out.println("Max = " + max(root));	
   
      System.out.println("\nBy Level: ");
      System.out.println(displayLevelOrder(root));
   }
   public static TreeNode buildTree(TreeNode root, String s)
   {
      root = new TreeNode("" + s.charAt(1), null, null);
      for(int pos = 2; pos < s.length(); pos++)
         insert(root, "" + s.charAt(pos), pos, 
            (int)(1 + Math.log(pos) / Math.log(2)));
   
      insert(root, "A", 17, 5); 
      insert(root, "B", 18, 5); 
      insert(root, "C", 37, 6); //B's right child
      return root;
   }

   public static void insert(TreeNode t, String s, int pos, int level)
   {
      TreeNode p = t;
      for(int k = level - 2; k > 0; k--)
         if((pos & (1 << k)) == 0)
            p = p.getLeft();
         else
            p = p.getRight();
      if((pos & 1) == 0)
         p.setLeft(new TreeNode(s, null, null));
      else
         p.setRight(new TreeNode(s, null, null));
   }
   
  
   private static String display(TreeNode t, int level) 
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
   
   public static String preorderTraverse(TreeNode t) //works
   { 
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += t.getValue() + " ";  //preorder visit
      toReturn += preorderTraverse(t.getLeft());         //recurse left
      toReturn += preorderTraverse(t.getRight());        //recurse right
      return toReturn;
   }
   public static String inorderTraverse(TreeNode t) //works
   {
      String re = "";
      if(t == null)
         return "";
      re += inorderTraverse(t.getLeft()); //recurse left
      re += t.getValue() + " ";           //inorder visit
      re += inorderTraverse(t.getRight());//recurse right
      return re;
   }
   public static String postorderTraverse(TreeNode t) //works
   {
      String re = "";
      if(t == null)
         return "";
      re += postorderTraverse(t.getLeft());
      re += postorderTraverse(t.getRight());
      re += t.getValue() + " ";
      return re;
   }
   public static int countNodes(TreeNode t) //works
   {
      int count = 0;
      if(t == null)
        count += 0;
      else
      {
         count++;
         count += countNodes(t.getLeft());
         count += countNodes(t.getRight());
      } 
      return count;
   }
   public static int countLeaves(TreeNode t) //works
   {
      int count = 0;
      if(t == null)
        return 0;
      else if(t.getLeft()== null && t.getRight() == null)
      {
         return 1;
      }  
      else
      {
         count += countLeaves(t.getLeft());
         count += countLeaves(t.getRight());
      } 
      return count;
   }
   public static int countGrands(TreeNode t) //doesn't work
   {
      int height = height(t);
      int count = 0;
      if(t == null)
         return 0;
      else if(height < 2)
         return 0;
      else 
      {
         count++;
         count += countGrands(t.getLeft());
         count += countGrands(t.getRight());
      } 
      return count;
   }
   public static int countOnlys(TreeNode t) //works
   {
      int count = 0;
      if(t == null)
        return 0;
      else if(t.getLeft()== null && t.getRight() != null)
      {
         count++;
         if(t.getRight().getRight() == null && t.getRight().getLeft() == null)
            count += 1;
         else
            count += countOnlys(t.getRight());
      } 
      else if(t.getLeft() != null && t.getRight() == null)
      {
         count++;
         if(t.getLeft().getRight() == null && t.getLeft().getLeft() == null)
            count += 1;
         else
            count += countOnlys(t.getRight());
      } 
      else
      {
         count += countOnlys(t.getLeft());
         count += countOnlys(t.getRight());
      } 
      return count;
   }  
   public static int height(TreeNode t) //works
   {
      int count = 0;
      if(t == null || (t.getLeft() == null && t.getRight() == null))
         count+= 0;
      else 
      {
         count++;
         int left = height(t.getLeft());
         int right = height(t.getRight());
         
         if(left > right)
            count+= left;
         else
            count+= right;
      }
      return count;
   }
      /* "width" is the longest path from leaf to leaf */
   public static int width(TreeNode t) //works
   {  
      int left = height(t.getLeft()) + 1;
      int right = height(t.getRight()) + 1;
      
      return left + right;
   }
   @SuppressWarnings("unchecked")//this removes the warning about needing to cast
   public static Object min(TreeNode t) //works
   {
      String tree = preorderTraverse(t);
      String[] array = tree.split(" ");
      
      int minIndex = 0;
      for(int k = 0; k<array.length; k++)
      {
         if(array[minIndex].compareTo(array[k]) > 0)
            minIndex = k;
      }
      return array[minIndex];
   }
   @SuppressWarnings("unchecked")//this removes the warning about needing to cast
   public static Object max(TreeNode t) //works
   {
      String tree = preorderTraverse(t);
      String[] array = tree.split(" ");
      
      int maxIndex = 0;
      for(int k = 0; k<array.length; k++)
      {
         if(array[maxIndex].compareTo(array[k]) < 0)
            maxIndex = k;
      }
      return array[maxIndex];
   }
      /* this method is not recursive.  Use a local queue
   	to store the children of the current node.*/
      @SuppressWarnings("unchecked")
   public static String displayLevelOrder(TreeNode t)
   {
      String re = "";
      Queue<TreeNode> q = new LinkedList<TreeNode>();
      
         q.add(t);
               
      while(q.isEmpty() == false)
      {
         TreeNode tn = q.remove();
         re += tn.getValue();
         
         if(tn.getLeft() != null)
            q.add(tn.getLeft());
         if(tn.getRight() != null)
            q.add(tn.getRight());
      }
      return re;
   } 
}
/***************************************************
	  
   ----jGRASP exec: java Lab01
 
 			E
 		E
 			C
 	M
 			N
 		T
 			E
 C
 			I
 		U
 			C
 	O
 			S
 					C
 				B
 		P
 				A
 			R
 
 Preorder: C O P R A S B C U C I M T E N E C E 
 Inorder: R A P B C S O C U I C E T N M C E E 
 Postorder: A R C B S P C I U O E N T C E E M C 
 
 Nodes = 18
 Leaves = 8
 Grandparents = 5
 Only childs = 3

 Height of tree = 5
 Width = 8
 Min = A
 Max = U
 
 By Level: 
 COMPUTERSCIENCEABC   
*******************************************************/
	  /* TreeNode class for the AP Exams */

class TreeNode
{
   private Object value; 
   private TreeNode left, right;
   
   public TreeNode(Object initValue)
   { 
      value = initValue; 
      left = null; 
      right = null; 
   }
   
   public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight)
   { 
      value = initValue; 
      left = initLeft; 
      right = initRight; 
   }
   
   public Object getValue()
   { 
      return value; 
   }
   
   public TreeNode getLeft() 
   { 
      return left; 
   }
   
   public TreeNode getRight() 
   { 
      return right; 
   }
   
   public void setValue(Object theNewValue) 
   { 
      value = theNewValue; 
   }
   
   public void setLeft(TreeNode theNewLeft) 
   { 
      left = theNewLeft;
   }
   
   public void setRight(TreeNode theNewRight)
   { 
      right = theNewRight;
   }
}
