public class InsertTest
{
   public static void main(String[] args)
   {
      double[] a = {1,2,3,4,5,3};
      System.out.println(shift(a, 5, 3));
      sort(a);
      print(a);
   }
   public static void print(double[] a)
   {
      for(int l = 0; l<a.length; l++)
      {
         System.out.print(a[l] + " ");
      }
      System.out.println("");
   }
   private static int shift(double[] array, int index, double value)
   { 
      int n = index-1;
      while(n>0)
      {
         if(array[n]>value)
         {
            array[n+1]=array[n];
            if(n==0)
               array[0]=value;
         }
         else
         {
            array[n+1]=value;
         }
         n--;
      }
      return n;
   }
   public static double[] sort(double[] array)
   { 
      for(int n = 0; n<array.length; n++)
      {
         shift(array, n, array[n]);
      }
      return array;
   }
}