//name: Rayyan   date:  

   import java.io.*;      //the File class
   import java.util.*;    //the Scanner class
   
    public class Widget_Driver
   {
      public static final int numberOfWidgets = 57;
       public static void main(String[] args) throws Exception
      {
         Comparable[] array = input("widget.txt");
         Selection.sort(array);
         print(array);
      }
          	
       public static Comparable[] input(String filename) throws Exception
      {
         Scanner s = new Scanner(new File(filename));
         int num = 0;
         while(s.hasNext())
         {
            num++;
            s.next();
         }
         
         int[] array = new int[num];
         Scanner sc = new Scanner(new File(filename));
         
         for(int n = 0; n<num; n++)
         {
            array[n] = Integer.parseInt(sc.next());
         }
         
         Comparable[] widge = new Widget[num/2];
         for(int m = 0; m<num/2; m+=2)
         {
            Widget w = new Widget(array[m], array[m+1]);
            widge[m/2] = w;
         }
         
         return widge;
      }
   	  
       public static void print(Object[] mango)
      {
         for(int n = 0; n<mango.length/2; n++)
         {
            System.out.println(mango[n].toString());
         }
      }
   }
   /////////////////////////////////////////////////////
	//name:  Rayyan  date:

    class Widget implements Comparable<Widget>
   {  
      //private data
      private int pounds;
      private int oz;
      private int totalOz;
      
      public Widget(int p, int o)
      {
         pounds = p;
         oz = o;
         totalOz = p*16+o;
      }
      //accessors and modifiers
      public int getPounds()
      {
         return pounds;
      }
      public int getOz()
      {
         return oz;
      }
      public int getTotalOz()
      {
         return totalOz;
      }
      public void setPounds(int p)
      {
         pounds = p;
      }
      public void setOz(int o)
      {
         oz = o;
      }
      //overridden methods
      public String toString()
      {
         if(pounds<10)                   //an extra space so it aligns nicely
            return "Pounds: " + pounds + "  Ounces: " + oz;
         else
            return "Pounds: " + pounds + " Ounces: " + oz;
      }
      public int compareTo(Widget other)
      {
         int o = other.getTotalOz();
         int t = totalOz;
         
         if(o<t)
            return -1;
         else if(o == t)
            return 0;
         else
            return 1;
      }
      public boolean equals(Widget other)
      {
         if(compareTo(other) == 0)
            return true;
         else
            return false;
      }
      //instance methods
      //none
   }