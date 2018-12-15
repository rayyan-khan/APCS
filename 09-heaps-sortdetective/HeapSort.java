//Name:     Date:
import java.text.DecimalFormat;
public class HeapSort
{
   public static int SIZE;  //9 or 100
	
   public static void main(String[] args)
   {
   //Part 1: Given a heap, sort it. Do this part first. 
      SIZE = 9;  
      double heap[] = {-1,99,80,85,17,30,84,2,16,1};
      display(heap);
      sort(heap);
      display(heap);       
   //Part 2:  Generate 100 random numbers, make a heap, sort it.
      SIZE = 100;
      double[] heap2 = new double[SIZE + 1];
      heap2 = createRandom(heap2);
      display(heap2);
      makeHeap(heap2, SIZE);
      display(heap2); 
      sort(heap2);
      display(heap2);
   }
   
	//******* Part 1 ******************************************
   public static void display(double[] array)
   {
      for(int k = 1; k < array.length; k++)
         System.out.print(array[k] + "    ");
      System.out.println("\n");	
   }
   public static void sort(double[] array)
   {
      /* enter your code here */
      int k = array.length-1;  
      for(int a = 1; a<array.length; a++)
      {
         swap(array, 1, k);  
         heapDown(array, 1, k);
         k--;
      }   
      if(array[1]>array[2])
         swap(array, 1, 2);     
   }
   public static void swap(double[] array, int a, int b)
   {
      double temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
   public static void heapDown(double[] array, int k, int size)
   {
      if(2*k < size && 2*k+1 < size)  //2 kids
      {
         if(array[k]<array[2*k] || array[k]<array[2*k+1])
         {
            if(array[2*k] >= array[2*k+1])
            {
               swap(array, k, 2*k);
               heapDown(array, 2*k, size);
            }
            else
            {
               swap(array, k, 2*k+1);
               heapDown(array, 2*k+1, size);
            }
         }
      }
      else if(2*k < size)   //just one kid
      {
         if(array[k]<array[2*k])
         {
            swap(array, k, 2*k);
         }            
      }
   }
   
   // ****** Part 2 *******************************************

   //Generate 100 random numbers (between 1 and 100, formatted to 2 decimal places) 
   public static double[] createRandom(double[] array)
   {  
      for(int n = 1; n<array.length; n++)
      {
         DecimalFormat d = new DecimalFormat("0.00");
         double db = Double.parseDouble(d.format(Math.random()*100 + 1));
         array[n] = db;
      }   
      return array; 
   } 
   //turn the random array into a heap
   public static void makeHeap(double[] array, int size)
   {
      for(int k = size/2; k>= 1; k--)
      {
         heapDown(array, k, size);
      }
   }
}

