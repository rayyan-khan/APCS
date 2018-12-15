//name:     date:
   
import java.util.*;
public class Postfix
{
   public static void main(String[] args)
   {
      System.out.println("Postfix  -->  Evaluate");
      ArrayList<String> postExp = new ArrayList<String>();
      /*  enter tests here  */
      postExp.add("345*+");
      postExp.add("34*5+");
      postExp.add("45+53*-");
      postExp.add("34+56+*");
      postExp.add("345+*2-5/");
      postExp.add("812*+93/-");
      
      
      
      for( String pf : postExp )
      {
         System.out.println(pf + "\t\t" + eval(pf));
      }
   }
   public static int eval(String postfix)
   {
     Stack<Integer> stack = new Stack<Integer>();
     if(postfix.equals(""))
     {
        return 0;
     }
     else
     {
        for(int n = 0; n<postfix.length(); n++)
        {
           Character s = postfix.charAt(n);
   
           if(n == 0 || n ==1)
           {
              String t = s.toString();
              Integer i = Integer.parseInt(s.toString());
              stack.push(i);
           }
           else if(isOperator(s) == true)
           {
              if(s.equals('*'))
                stack.push(eval(stack.pop(), stack.pop(),'*'));
              else if(s.equals('/'))
              {
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.push(eval(b, a, '/'));
              }
              else if(s.equals('+'))
                stack.push(eval(stack.pop(), stack.pop(), '+'));
              else
                {
                  Integer a = stack.pop();
                  Integer b = stack.pop();
                  stack.push(eval(b, a, '-'));
                }
           }
           else
           {
              String t = s.toString();
              Integer i = Integer.parseInt(s.toString());
              stack.push(i);
           } 
        }
     }
     return stack.peek();
   }
      
   
   public static int eval(int a, int b, char ch)
   {
      int ev = 0;
      if(isOperator(ch) == true)
      {
         if(ch == '+')
            ev = a + b;
         else if(ch == '-')
            ev = a - b;
         else if(ch == '*')
            ev = a * b;
         else
            ev = a/b;    
      }   
      return ev;    
   }
   public static boolean isOperator(char ch)
   {
      boolean b = false;
      if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
         b = true;
      return b; 
   }
}

/*
 Postfix  -->  Evaluate
 345*+		23
 34*5+		17
 45+53*-		-6
 34+56+*		77
 345+*2-5/		5
 812*+93/-		7  
 */