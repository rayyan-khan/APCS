//name:    date:
//resource classes and interfaces
//for use with Graphs3: EdgeList
//             Graphs4: DFS-BFS
//             Graphs5: EdgeListCities

import java.io.*;
import java.util.*;
/*********************  Graphs 3:  EdgeList *******************************/
interface VertexInterface
{
   public String toString();     //just return the name
   public String getName();
   public ArrayList<Vertex> getAdjacencies();
   public void addEdge(Vertex v);
}  

interface TJGraphAdjListInterface 
{ 
   public List<Vertex> getVertices();
   public Vertex getVertex(int i) ;
   public Vertex getVertex(String vertexName);
   public Map<String, Integer> getVertexMap();
   public void addVertex(String v);
   public void addEdge(String source, String target);
   public String toString();
  
}

  
   /*********************Graphs 4:  DFS and BFS ****************************/
interface DFSAndBFS
{
   public List<Vertex> depthFirstSearch(String name);
   public  List<Vertex> breadthFirstSearch(String name);
//    public  List<Vertex> depthFirstRecur(String name);
}

   /****************Graphs 5:  EdgeList with Cities  *********/
interface EdgeListWithCities
{
   public void graphFromEdgeListData(String fileName) throws FileNotFoundException;
   public int edgeCount();
   public boolean isReachable(String source, String target);
   public boolean isConnected();
}
/***********************************************************/
class Vertex implements VertexInterface 
{
   private final String name;
   private ArrayList<Vertex> adjacencies;
  
   public Vertex(String n)
   {
      name = n;
      adjacencies = new ArrayList<Vertex>();
   }
   public String toString()
   {
      return name;
   }
   
   public String getName()
   {
      return name;
   }
   
   public ArrayList<Vertex> getAdjacencies()
   {
      return adjacencies;
   }
   
   public void addEdge(Vertex v)
   {
      adjacencies.add(v);
   }
  
}  
/*******************************************************/
public class TJGraphAdjList implements TJGraphAdjListInterface, DFSAndBFS //, EdgeListWithCities
{
   private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
   private Map<String, Integer> nameToIndex = new HashMap<String, Integer>();
  
   public List<Vertex> getVertices()
   {
      return vertices;
   }
   public Vertex getVertex(int i) 
   {
      return vertices.get(i);
   }
   public Vertex getVertex(String vertexName)
   {
      for(Vertex v : vertices)
      {
         if(v.getName().equals(vertexName))
            return v;
      }
      return vertices.get(0);
   }
   public Map<String, Integer> getVertexMap()
   {
      return nameToIndex;
   }
   public void addVertex(String v)
   {
      if(nameToIndex.get(v) == null)
      {
         vertices.add(new Vertex(v));
         nameToIndex.put(v, vertices.size()-1);
      }
   }
   public void addEdge(String source, String target)
   {
      if(nameToIndex.get(source) == null)
      {
         addVertex(source);
      }
      if(nameToIndex.get(target) == null)
      {
         addVertex(target);
      }
      Vertex s = vertices.get(nameToIndex.get(source));
      Vertex t = vertices.get(nameToIndex.get(target));
      
      s.addEdge(t);
   }
   public String toString()
   {
      String s = "";
      for(int n = 0; n<vertices.size(); n++)
      {
         ArrayList<Vertex> adj = vertices.get(n).getAdjacencies();
         s += vertices.get(n) + " ";
         s +=adj.toString();
         s += "\n";
      }
      return s;
   }

  ///////////////////////////////////////////////////////////////////////DFS BFS
   public List<Vertex> depthFirstSearch(String name)
   {
      Stack<Vertex> stack = new Stack<Vertex>();
      ArrayList<Vertex> array = new ArrayList<Vertex>();
      //nameToIndex = map
      //vertices = arraylist
      int index = nameToIndex.get(name);
      Vertex start = vertices.get(index);
      stack.push(start);
      do{ 
         Vertex vpop = stack.pop();
         if(!array.contains(vpop))
         {
            array.add(vpop); 
            ArrayList<Vertex> edges = vpop.getAdjacencies();
            for(Vertex v : edges)
            {
               stack.push(v);
            }  
         }
      }while(!stack.empty());
   
      return array;  
   }
   public  List<Vertex> breadthFirstSearch(String name)
   {
      Queue<Vertex> queue = new LinkedList<Vertex>();
      ArrayList<Vertex> array = new ArrayList<Vertex>();
      int index = nameToIndex.get(name);
      Vertex start = vertices.get(index);
      queue.add(start);
      do{ 
         Vertex vpoll = queue.poll();
         if(!array.contains(vpoll))
         {
            array.add(vpoll); 
            ArrayList<Vertex> edges = vpoll.getAdjacencies();
            for(Vertex v : edges)
            {
               queue.add(v);
            }  
         }
      }while(queue.peek() != null);
   
      return array;  

   }
   
   ///////////////////////////////////////////////////////////////////Edgelist Cities
   public void graphFromEdgeListData(String fileName) throws FileNotFoundException
   {
      Scanner sc = new Scanner(new File(fileName));
      while(sc.hasNext())
      {
         String a = sc.next();
         String b = sc.next();
         addEdge(a, b);
      }
   }
   public int edgeCount()
   {
      int sum = 0;
      for(Vertex v : vertices)
      {
         ArrayList<Vertex> array = v.getAdjacencies();
         sum += array.size();
      }
      return sum;
   }
   public boolean isReachable(String source, String target)
   {
      boolean reachable = false;
      List<Vertex> array = depthFirstSearch(source);
      for(Vertex v : array)
      {
         if(v.getName().equals(target))
            reachable = true;
      }
      return reachable;
   }
   public boolean isConnected()
   {
      boolean connected = true;
      for(Vertex v : vertices)
      {
         for(Vertex k : vertices)
         {
            if(!isReachable(v.getName(), k.getName()))
               connected = false;
         }
      }
      return connected;
   }
     
}


