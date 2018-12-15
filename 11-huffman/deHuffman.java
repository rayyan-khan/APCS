// Name:              Date:
import java.util.Scanner;
import java.io.*;
public class deHuffman
{
   public static void main(String[] args) throws IOException
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("\nWhat binary message (middle part)? ");
      String middlePart = keyboard.next();
      Scanner sc = new Scanner(new File("message."+middlePart+".txt")); 
      String binaryCode = sc.next();
      Scanner huffLines = new Scanner(new File("scheme."+middlePart+".txt")); 
      	
      TreeNode root = huffmanTree(huffLines);
      String message = dehuff(binaryCode, root);
      System.out.println(message);
      	
      sc.close();
      huffLines.close();
   }
   public static TreeNode huffmanTree(Scanner huffLines)
   {
      TreeNode t = new TreeNode(null,null,null);
      TreeNode c = t;
      
      while(huffLines.hasNext())
      {
         c = t;
         String line = huffLines.nextLine();
         String letter = line.substring(0,1);
         String nums = line.substring(1);
         
         for(int k = 0; k<nums.length()-1; k++)
         {
            if(nums.substring(k, k+1).equals("0"))
            {
               if(c.getLeft() == null)
               {
                  c.setLeft(new TreeNode(null, null, null));
               }
               c = c.getLeft();
            }
            else if(nums.substring(k, k+1).equals("1"))
            {
               if(c.getRight() == null)
               {
                  c.setRight(new TreeNode(null, null, null));
               
               }
               c = c.getRight();
            }
         }
         if((nums.substring(nums.length()-1)).equals("0"))
            c.setLeft(new TreeNode(letter, null, null));
         else if((nums.substring(nums.length()-1)).equals("1"))
            c.setRight(new TreeNode(letter, null, null));
      }   
      return t;    
   }
   public static String dehuff(String text, TreeNode root)
   {
      
      String str = text;
      int k = 0;
      TreeNode current = root;
      String returnStr = "";
      while(str.length() > 0)
      {  
         if(str.substring(0,1).equals("0"))
         {
            current = current.getLeft();
            if(current.getLeft() == null)
            {
               returnStr = returnStr + current.getValue();
               current = root; 
            }
           
               
               
            str = str.substring(1);
         
         }
         else
         {
            current = current.getRight();
            if(current.getRight() == null)
            {
               returnStr += current.getValue();
               current = root; 
            }
            
               
             
            str = str.substring(k+1, str.length());
         }
      }
      return returnStr;
   }
}

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
