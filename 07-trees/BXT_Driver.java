//name:     date:
import java.util.*;
  
/*******************
Represents a binary expression tree.
The BXT can build itself from a postorder expression.  It can
evaluate and print itself. It also prints an inorder string and a preorder string.  
**********************/
class BXT
{
   private int count;
   private TreeNode root;
   public BXT()
   {
      count = 0;
      root = null;
   }
  /*  enter your instance methods here.  */
      //buildTree
      //display
      //inorderTraverse
      //preorderTraverse
      //evaluateTree  
      
   public void buildTree(String input)
   {
      StringTokenizer str = new StringTokenizer(input);
      boolean operator = false;
      Stack<TreeNode> stack = new Stack<TreeNode>();
  
      while(str.hasMoreTokens())
      {
         String s = str.nextToken();
         operator = false;
         
         if(s.equals("*") || s.equals("/") || s.equals("-") || s.equals("+"))
            operator = true;
         
         TreeNode c = new TreeNode(s);
         
         if(operator == false)
         {
            stack.push(c);
         }
         
         else
         {
            TreeNode a = stack.pop();
            TreeNode b = stack.pop();
            
            c.setRight(a);
            c.setLeft(b);
            
            stack.push(c);
         }   
      } 
      root = stack.pop();  
   }
   
   public String display()
   {
      return display(root, 0);
   }
   
   private String display(TreeNode t, int level) 
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

   public String inorderTraverse()
   {
      return inorderTraverse(root);      
   }
   
   private String inorderTraverse(TreeNode tn)
   {
      String s = ""; 
      
      if(tn.getLeft() == null && tn.getRight() == null)
      {
         s += tn.getValue();
         return s;
      }
      else
      {
         s += inorderTraverse(tn.getLeft()) + " ";
         s += tn.getValue() + " ";
         s += inorderTraverse(tn.getRight()) + " ";
         return s;
      }
   }
   
   public String preorderTraverse()
   {
      return preorderTraverse(root);      
   }
   
   private String preorderTraverse(TreeNode tn)
   {
      String s = ""; 
      
      if(tn.getLeft() == null && tn.getRight() == null)
      {
         s += tn.getValue();
         return s;
      }
      else
      {
         s += tn.getValue() + " ";
         s += preorderTraverse(tn.getLeft()) + " ";
         s += preorderTraverse(tn.getRight()) + " ";
         return s;
      }
   }


}
/*******************
Driver for a binary expression tree class.
Input: a postfix string, each token separated by a space.
**********************/
public class BXT_Driver
{
   public static void main(String[] args)
   {
      ArrayList<String> postExp = new ArrayList<String>();
      postExp.add("14 -5 / ");
      postExp.add("20 3 -4 + * ");
      postExp.add("2 3 + 5 / 4 5 - *");
   
      for( String postfix : postExp )
      {
         System.out.println("Postfix Exp: "  + postfix);
         BXT tree = new BXT();
         tree.buildTree( postfix );
         System.out.println("BXT: "); 
         System.out.println( tree.display() );
         System.out.print("Infix order:  ");
         System.out.println( tree.inorderTraverse() );
         System.out.print("Prefix order:  ");
         System.out.println( tree.preorderTraverse() );
         //System.out.print("Evaluates to " + tree.evaluateTree()); 
         System.out.println( "\n------------------------");
      }
   }
}

/***************************************
 Postfix Exp: 14 -5 / 
 BXT: 
 	-5
 /
 	14
 Infix order:  14 / -5 
 Prefix order:  / 14 -5 
 Evaluates to -2.8
 ------------------------
 Postfix Exp: 20 3 -4 + * 
 BXT: 
 		-4
 	+
 		3
 *
 	20
 Infix order:  20 * 3 + -4 
 Prefix order:  * 20 + 3 -4 
 Evaluates to -20.0
 ------------------------
 Postfix Exp: 2 3 + 5 / 4 5 - *
 BXT: 
 		5
 	-
 		4
 *
 		5
 	/
 			3
 		+
 			2
 Infix order:  2 + 3 / 5 * 4 - 5 
 Prefix order:  * / + 2 3 5 - 4 5 
 Evaluates to -1.0
 ------------------------
 */