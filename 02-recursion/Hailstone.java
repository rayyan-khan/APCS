//Author:  Rayyan Khan
//Date:    9/29/16
   import java.util.Scanner;
  
    public class Hailstone
   {
       public static void main(String[] args)
      {
         System.out.println("Hailstone Numbers!");
         System.out.print("Enter the start value: ");
         Scanner sc = new Scanner(System.in);
         int start = sc.nextInt();
         int count = hailstone(start);
         System.out.println(" takes " + count + " steps." );
         int count2 = hailstone(start, 1);
         System.out.println(" takes " + count2 + " steps." );
      }
      //recursive, counts the steps with a variable
       public static int hailstone(int n, int count)
      {  
         
         if(n==1)
         {
            System.out.print(n);
            return count;
         }
         else if(n%2==0)
         {  
            System.out.print(n + "-");
            return hailstone(n/2,count+1);
         }
         else
         {
            System.out.print(n + "-");
            return hailstone(n*3+1,count+1);
         }
         
      }
		//recursive, counts the steps without a variable
       public static int hailstone(int n)
      {
         if(n==1)
         {
            System.out.print(n);
            return 1;
         }
         else if(n%2==0)
         {
            System.out.print(n + "-");
            return hailstone(n/2)+1;
         }
         else
         {
            System.out.print(n + "-");
            return hailstone(n*3+1)+1;
         }
      }
   }