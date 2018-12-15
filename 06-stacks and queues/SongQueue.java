///name:    date:
//first program on queues.
import java.io.*;
import java.util.*;
public class SongQueue
{
   private static Scanner infile;
   private static Queue<String> songQueue;
   
   public static void main(String[] args) throws Exception
   {
      fillPlayList();
      printSongList();
      infile = new Scanner(System.in);
      String prompt = "\tAdd song (A), Play song (P), Delete song (D), Quit (Q):  ";
      System.out.print(prompt);
      String str = infile.next().toUpperCase();
      while(!str.equals("Q"))
      { 
         processRequest( str );
         System.out.print(prompt);
         str = infile.next().toUpperCase();;
      } 
      System.out.println();
      System.out.println("No more music for you today.  Goodbye!");
      infile.close();
   }
   public static void fillPlayList()throws IOException
   {
      songQueue = new LinkedList<String>();
      Scanner sc = new Scanner(new File("songs.txt"));
      
      while(sc.hasNext())
      {
         songQueue.add(sc.nextLine());
      }
   }
   public static void processRequest(String str)
   {
      if(str.equalsIgnoreCase("A"))
      {
         add();         
      }
      else if(str.equalsIgnoreCase("P"))
      {
         play();
      }
      else if(str.equalsIgnoreCase("D"))
      {
         delete();
      }
      else
      {
         String prompt = "\tAdd song (A), Play song (P), Delete song (D), Quit (Q):  ";
         System.out.print("Not a valid command." + prompt);
      }      
   }
   public static void add() //ADD A SONG
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Song to add?");
      String s = sc.nextLine();
      songQueue.add(s);
      printSongList();
   }
   public static void play() //PRINT CURRENT SONG
   {
      String song = songQueue.poll();
      System.out.println("Now playing: " + song); 
      printSongList();  
    }
   public static void delete() //DELETE A SONG
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Song to delete (exact match): ");
      String cfius = sc.next();
      
      Queue<String> q = new LinkedList();
      
      while(songQueue.peek() != null)
      {
         String s = songQueue.poll();
         q.add(s);
      }
            
      while(q.peek() != null)
      {
         String str = q.poll();
         if(!str.equals(cfius))
            songQueue.add(str);
      }
      printSongList();
   }
   public static void printSongList() ///PRINT SONGS
   {
      Queue<String> temp = new LinkedList<String>();
      System.out.print("Your music queue: [");
      String queue = "";
      while(songQueue.peek() != null)
      {
         String s = songQueue.poll();
         temp.add(s);
         queue += s + ", ";
      }
      queue = queue.substring(0, queue.length()-2);
      System.out.println(queue + "]");
      
      while(temp.peek()!=null)
      {
         songQueue.add(temp.poll());
      }
   }
}