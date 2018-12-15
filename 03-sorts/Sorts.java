    /* M.L. Billington, 10/02/2006.
    Uses the helper classes Selection and Insertion. 
	 Students are to write the Selection and Insertion classes.
    */
import java.util.*;
import java.io.*;
public class Sorts
{
   public static void main(String[] args) throws Exception
   {
        //Part 1, for doubles
      int n = (int)(Math.random()*100);
      double[] array = new double[n];
      for(int k = 0; k < array.length; k++)
         array[k] = Math.random();	
      print(array);
      System.out.println("*************  *************");
      array = Selection.sort(array);
     // array = Insertion.sort(array);
      print(array);
         
      	//Part 2, for Strings
      int size = 100;
      Scanner sc = new Scanner(new File("declaration.txt"));
      Comparable[] arrayStr = new String[size];
      for(int k = 0; k < arrayStr.length; k++)
         arrayStr[k] = sc.next();	
      //print(arrayStr);
      System.out.println("*************  *************");
     // arrayStr = Selection.sort(arrayStr);
      arrayStr = Insertion.sort(arrayStr);
      //print(arrayStr);
   }
   public static void print(double[] a)
   {
      // for(int k = 0; k < a.length; k++)    //old style
      //       System.out.println(a[k]);
      for(double d : a)                      // for-each loop     
         System.out.println(d);
      System.out.println();
   }
   public static void print(Object[] papaya)
   {
      for(Object item : papaya)     //for-each
         System.out.println( item );
   }
}
   //*******************************************************************
  //Name:    Rayyan Khan          Date:
  //The Selection class will have methods sort(), findMax() and swap().
  //Three versions of each method will have to be written, to work 
  //for doubles, Strings, and Comparables.
  
class Selection
{
   public static double[] sort(double[] array)
   {
      for(int n = 0; n<array.length; n++)
      {
         int m = findMax(array, array.length-(n+1));
         swap(array, m, array.length-(n+1));
      }
      return array;
   }
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
   private static void swap(double[] array, int a, int b)
   {
      double t = array[b];
      array[b] = array[a];
      array[a] = t;
   }
   	/***************************************************
   	  for Strings
   	  ***********************************************/
   public static String[] sort(String[] array)
   {
      for(int n = 0; n<array.length; n++)
      {
         int m = findMax(array, array.length-(n+1));
         swap(array, m, array.length-(n+1));
      }
      return array;
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
   public static void swap(String[] array, int a, int b)
   {
      String t = array[b];
      array[b] = array[a];
      array[a] = t;
   }
   	/***************************************************
   	 for Comparables,
   	      Swap() is for Objects.
   	      make sure that print() is for Objects, too.
   	  ***********************************************/
   @SuppressWarnings("unchecked")//this removes the warning for Comparable
   public static Comparable[] sort(Comparable[] array)
   {
      for(int n = 0; n<array.length; n++)
      {
         int m = findMax(array, array.length-n-1);
         swap(array, m, array.length-(n+1));
      }
      return array;   
   }
   @SuppressWarnings("unchecked")
   public static int findMax(Comparable[] array, int upper)
   {
      int max = 0;
      for(int a = 0; a<=upper; a++)
      {
         if(array[a].compareTo(array[max])>0)
         {
            max = a;
         }
         else if(array[a] == null)
            return max;
      }
      return max;
   }
   public static void swap(Object[] array, int a, int b)
   {
      Object t = array[b];
      array[b] = array[a];
      array[a] = t;
   }
}   

//**********************************************************
  //Name:     Rayyan Khan     Date:
  //The Insertion class 
  //write enough methods to handle doubles and Comparables.
class Insertion
{
   public static double[] sort(double[] array)
   { 
      for(int n = 0; n<array.length; n++)
      {
         shift(array, n, array[n]);
      }
      return array;
   }
   private static int shift(double[] array, int index, double value)
   {
      int n = index-1;
      while(n>0)
      {
         if(array[n]>value && n>0)
         {
            array[n+1]=array[n];
         }
         else if(n==0)
            array[0] = value;
         else
         {
            array[n+1]=value;
         }
         n--;
      }
      return n;
   }
   @SuppressWarnings("unchecked")
    public static Comparable[] sort(Comparable[] array)
   { 
      for(int n = 0; n<array.length; n++)
      {
         shift(array, n, array[n]);
      }
      return array;
   }
   @SuppressWarnings("unchecked")
    private static int shift(Comparable[] array, int index, Comparable value)
   {
      int n = index-1;
      while(n>0)
      {
         if(array[n].compareTo(value)>0 && n>0)
         {
            array[n+1]=array[n];
         }
         else if(n==0)
            array[0] = value;
         else
         {
            array[n+1]=value;
         }
         n--;
      }
      return n;
   }

}
