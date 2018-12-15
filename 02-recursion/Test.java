//import java.util.*;
//import java.io.*;
public class Test
{
   public static void main(String[] args) //throws FileNotFoundException
   {
      printNumber(52);
   }
   
   public static void printNumber(int n)
   {
      if(n>=0)
      {
         printNumber(n-1);
         System.out.print(n);
      }
   }


}