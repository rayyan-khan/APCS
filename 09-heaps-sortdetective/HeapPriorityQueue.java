//Name:   Date:
 
 //implement the API for java.util.PriorityQueue
 //test this class by using it in McRonaldPQ_working.java.
 //add(E) and remove()  must work in O(log n) time
 
import java.util.*;
public class HeapPriorityQueue<E extends Comparable<E>>
{
   //FIELDS //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
   private ArrayList<E> myHeap;
   
   
   //CONSTRUCTOR //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
   public HeapPriorityQueue()
   {
      myHeap = new ArrayList<E>();
   }
   
   //HEAP METHODS //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
   public void heapDown(ArrayList<E> array, int k, int size)
   {
      if(2*k < size && 2*k+1 < size)  //2 kids
      {
         if(array.get(k).compareTo(array.get(2*k)) > 0 || array.get(k).compareTo(array.get(2*k+1)) > 0)
         {
            if(array.get(2*k).compareTo(array.get(2*k+1)) <= 0)
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
         if(array.get(k).compareTo(array.get(2*k)) > 0)
         {
            swap(array, k, 2*k);
         }            
      }
   }
   //\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\
   public void swap(ArrayList<E> array, int a, int b)
   {
      E temp = array.get(a);
      array.set(a, array.get(b));
      array.set(b, temp);
   }
   //\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\\/\/\/\/\/\/
   public void heapUp(ArrayList<E> array, int k)  
   {
        if(k>0)
        {
            if(array.get(k).compareTo(array.get(k/2)) < 0) //if less than parent
            { 
               swap(array, k, k/2);
               heapUp(array, k/2);
            }
        }
        
   }
   //\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\
   public String toString()
   {
      String str = "[";
      for(int n = 0; n<myHeap.size(); n++)
      {
         if(n != myHeap.size()-1)
            str += "" + myHeap.get(n) + ", ";
         else
            str += "" + myHeap.get(n) + "]";
      }
      return str;
   }
   //\\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\
   //public static void doubleCapacity(ArrayList<E>) ??
   
   
   //PRIORITY QUEUEUE METHODS //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
      
   //peek
   public E peek()
   {
      if(isEmpty() == false)
         return myHeap.get(1);
      else 
         return null;
   }  
   //isEmpty
   public boolean isEmpty()
   {
      if(myHeap == null || myHeap.size() == 0 || myHeap.size() == 1)
         return true;
      return false;
   }
   //size
   public int size()
   {
      return myHeap.size();
   } 
   //add
   public boolean add(E e)
   {
      //add last
      //heapUp
      myHeap.add(e);
      heapUp(myHeap, myHeap.size()-1);
      return true;
   }   
   //remove
   public E remove()
   {
     if(myHeap.isEmpty() != true)
     {   
        if(myHeap.size() == 1)
        {
           E e = myHeap.get(0);
           myHeap.remove(0);
           return e;
        }
        else
        {
        E e = myHeap.get(1);
        swap(myHeap, 1, myHeap.size()-1);
        myHeap.remove(myHeap.size()-1);
        heapDown(myHeap, 1, myHeap.size()-1); 
        return e;
        }
     }    
     return null;
   }  
  
}