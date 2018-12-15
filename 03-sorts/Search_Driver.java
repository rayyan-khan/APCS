	//name:  Rayyan Khan  date:
   import java.io.*;      //the File 
   import java.util.*;    //the Scanner 
   import javax.swing.*;  //the JOptionPane
   public class Search_Driver  
   {
      public static void main(String[] args) throws Exception
      {
         /*String[] array = input("declaration.txt");
         
         Searches s = new Searches();
         String str = "Legislatures";  //words that work: English, abolishing, own, our, independent, beyond, etc.
         System.out.println(s.linear(array,str)); 
         System.out.println(s.binary(array,str));*/
      }
      public static String[] input(String filename) throws Exception
      {
         String[] array = new String[1325];
         Scanner sc = new Scanner(new File(filename));
         for(int n = 0; n<array.length; n++)
         {
            array[n] = sc.next();
         }
         
         //sort
         for(int n = 0; n<array.length; n++)
         {
            int m = findMax(array, array.length-(n+1));
            swap(array, m, array.length-(n+1));
         }
        
         return array;
      }
      //sorting methods
      private static int findMax(Comparable[] array, int upper)
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
      public static void swap(Object[] array, int a, int b)
      {
         Object t = array[b];
         array[b] = array[a];
         array[a] = t;
      }

   }
   
 	/////////////////////////////////////////////////////////
   class Searches
   {
      public static int linearCount = 0;
      private static int binaryCount = 0; 
      
      public Searches()
      {
         linearCount = 0;
         binaryCount = 0;
      }    
      public static int binaryCount()
      {
         return binaryCount;
      }
      public static int linearCount()
      {
         return linearCount;
      }
      public static int linear(Comparable[] array, Comparable target)
      { 
         int index = -1;
         for(int n = 0; n<array.length; n++)
         {
            if(array[n].compareTo(target)== 0)
            {
               linearCount = n;
               index = n;
              // System.out.println("2. " + index);
            }
         }
         return index;
      }
      public static int binary(Comparable[] array, Comparable target)
      {
         return binaryhelper(array,target, 0, array.length);            
      }
      private static int binaryhelper(Comparable[] array, Comparable target, int start, int end)
      {
         try{
            int n = start + ((end-start)/2);
            if(n>0 && n<array.length)
            {
               if(array[n].compareTo(target)<0)
                  return binaryhelper(array,target,n+1,end);
               else if(array[n].compareTo(target)>0)  
                   return binaryhelper(array,target,start,n);
               else
                  return n;
            }
            else
               return -1;
         }
         catch(StackOverflowError e)
         {
            return -1;
         }
      }     
   }