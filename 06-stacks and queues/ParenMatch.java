// name:     date:

import java.util.*;
public class ParenMatch
{
   public static final String left  = "([{<";
   public static final String right = ")]}>";
   public static void main(String[] args)
   {
      System.out.println("Parentheses Match");
      ArrayList<String> parenExp = new ArrayList<String>();
      /* enter tests here */
      parenExp.add("5+7");
      parenExp.add("(5+7)");
      parenExp.add(")5+7(");
      parenExp.add("((5+7)*3)");
      parenExp.add("<{5+7}*3>");
      parenExp.add("[(5+7)*]3");
      parenExp.add("(5+7)*3");
      parenExp.add("5+(7*3)");
      parenExp.add("((5+7)*3");
      parenExp.add("[(5+7]*3)");
      parenExp.add("[(5+7)*3])");
      parenExp.add("([(5+7)*3]");
                  
      for( String s : parenExp )
      {
         boolean good = checkParen(s);
         if(good)
            System.out.println(s + "\t good!");
         else
            System.out.println(s + "\t Sad!");
      }
   }
   public static boolean checkParen(String exp)
   {
      Stack<String> stack = new Stack<String>();
      boolean good = true;
      try{
      for(int n = 0; n<exp.length(); n++)
      {
         String str = "" + exp.charAt(n);
         if(isParen(str) == true)
         {
            if(isOpen(str) == true)
            {
               good = false;
               stack.push(str);
            }
            else
            {
               boolean opp = false;
               if(stack.peek().equals("("))
               {
                  if(str.equals(")"))
                     opp = true;
               }
               else if(stack.peek().equals("["))
               {
                  if(str.equals("]"))
                     opp = true;
               }
               else if(stack.peek().equals("{"))
               {
                  if(str.equals("}"))
                     opp = true;
               }
               else if(stack.peek().equals("<"))
               {
                  if(str.equals(">"))
                     opp = true;
               }
               
               if(opp == true)
               {
                  stack.pop();
                  good = true;
               }
               else
               {
                  good = false;
               }
            }
         }
       }
       if(!stack.isEmpty())
       {
         good = false;
       }
     }
     catch(EmptyStackException e)
     {
       good = false;
     }
      return good;
   }
   public static boolean isParen(String s)
   {
      boolean b = false;
      if(s.equals("(") || s.equals(")") || s.equals("<") || s.equals(">") || s.equals("{") || s.equals("}") || s.equals("[") || s.equals("]"))
         b = true;
      
      return b;
   }
   public static boolean isOpen(String s)
   {  
      boolean b = false;
      if(s.equals("(") || s.equals("{") || s.equals("[") || s.equals("<"))
         b = true;
         
      return b;
   }
}

/*
 Parentheses Match
 5+7	 good!
 (5+7)	 good!
 )5+7(	 BAD
 ((5+7)*3)	 good!
 <{5+7}*3>	 good!
 [(5+7)*]3	 good!
 (5+7)*3	 good!
 5+(7*3)	 good!
 ((5+7)*3	 BAD
 [(5+7]*3)	 BAD
 [(5+7)*3])	 BAD
 ([(5+7)*3]	 BAD
 */
