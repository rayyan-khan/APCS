//name: Rayyan Khan
//date: 9/29/16

import java.util.Scanner;
import java.io.*;
import java.util.*;
public class AreaFill
{
   public static char[][] grid = null;
   public static String filename = null;
      
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner sc = new Scanner(System.in);
      while(true) 
      {
         System.out.print("Filename: ");
         filename = sc.next();
         if(filename.equals("-1"))
         {
            sc.close();
            System.out.println("Good-bye");
            System.exit(0);
         }
                 
         grid = read(filename);
         System.out.println( display(grid) );
         System.out.print("\nEnter ROW COL to fill from: ");
         int row = sc.nextInt();
         int col = sc.nextInt(); 
         grid = fill(grid, row, col, grid[row][col]);
         System.out.println( display(grid) );
        //Extension
        //int count = fillAndCount(grid, row, col, grid[row][col]);
        //System.out.println( display(grid) );
        //System.out.println("count = " + count);
        //System.out.println();
      }
   }
   public static char[][] read(String filename)throws FileNotFoundException
   {
      try
      {
         Scanner scan = new Scanner(new File(filename));
         int row = scan.nextInt();
         int col = scan.nextInt();
         //System.out.println(row + ", " + col);
         
         char[][] array = new char[row][col];
         for(int r = 0; r<row; r++)
         {
            String line = scan.next();
            for(int c = 0; c<col; c++)
            {
               char car = line.charAt(c);
               array[r][c] = car;
            }
         }
         return array;
      }
      catch(FileNotFoundException e)
      {
         System.out.println(e.getMessage());
         return null;
      }
   }
   
   public static String display(char[][] g)
   {    
      String s = "";
      for(int row = 0; row<g.length; row++)
      {  
         for(int col = 0; col<g[0].length; col++)
         {
            /*if(col == g[0].length-1)
               s = s+g[row][col] + "\n";
            else*/
               s = s+g[row][col];
         }
         s+="\n";
      }
      return s;
   }
   public static char[][] fill(char[][] g, int r, int c, char ch) //recursive method
   {  
      if(r>=0 && r<g.length && c>=0 && c<g[r].length && ch==g[r][c])
      {
         ch = g[r][c];
         g[r][c] = '*';
         fill(g,r+1,c,ch);
         fill(g,r-1,c,ch);
         fill(g,r,c+1,ch);
         fill(g,r,c-1,ch);
      }
      return g;
   }
	
	// Extension-- count and return the number of asterisks
   public static int fillAndCount(char[][] g, int r, int c, char ch)
   {
      return 0; 
   }
}