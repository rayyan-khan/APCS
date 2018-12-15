  //name:   date: 
import java.util.*;
public class Infix
{
   public static void main(String[] args)
   {
      System.out.println("Infix  -->  Postfix  -->  Evaluate");
      /*enter code here  */
      ArrayList<String> infixExp = new ArrayList<String>();
      /*  enter tests here  */
      infixExp.add("3+4-5");
      infixExp.add("3*4+5");
      infixExp.add("3+4*5");
      infixExp.add("(4+5)-5*3");
      infixExp.add("(3+4)*(5+6)");
      infixExp.add("(3*(4+5)-2)/5");
      infixExp.add("8+1*2-9/3");
       
   
      for( String s : infixExp )
      {
         String pf = infixToPostfix(s);
         System.out.println(s + "       " + pf + "       " + Postfix.eval(pf));
      }
   }
   public static String infixToPostfix(String infix)
   {
      String postfix = "";
      Stack<Character> stack = new Stack<Character>();
      
      for(int n = 0; n<infix.length(); n++)
      {
         Character c = infix.charAt(n);
         
         if(isOperator(c))
         {
            if(stack.empty() == true || isLower(stack.peek(), c))
            {
               stack.push(c);
            }
            else if(stack.peek() != '(')
            {
               String s = stack.pop().toString();
               postfix += s;
               if(!stack.empty() && isLower(stack.peek(), c) == false && stack.peek() != '(')
               {
                  String s2 = stack.pop().toString();
                  postfix += s2;
               }
               stack.push(c);
            }
            else
            {
               stack.push(c);
            }
         }
         else if(c == '(')
         {
            stack.push(c);
         }
         else if(c == ')')
         {
            while(stack.peek() != '(')
            {
               Character ch = stack.pop();
               postfix += ch.toString();
            }
            if(stack.peek() == '(')
               stack.pop();
         }
         else 
         {
            String s = c.toString();
            postfix += s;
         }
      }
      if(stack.empty() == false)
      {
         while(stack.empty() == false)
         {
            String s = stack.pop().toString();
            postfix += s;
         }
      }
      return postfix;
   }
	//returns true if c1 has strictly lower precedence than c2
   public static boolean isLower(char c1, char c2)
   {
      if((c1 == '+' || c1 == '-') && (c2 == '*' || c2 == '/'))
         return true;
      else
         return false;
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
 Infix  -->  Postfix  -->  Evaluate
 3+4*5       345*+       23
 3*4+5       34*5+       17
 (4+5)-5*3       45+53*-       -6
 (3+4)*(5+6)       34+56+*       77
 (3*(4+5)-2)/5       345+*2-5/       5
 8+1*2-9/3       812*+93/-       7
	*/
