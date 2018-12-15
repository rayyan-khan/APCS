//name:   date:   
// resource classes and interfaces
// for use with Graphs0: Intro
//              Graphs1: Wardhall
//              Graphs2: Floyd
import java.util.*;
import java.io.*;

interface AdjacencyMatrix
{
   public void addEdge(int source, int target);
   public void removeEdge(int source, int target);
   public boolean isEdge(int from, int to);
   public void displayGrid();
   public int edgeCount();
   public List<Integer> getNeighbors(int source);
   
}

interface Warshall
{
   //User-friendly functionality
   public boolean isEdge(String from, String to);
   public Map<String, Integer> getVertices();     
   public void readNames(String fileName) throws FileNotFoundException;
   public void readGrid(String fileName) throws FileNotFoundException;
   public void displayVertices();
   //Actual Warshall Algorithm
   public void allPairsReachability();
}

interface Floyd
{
   public int getCost(int from, int to);
   public int getCost(String from, String to);
   public void allPairsWeighted(); 
}

public class TJGraphAdjMat implements AdjacencyMatrix, Warshall, Floyd
{
   private int[][] grid = null;   //adjacency matrix representation
   private Map<String, Integer> vertices = null;   
     
   public TJGraphAdjMat(int num)
   {
      grid = new int[num][num];
      vertices = new TreeMap<String, Integer>();
   }
   
   public void addEdge(int source, int target)
   {
      grid[source][target] = 1;
   }
   
   public void removeEdge(int source, int target)
   {
      grid[source][target] = 0;
   }
   
   public boolean isEdge(int from, int to)
   {
      if(grid[from][to] > 0 && grid[from][to] < 9999)
         return true;
      return false;
   }
   
   public void displayGrid()
   {
      for(int n = 0; n<grid.length; n++)
      {
         for(int m = 0; m<grid[0].length; m++)
         {
            if(m != grid.length-1)
               System.out.print((grid[n][m] + "     ").substring(0, 5));
            else
               System.out.println(grid[n][m]);
         }
      }
   }
   
   public int edgeCount()
   {
      int count = 0;
      for(int n = 0; n<grid.length; n++)
      {
         for(int m = 0; m<grid[0].length; m++)
         {
            if(grid[n][m] == 1)  
               count++;
         }
      }
      return count; 
   }
   
   public List<Integer> getNeighbors(int source)
   {
      ArrayList<Integer> list = new ArrayList<Integer>();
      for(int c = 0; c<grid.length; c++)
      {
         if(grid[source][c] == 1)
            list.add(new Integer(c));
      }
      return list;
   } 
   
   ///////////////////////////////////////////////////WARSHALL
   public boolean isEdge(String from, String to)
   {
      return isEdge(vertices.get(from),vertices.get(to));
   }
   public Map<String, Integer> getVertices() 
   {
      return vertices;
   }    
   public void readNames(String fileName) throws FileNotFoundException 
   {
      vertices = new TreeMap<String, Integer>();
      Scanner scan = new Scanner(new File(fileName));
      int n = Integer.parseInt(scan.next());
      for(int k = 0; k<n; k++)
      {
         String city = scan.next();
         vertices.put(city, k);
      }      
   }
   public void readGrid(String fileName) throws FileNotFoundException
   {
      Scanner sc = new Scanner(new File(fileName));
      int n = Integer.parseInt(sc.next());
      grid = new int[n][n];
      for(int r = 0; r<n; r++)
      {
         for(int c = 0; c<n; c++)
         {
            grid[r][c] = Integer.parseInt(sc.next()); //check if its the right way
         }
      }
      
   }
   public void displayVertices()
   {
      Set<String> set = new TreeSet<String>();
      Map<Integer, String> map = new HashMap();
      int max = 0;
      for(String s : set)
      {
         if(vertices.get(s) > max)
            max = vertices.get(s);
         map.put(vertices.get(s), s);
      }
      for(int n = 0; n<max; n++)
      {
         System.out.println(n + " - " + map.get(n));
      }
   }
   //Actual Warshall Algorithm
   public void allPairsReachability()
   {
      for(int stop = 0; stop<grid.length; stop++)
      {
         for(int source = 0; source<grid.length; source++)
         {
            for(int destination = 0; destination<grid.length; destination++)
            {
               if(grid[source][stop] == 1 && grid[stop][destination] == 1)
                  grid[source][destination] = 1;
            }
         }
      }
   }
   
   //////////////////////////////FLOYD
   public int getCost(int from, int to)
   {
      return grid[from][to];
   }
   public int getCost(String from, String to)
   {
      return getCost(vertices.get(from),vertices.get(to));
   }
   public void allPairsWeighted()
   {
       for(int stop = 0; stop<grid.length; stop++)
      {
         for(int source = 0; source<grid.length; source++)
         {
            for(int destination = 0; destination<grid.length; destination++)
            {
               if(grid[source][stop] + grid[stop][destination] < grid[source][destination])
                  grid[source][destination] = grid[source][stop] + grid[stop][destination];            
            }
         }
      }

   } 
}