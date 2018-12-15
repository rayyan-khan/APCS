import java.io.*;
   import java.util.*;
public class Test
{
   public static void main(String[] args)
   {
      int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      ArrayList<Integer> a = createNumbers(nums);
      System.out.println(a);
   }
    public static ArrayList<Integer> createNumbers(int[] rawNumbers) 
      {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i : rawNumbers)
        {
          Integer n = new Integer(i);
          list.add(n);
        }
        return list;
      }
}
