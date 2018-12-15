  //name:  rayyan  date:  11/14/16
import java.util.*;
public class ListLab1
{
   public static void main(String[] args)
   {
      ListNode head = new ListNode("hello", null);
      head = new ListNode("foo", head);
      head = new ListNode("boo", head);
      head = new ListNode("nonsense", head);
      head = new ListNode("computer",
         	new ListNode("science",
         		new ListNode("java",
         			new ListNode("coffee", head)
         		)
         	)
         );
      /* print(head);
      System.out.println(first(head));
      System.out.println(second(head));
      System.out.println(pointerToLast(head));
      System.out.println(copyOfLast(head));
      head = insertFirst(head, "Rayyan");
      insertLast(head, "Khan");
      print(head); */
      
      /**** uncomment the code below for ListLab1 Extension  ****/
      /*
   	System.out.println("First = " + first(head));
      System.out.println("Second = " + second(head));
      ListNode p = pointerToLast(head);
      System.out.println("Pointer to Last = " + p.getValue()+ " at " + p);
      ListNode c = copyOfLast(head);
      System.out.println("Copy of Last =    " + c.getValue()+ " at " + c);
   	
      Scanner in = new Scanner(System.in);
      System.out.print("Insert what? ");
      String x = in.next();
      head = insertFirst(head, x);
      head = insertLast(head, x);
      print(head); */
   }
   public static void print(ListNode head)
   {
      System.out.print("[");
      while(head != null)
      {
         System.out.print(head.getValue());
         head = head.getNext();
         if(head != null)
            System.out.print(", ");
      }
      System.out.println("]");
   }
   //returns the value of the first node, or null if the list is empty
   public static Object first(ListNode head)
   {
      if(head.getValue() == null)
         return null;
      else
         return head;
   }
   //returns a reference to last node in list
   public static ListNode pointerToLast(ListNode head)
   {
      if(head.getNext() == null)
         return head;
      else
      {
         head = head.getNext();
         return pointerToLast(head);
      }
   }
   //returns the value of the second node, or null if the list is empty
   //or if there is only one node
   public static Object second(ListNode head)
   {
      if(head.getNext().getValue() != null)
         return head.getNext().getValue();
      else
         return null;
   }
   //returns a copy of the last node (not just its value)
   //copyOfLast can be recursive
   public static ListNode copyOfLast(ListNode head)
   {
      if(head == null)
         return null;
      ListNode temp = head;
      if(temp.getNext() == null)
         return head;
      else
      {
         temp = temp.getNext();
         return pointerToLast(temp);
      }   
   }
   //returns a reference to a list whose first node's value is specified
   //by the argument, and the first node's argument
   public static ListNode insertFirst(ListNode head, Object arg)
   {
      if(head == null)
         return null;
      else
      {
         ListNode first = new ListNode(arg, head);
         return first;  
      }
   }
   //returns a reference to a list who's last node's value is specified
   //by the argument, such that this last node has been appended to
   //the original list and had its next set to null
   public static ListNode insertLast(ListNode head, Object arg)
   {
      if(head == null) 
         return null;
      else
      {
         ListNode temp = head;
         ListNode last = new ListNode(arg, null);
         pointerToLast(temp).setNext(last);
         return head;
      }
   }
}