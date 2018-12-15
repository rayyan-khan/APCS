import java.util.*;
import java.io.*;
public class testScan{
   public static void main(String[] args) throws Exception
   {
      Scanner s = new Scanner(new File("cities2.txt"));
      for(int k=0; k<5; k++)
      {
         System.out.println(s.next());
      }
   }
}