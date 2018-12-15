//name: Rayyan    date: 9/27/16
   import java.util.Scanner;
    public class Permutations
   {
       public static void main(String[] args)
      { 
         Scanner sc = new Scanner(System.in);
         System.out.println("How many digits? ");
         int n = sc.nextInt();
         //System.out.println("\nleftRight:");
         leftRight("", n); 
         //System.out.println("\noddDigits:");                      //when submitting, uncomment all of these
         oddDigits("", n);
         //System.out.println("\nsuperprime:");
         superprime(n);
      }
   
       public static void leftRight(String s, int n)
       {
          if(s.length()==n)
             System.out.println(s); 
          else
          {
             leftRight(s+"L",n);
             leftRight(s+"R",n);
          }
       }
   
       public static void oddDigits(String s, int n)
      {
          if(s.length() == n)
            System.out.println(s);
          else
          {
            oddDigits(s+"1",n);
            oddDigits(s+"3",n);
            oddDigits(s+"5",n);
            oddDigits(s+"7",n);
            oddDigits(s+"9",n);
          }   
      }
       public static void superprime(int n)
      {
         recur(2, n); //try leading 2, 3, 5, 7, i.e. all the single-digit primes
         recur(3, n); 
         recur(5, n);
         recur(7, n);
      }
       private static void recur(int k, int n)
      {
         String s = "" + k;
         if(s.length() == n)
         {
            int m = Integer.parseInt(s);
            if(isPrime(m)==true)
               System.out.println(s);
         }
         else if(isPrime(Integer.parseInt(s)) == true)
         {
            recur(Integer.parseInt(s + "1"), n);
            recur(Integer.parseInt(s + "2"), n);
            recur(Integer.parseInt(s + "3"), n);
            recur(Integer.parseInt(s + "4"), n);
            recur(Integer.parseInt(s + "5"), n);
            recur(Integer.parseInt(s + "6"), n);
            recur(Integer.parseInt(s + "7"), n);
            recur(Integer.parseInt(s + "8"), n);
            recur(Integer.parseInt(s + "9"), n);            
         }
         
      }
       private static boolean isPrime(int n)
      {
         boolean b = true;
         for(int a = 2; a<n; a++)
         {
            if(n%a == 0 && !(a==n))
               b = false;
         }      
         return b;
      }
   }
