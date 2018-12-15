// name:        date: 
import java.util.*;
import java.io.*;
public class Huffman
{
   public static Scanner keyboard = new Scanner(System.in);
   public static void main(String[] args) throws IOException
   {
      //Prompt for two strings 
      System.out.print("Encoding using Huffman codes");
      System.out.print("\nWhat message? ");
      String message = keyboard.nextLine();
   
      System.out.print("\nEnter middle part of filename:  ");
      String middlePart = keyboard.next();
   
      huffmanize( message, middlePart );
   }
   public static void huffmanize(String message, String middlePart) throws IOException
   {
         //Make a frequency table of the letters
         Map<String, Integer> map = new HashMap<String, Integer>();
         for(int n = 0; n<message.length(); n++)
         {
            Set<String> s = map.keySet();
            String letter = message.substring(n, n+1);
            if(s.contains(letter))
               map.put(letter, map.get(letter)+1);
            
            else
               map.put(letter, 1);
         }
      	//Put each letter-frequency pair into a HuffmanTreeNode. Put each 
   		//        node into a priority queue (or a min-heap).  
         Set<String> set = map.keySet();
         PriorityQueue<HuffmanTreeNode> pq = new PriorityQueue<HuffmanTreeNode>();
         for(String s : set)
         {  
            HuffmanTreeNode htn = new HuffmanTreeNode(s, map.get(s));
            pq.add(htn);
         }
      	//Use the priority queue of nodes to build the Huffman tree
         while(pq.size()>1)
         {
            HuffmanTreeNode elsa = pq.poll();
            HuffmanTreeNode bird = pq.poll();
            HuffmanTreeNode huff = new HuffmanTreeNode("*", elsa.getFrequency() + bird.getFrequency());
            huff.setLeft(elsa);
            huff.setRight(bird);
            pq.add(huff);
         }
      	//Process the string letter-by-letter and search the tree for the 
   		//       letter. It's recursive. As you recur, build the path through the tree, 
   		//       where going left is 0 and going right is 1.
         HuffmanTreeNode tree = pq.poll();
         String huffCode = "";
         Map hm = new HashMap<String, String>();
         hm = buildScheme(hm, tree, huffCode);
         Set<Map.Entry<String,String>> set2= hm.entrySet();
         for(Map.Entry<String,String> me : set2)
         {
            System.out.println(me.getKey() + me.getValue());
         }
        //  for(int n = 0; n<hm.size(); n++)
//          {
//             String s = message.substring(n, n+1);
//             String s2 = findLetter(tree, s, "");
//             huffCode += s2;
//          }
         //System.out.println the binary message 
//          System.out.println(huffCode);
      	//Write the binary message to the hard drive using the file name ("message." + middlePart + ".txt")
         System.setOut(new PrintStream(new FileOutputStream("message." + middlePart + ".txt")));
         for(int n = 0; n<message.length(); n++)
         {
            String letter = message.substring(n, n+1);
            System.out.print(hm.get(letter));
         } 
         System.out.println();
                  //System.out.println the scheme from the tree--needs a recursive helper method
      	//Write the scheme to the hard drive using the file name ("scheme." + middlePart + ".txt") 
 //        System.setOut(new PrintStream(new FileOutputStream("scheme." + middlePart + ".txt")));
       
         System.setOut(new PrintStream(new FileOutputStream("scheme." + middlePart + ".txt")));
         for(Map.Entry<String,String> me : set2)
         {
            System.out.println(me.getKey() + me.getValue());
         }              
   }
   public static Map<String, String> buildScheme(Map<String, String> m, HuffmanTreeNode htn , String str)
   { //at first, str = ""
      if(htn.getLeft() == null || htn.getRight() == null)
      {
         m.put(htn.getValue(), str);
         //return m;
      }
      else
      {
         buildScheme(m, htn.getLeft(), str + "0");
         buildScheme(m, htn.getRight(), str + "1"); 
      }
      return m;

   }
 
}


	/*
	  * This tree node stores two values.  Look at TreeNode's API for some help.
	  * The compareTo method must ensure that the lowest frequency has the highest priority.
	  */
class HuffmanTreeNode implements Comparable<HuffmanTreeNode>
{
    private String value; 
    private int frequency;
    private HuffmanTreeNode left;
    private HuffmanTreeNode right;
   
       public HuffmanTreeNode(String initValue, int f)
      { 
         value = initValue; 
         frequency = f;
         left = null; 
         right = null; 
      }
   
       public HuffmanTreeNode(String initValue, HuffmanTreeNode initLeft, HuffmanTreeNode initRight)
      { 
         value = initValue; 
         left = initLeft; 
         right = initRight; 
      }
   
       public String getValue()
      { 
         return value; 
      }
   
       public HuffmanTreeNode getLeft() 
      { 
         return left; 
      }
   
       public HuffmanTreeNode getRight() 
      { 
         return right; 
      }
   
       public void setValue(String theNewValue) 
      { 
         value = theNewValue; 
      }
   
       public void setLeft(HuffmanTreeNode theNewLeft) 
      { 
         left = theNewLeft;
      }
   
       public void setRight(HuffmanTreeNode theNewRight)
      { 
         right = theNewRight;
      }
      
      public int getFrequency()
      {
         return frequency;
      }
      
      public int setFrequency(int n)
      {
         frequency = n;
         return frequency;
      }
      
      public int compareTo(HuffmanTreeNode h)
      {
          return frequency - h.getFrequency();
      }

}
