//name:   date: 
//for use with Graphs6: Dijkstra
//             Graphs7: Dijkstra with Cities

import java.io.*;
import java.util.*;

class Edge {
   public final wVertex target;
   public final double weight;
   
   public Edge(wVertex argTarget, double argWeight) {
      target = argTarget;
      weight = argWeight;
   }
}

class wVertex implements Comparable<wVertex>, wVertexInterface
{
   private double minDistance = Double.POSITIVE_INFINITY;
 
    /*  enter your code here   */ 
   private final String name;
   private ArrayList<Edge> adjacencies;
     
   public wVertex(String n)
   {
      name = n;
      adjacencies = new ArrayList<Edge>();
   }
   public String toString()
   {
      return name;
   }
      
   public String getName()
   {
      return name;
   }
   
   public double getMinDistance()
   {  
      return minDistance;
   }
      
   public void setMinDistance(double m)
   {
      minDistance = m;
   }
      
   public ArrayList<Edge> getAdjacencies()
   {
      return adjacencies;
   }
      
   public int compareTo(wVertex other)
   {
      return (int)(minDistance - other.getMinDistance());
   }
      ///////////////////////////////////////////////not in interface
   public void addEdge(Edge e)
   {
      adjacencies.add(e);
   }
}

interface wVertexInterface 
{
   public String toString();
   
   public String getName();
   
   public double getMinDistance();
   
   public void setMinDistance(double m);
   
   public ArrayList<Edge> getAdjacencies();
   
   public int compareTo(wVertex other);
}


public class TJGraphAdjListWeighted implements TJGraphAdjListWeightedInterface
{
   private ArrayList<wVertex> vertices = new ArrayList<wVertex>();
   private Map<String, Integer> nameToIndex = new HashMap<String, Integer>();
  
   /*  enter your code here   */ 
   public List<wVertex> getVertices()
   {
      return vertices;
   }
   
   public wVertex getVertex(int i)
   {
      return vertices.get(i);
   }
   
   public wVertex getVertex(String vertexName)
   {
      return vertices.get(nameToIndex.get(vertexName));
   }
   
   public void addVertex(String s)
   {
      wVertex wv = new wVertex(s);
      vertices.add(wv);
      nameToIndex.put(s, vertices.size()-1);
   }
   
   public void addEdge(String source, String target, double weight)
   {
      Edge e = new Edge(getVertex(target), weight);
      wVertex v = getVertex(source);
      v.addEdge(e);
   }
     
   public void minimumWeightPath(String vertexName)   //Dijkstra's
   {
      PriorityQueue<wVertex> pq = new PriorityQueue<wVertex>();
      wVertex start = getVertex(vertexName);
      start.setMinDistance(0);
      
      pq.add(start);
      while(pq.peek() != null) 
      {
      //         remove most recent node
         wVertex v = pq.poll();
          
      //          looop over edges
         ArrayList<Edge> edges = v.getAdjacencies();
         for(Edge e : edges)
         {
            double newDistance = v.getMinDistance() + e.weight;
            if(newDistance < e.target.getMinDistance())
            {
                  //  check if weight has improved
               e.target.setMinDistance(newDistance);
                  //  add all its edges that have improved into pq
               pq.add(e.target);
            }
         }         
      }
      
   }
}    
interface TJGraphAdjListWeightedInterface 
{
   public List<wVertex> getVertices();
   
   public wVertex getVertex(int i);
   
   public wVertex getVertex(String vertexName);
   
   public void addVertex(String v);
   
   public void addEdge(String source, String target, double weight);
     
   public void minimumWeightPath(String vertexName);   //Dijkstra's

   /*  Graphs 7 */
       
//  public List<wVertex> getShortestPathTo(wVertex v);
    
//  public TJGraphAdjListWeighted graphFromEdgeListData(File vertexNames, File edgeListData) throws FileNotFoundException 
 
}