public class Test
{
public static void main(String[] args)
{
   String s = "Twinkle, twinkle, little star!";
   System.out.print(removePunctuation(s));
}
public static String removePunctuation( String s )
{
   String ionic = "";
   for(int n = 0; n<s.length(); n++)
   {
      String covalent = "" + s.charAt(n);
      if(isPunctuation(covalent) == false)
         ionic+= covalent;
   }
   return ionic; 
}
public static boolean isPunctuation(String s)
   {
      boolean b = false;
      if(!(s.equalsIgnoreCase("a") || s.equalsIgnoreCase("b") || s.equalsIgnoreCase("c") || s.equalsIgnoreCase("d") || s.equalsIgnoreCase("e") || s.equalsIgnoreCase("f") || s.equalsIgnoreCase("g") || s.equalsIgnoreCase("h") || s.equalsIgnoreCase("i") || s.equalsIgnoreCase("j") || s.equalsIgnoreCase("k") || s.equalsIgnoreCase("l") || s.equalsIgnoreCase("m") || s.equalsIgnoreCase("n") || s.equalsIgnoreCase("o") || s.equalsIgnoreCase("p") || s.equalsIgnoreCase("q") || s.equalsIgnoreCase("r") || s.equalsIgnoreCase("s") || s.equalsIgnoreCase("t") || s.equalsIgnoreCase("u") || s.equalsIgnoreCase("v") || s.equalsIgnoreCase("w") || s.equalsIgnoreCase("x") || s.equalsIgnoreCase("y") || s.equalsIgnoreCase("z") || s.equalsIgnoreCase(" ") || s.equals("\"")))
         b = true;
      return b;
   }
}