   //Name:     Date:
import java.io.*;
import java.util.*;
public class Dictionary
{
   public static void main(String[] args) 
   {
      
      Scanner infile = null;
      try
      {
         infile = new Scanner(new File("spanglish.txt"));
         System.setOut(new PrintStream(new FileOutputStream("dictionaryOutput.txt")));
      }
      catch(Exception e)
      {
         
      }
      
      Map<String, Set<String>> eng2spn = makeDictionary( infile );
      System.out.println("ENGLISH TO SPANISH");
      display(eng2spn);
      
      System.out.println(" \n");
   
      Map<String, Set<String>> spn2eng = reverse(eng2spn);
      System.out.println("SPANISH TO ENGLISH");
      display(spn2eng);
   }
   public static Map<String, Set<String>> makeDictionary(Scanner infile)
   {
      Map<String, Set<String>> eng2spn = new HashMap<String, Set<String>>();
      while(infile.hasNext())
      {
         String english = infile.next();
         String spanish = infile.next();
         add(eng2spn, english, spanish);
      }
      return eng2spn;
   }
   private static void add(Map<String, Set<String>> dictionary, String word, String translation)
   { 
      Set<String> ts = dictionary.get(word);
      
      if(ts == null)
         {
            ts = new TreeSet<String>();
            ts.add(translation);
            dictionary.put(word, ts);
         }
         else
         {
            ts.add(translation);
         }
   }
   public static void display(Map<String, Set<String>> m)
   {
      Set<String> ms = m.keySet();
      TreeSet<String> ts = new TreeSet<String>(ms);
      
      for(String s: ts)
      {
         System.out.println(s + " " + m.get(s));
      }
   }
   public static Map<String, Set<String>> reverse(Map<String, Set<String>> dictionary)
   {
      Map<String, Set<String>> spn2eng = new HashMap<String, Set<String>>();
      Set<String> ms = dictionary.keySet();
      
      for(String english: ms)
      {
         Set<String> spanishWords = dictionary.get(english);
         for(String spanish: spanishWords)
         {
            add(spn2eng, spanish, english);
         }
      }
      return spn2eng;
   }
}
      /********************
	INPUT:
   	holiday
		fiesta
		holiday
		vacaciones
		party
		fiesta
		celebration
		fiesta
     <etc.>
  *********************************** 
	OUTPUT:
		ENGLISH TO SPANISH
			banana [banana]
			celebration [fiesta]
			computer [computadora, ordenador]
			double [doblar, doble, duplicar]
			father [padre]
			feast [fiesta]
			good [bueno]
			hand [mano]
			hello [hola]
			holiday [fiesta, vacaciones]
			party [fiesta]
			plaza [plaza]
			priest [padre]
			program [programa, programar]
			sleep [dormir]
			son [hijo]
			sun [sol]
			vacation [vacaciones]

		SPANISH TO ENGLISH
			banana [banana]
			bueno [good]
			computadora [computer]
			doblar [double]
			doble [double]
			dormir [sleep]
			duplicar [double]
			fiesta [celebration, feast, holiday, party]
			hijo [son]
			hola [hello]
			mano [hand]
			ordenador [computer]
			padre [father, priest]
			plaza [plaza]
			programa [program]
			programar [program]
			sol [sun]
			vacaciones [holiday, vacation]

**********************/