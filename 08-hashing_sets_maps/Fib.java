//Name:       Date:
   import java.util.*;

    public class Fib
   {
      public static final int DEFAULT = 40;
      
       public static void main(String[] args)
      {
         int n = DEFAULT;
         System.out.println("Recursive");
         calculate(new Fib1(), n);
         System.out.println("Iterative, stored in an array");
         calculate(new Fib2(), n);
         System.out.println("Recursive, stored in an arrayList");
         calculate(new Fib3(), n);
         /*System.out.println("Recursive, stored in a hashMap");
         calculate(new Fib4(), n);	*/	
      }
      
       public static void calculate(Fibber fibber, int n)
      {
         long start = System.nanoTime();
         int f = fibber.fib(n);
         long finish = System.nanoTime();
         long time = finish - start;
      
         System.out.print("fib(" + n + ") = " + f);
         System.out.println(" (" + time + " nanoseconds)");		
         System.out.println();		
      }
    
       private static class Fib1 implements Fibber
      {      
          public int fib(int n)
         {
            if(n == 1 || n == 2)
               return 1;
            else
               return fib(n - 1) + fib(n - 2);
         }
      }
       private static class Fib2 implements Fibber
      {
        public int fib(int n)
        {
           if(n<=2)
              return 1;
           int[] array = new int[n+1];
           array[1] = 1;
           array[2] = 1;
           for(int i = 3; i<= n; i++)
           {
              array[i] = array[i-1] + array[i-2];
           }
           return array[n];
        }
      } 
       
       private static class Fib3 implements Fibber
      {
         ArrayList<Integer> aL = new ArrayList<Integer>();
         
         public Fib3()
         {
            aL.add(0);
            aL.add(1);
            aL.add(1);
         }
         
           public int fib(int n)
         {
            if(n == 1 || n == 2)
               return 1;
            else if(aL.size() > n)
               return aL.get(n);
            else
            {
               int result = fib(n - 1) + fib(n - 2);
               aL.add(result);
               return result;
            }           
         }
      }
       /*
       private static class Fib4 implements Fibber
      {
       
      }*/
       private interface Fibber
      {
          public abstract int fib(int n);
      }
   }
   	/*
    Recursive
    fib(42) = 267914296 (3276558048 nanoseconds)
    
    Iterative, stored in an array
    fib(42) = 267914296 (4988 nanoseconds)
    
    Recursive, stored in an arrayList
    fib(42) = 267914296 (64025 nanoseconds)
    
    Recursive, stored in a hashMap
    fib(42) = 267914296 (177793 nanoseconds)
    
   	*/
