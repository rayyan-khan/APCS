import java.util.*;
public class Test
{
   public static void main(String[] args)
   {
      Stack<Integer> s = new Stack<Integer>();
      s.add(3);
      s.add(4);
      s.add(20);
      s.add(29);
      System.out.println(s);
      
      Stack<Integer> test = stutter(s);
      System.out.println(test);
   }
   public static Stack<Integer> splitStack(Stack<Integer> s)
   {
       Queue<Integer> q = new LinkedList<Integer>();
       int size = 0;
       while(!s.isEmpty())
       {
           q.add(s.pop()); 
           size++;       
       }
       for(int n = 0; n<size; n++)
       {
           if(q.peek() < 0)
               s.push(q.poll());
           else
               q.add(q.poll());
       }
       while(!q.isEmpty())
       {
           s.push(q.poll());
       }
       return s;
   }
   public static Stack<Integer> stutter(Stack<Integer> s)
   {
      Queue<Integer> q = new LinkedList<Integer>();
      int n = 0;
      while(!s.isEmpty())
      {
         q.add(s.pop());
         n++;
      }
      for(int k = 0; k<n; k++)
      {
         s.push(q.poll());
      }
      for(int l = 0; l<n; l++)
      {
         q.add(s.pop());
      }
      for(int t = 0; t<n; t++)
      {
         int x = q.peek();
         s.push(q.poll());
         s.push(x);
      }
      return s;
   }
}