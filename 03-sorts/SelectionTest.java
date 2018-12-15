public class SelectionTest
{
   public static void main(String[] args)
   {
      //////////////////double sort testing\\\\\\\\\\\\\\\\\\\\\\
      //check findMax
      double[] a = {7, 6, 8, 4, 3, 2, 1};
      System.out.println(a[findMax(a,a.length-1)]);
      //check swap
      print(a);
      swap(a, 0, 6);
      System.out.println("");
      print(a);
      //check sort
      System.out.println("");
      System.out.println("Sort");
      print(a);
      sort(a);
      System.out.println("");
      print(a);
      
      
      //////////////////////////////string sort test
      String[] array = {"apple", "bottle", "cat", "deer", "firetruck", "hi", "jar", "kite"};
      //String[] array = {"a","b","c","d","e","f","g"};
      print(array);
      System.out.println("SWAP:");
      swap(array, 0, array.length-1);
      swap(array, 3, 6);
      swap(array, 2, 4);
      print(array);
      System.out.println("FINDMAX:");
      System.out.println(findMax(array, 5) + ", " + array[findMax(array,5)]);
      System.out.println("SORT:");
      print(array);
      sort(array);
      print(array);
      
   }
   //////////////////////////////////////////string sort tests
   public static void print(double[] a)
   {
      for(int l = 0; l<a.length; l++)
      {
         System.out.print(a[l] + " ");
      }
      System.out.println("");
   }
   public static void swap(String[] array, int a, int b)
   {
      String t = array[b];
      array[b] = array[a];
      array[a] = t;
   }
   public static int findMax(String[] array, int upper)
   {
      int max = 0;
      for(int a = 0; a<=upper; a++)
      {
         if(array[a].compareTo(array[max])>0)
         {
            max = a;
         }
      }
      return max;
   }
   public static String[] sort(String[] array)
   {
      for(int n = 0; n<array.length; n++)
      {
         int m = findMax(array, array.length-(n+1));
         swap(array, m, array.length-(n+1));
      }
      return array;
   }
   
   
   
   ////////////////////////////////////////////////////double sort methods
   private static int findMax(double[] array, int n)
   {
      int max = 0;
      for(int a = 0; a<=n; a++)
      {
         if(array[a]>array[max])
         {
            max = a;
         }
      }
      return max;
   }
   public static void swap(double[] array, int a, int b)
   {
      double t = array[b];
      array[b] = array[a];
      array[a] = t;
   }
   public static double[] sort(double[] array)
   {
      for(int n = 0; n<array.length; n++)
      {
         int m = findMax(array, array.length-(n+1));
         swap(array, m, array.length-(n+1));
      }
      return array;
   }
   public static void print(String[] a)
   {
      for(int l = 0; l<a.length; l++)
      {
         System.out.print(a[l] + " ");
      }
      System.out.println("");
   }

}