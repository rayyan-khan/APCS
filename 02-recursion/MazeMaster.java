//name:  Rayyan Khan  date: 10/23/00
import java.util.*;
import java.io.*;
public class MazeMaster
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the maze's filename: ");
      char[][] retArr = buildCharArr(sc.next()); 
      Maze m = new Maze(retArr);
      
      m.display();
      System.out.println("Options: ");
      System.out.println("1: Mark all paths.");
      System.out.println("2: Mark all paths, and display the count of all steps.");
      System.out.println("3: Show only the correct path.");
      System.out.println("4: Show only the correct path. If no path exists, display 'No path exists'.");
      System.out.println("5: Show only the correct path, and display the count of steps.");
      System.out.print("Please make a selection: ");
      m.solve(sc.nextInt());
      m.display();  
   } 
   //take in a filename, and return a char[][]
   public static char[][] buildCharArr(String filename)
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
}


class Maze
{
   //Constants
   private final char WALL = 'W';
   private final char PATH = '.';
   private final char START = 'S';
   private final char EXIT = 'E';
   private final char STEP = '*';
   //fields
   private char[][] maze;
   private int startRow, startCol;
   private boolean S_Exists=false, E_Exists=false;
   //constructor initializes all the fields
   public Maze(char[][] inCharArr)    
   {
      maze = inCharArr;
      
      for(int r = 0; r<inCharArr.length; r++)
      {
         for(int c = 0; c<inCharArr[0].length; c++)
         {
            String s = "" + inCharArr[r][c];
            if(s.equals("S"))
            {
               S_Exists = true;
               startRow = r;
               startCol = c;
            }
            if(s.equals("E"))
            {
               E_Exists = true;
            }
         }
      }

   }
   
   public void display()
   {
      if(maze==null) 
         return;
      for(int a = 0; a<maze.length; a++)
      {
         for(int b = 0; b<maze[0].length; b++)
         {
            System.out.print(maze[a][b]);
         }
         System.out.println("");
      }
      System.out.println("");
   }
   public void solve(int n)
   {
      if(n==1)
      {
         markAllPaths(startRow, startCol);
      }
      else if(n==2)
      {
         int count = markAllPathsAndCountStars(startRow, startCol);
         System.out.println("Number of steps = " + count);
      }
      else if(n==3)
      {
         displayTheCorrectPath(startRow, startCol);
      }
      else if(n==4)   //use maze3 here
      {
         if( !displayTheCorrectPath(startRow, startCol) )
            System.out.println("No path exists");   
      }     
      else if(n==5)
      {
         displayCorrectPathAndCountStars(startRow, startCol, 0);
      }
      else System.out.println("invalid submission");
      
   }
   private void markAllPaths(int r, int c)
   {
      if(r>=0 && r<maze.length && c>=0 && c<maze[r].length)
      {
         String s = "" + maze[r][c];
         if(s.equals("S"))
         {
            markAllPaths(r+1,c);
            markAllPaths(r-1,c);
            markAllPaths(r,c+1);
            markAllPaths(r,c-1);
         }                        
         else if(s.equals("."))
         {
            maze[r][c] = '*';
            markAllPaths(r+1,c);
            markAllPaths(r-1,c);
            markAllPaths(r,c+1);
            markAllPaths(r,c-1);
         }
      }
   }
        
   private int markAllPathsAndCountStars(int r, int c)
   {
      markAllPaths(r,c);
      //count
      int count = 0;
      for(int row = 0; row<maze.length; row++)
      {
         for(int col = 0; col<maze.length; col++)
         {
            String s = "" + maze[row][col];
            if(s.equals("*"))
               count++;
         }
      }
      return count;
   }

   private boolean displayTheCorrectPath(int r, int c)
   {
      if(r>=0 && r<maze.length && c>=0 && c<maze[0].length)
      {
         if(maze[r][c]=='E')
         {
            return true;
         }
         else if(maze[r][c]=='W')
         {
            return false;
         }
         else if(maze[r][c]=='*')
         {
            return false;
         } 
         else
         {
            maze[r][c] = '*';
            if(displayTheCorrectPath(r+1,c)==true)
            {  
               //maze[r][c] = '*';
               return true;
            }
            if(displayTheCorrectPath(r-1,c)==true)
            {
               //maze[r][c] = '*';
               return true;
            }
            if(displayTheCorrectPath(r,c+1)==true)
            {
               //maze[r][c] = '*';
               return true;
            }
            if(displayTheCorrectPath(r,c-1)==true)
            {
               //maze[r][c] = '*';
               return true;
            }
            else
            {  
               maze[r][c] = '.';
               return false;
            }
         }
      }
      else
         return false;
   }
   
   private boolean displayCorrectPathAndCountStars(int r, int c, int count)
   {
      if(r>=0 && r<maze.length && c>=0 && c<maze[0].length)
      {
         if(maze[r][c]=='E')
         {
            System.out.println(count);
            return true;
         }
         else if(maze[r][c]=='W')
         {
            return false;
         }
         else if(maze[r][c]=='*')
         {
            return false;
         } 
         else
         {
            maze[r][c] = '*';
            if(displayCorrectPathAndCountStars(r+1,c,count+1)==true)
            {  
               //maze[r][c] = '*';
               return true;
            }
            if(displayCorrectPathAndCountStars(r-1,c,count+1)==true)
            {
               //maze[r][c] = '*';
               return true;
            }
            if(displayCorrectPathAndCountStars(r,c+1,count+1)==true)
            {
               //maze[r][c] = '*';
               return true;
            }
            if(displayCorrectPathAndCountStars(r,c-1,count+1)==true)
            {
               maze[r][c] = '*';
               return true;
            }
            else
            {  
               maze[r][c] = '.';
               return false;
            }
         }
      }
      else
         return false;

   }
   
   ///////////////////////////////////////////////////////////////////////
   //This is for testing purposes. Do not change or remove this method.
   public char[][] getMaze()
   {
      return maze;
   }
}
