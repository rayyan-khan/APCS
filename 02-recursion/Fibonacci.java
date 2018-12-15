//Author:  Rayyan
//Date: 9/29/16      
   import java.util.Scanner;
   public class Fibonacci
	   {
      public static void main(String[] args)
      {
         long start, end, fib;
         int[] fibNumber = {1, 5, 10, 20, 30, 40, 41, 42};
         System.out.println("\tFibonacci\tBy Iteration\tTime\tby Recursion\t Time");
         for(int n = fibNumber[0]; n <= fibNumber[fibNumber.length - 1]; n++)
         { 
            start = System.nanoTime();
            fib = fibIterate(n);
            end = System.nanoTime();
            System.out.print("\t\t" + n + "\t\t" + fib + "\t" + (end-start)/1000.);
            start = System.nanoTime();   	
            fib = fibRecur(n);      
            end = System.nanoTime();
            System.out.println("\t" + fib + "\t\t" + (end-start)/1000.);
         }
      }
   	/***********************
   	Calculates the nth Fibonacci number by iteration
   	***********************/
      public static long fibIterate(int n)
      {
         long first = 0;
         long second = 1;
         long sum = 0;
         for(int x = 0; x<n; x++)
         {
            sum = first+second;
            first = second;
            second = sum;
         } 
         return sum;         
      }
   	/***********************
   	Calculates the nth Fibonacci number by recursion
   	***********************/
      public static long fibRecur(int n)
      {
         long sum = 0;
         if(n==0)
            sum+=0;
         else if(n==1)
            sum+=1;
         else
            sum+=fibRecur(n-1)+fibRecur(n-2); 
            
         return sum;        
      }
   }