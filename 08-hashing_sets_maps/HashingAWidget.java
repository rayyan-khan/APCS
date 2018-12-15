//Name:                Date:
   import java.util.*;
   public class HashingAWidget
   {
      public static void main(String[] args)
      {
         Set<Widget> tSet = new TreeSet<Widget>();
         Set<Widget> hSet = new HashSet<Widget>();
      	
         Widget a = new Widget(2,3);   //same or different?
         Widget b = new Widget(2,3);
         Widget c = new Widget(2,3);
        // c = b;
         
         tSet.add(a); 
         tSet.add(b);
         tSet.add(c);
       
         hSet.add(a); 
         hSet.add(b);
         hSet.add(c); 
         
         System.out.println(a.hashCode()+ " "+b.hashCode() + " " + c.hashCode());
         
         System.out.println("TreeSet:  " + tSet);
         System.out.println("HashSet:  " + hSet);
      }
   }

	/*************************************** 
	Modify the Widget class so that it hashes on its
	values, not on its address.  Be sure that compareTo(),
	equals(Object) and hashCode() agree with each other.
	****************************************/

   class Widget implements Comparable<Widget>
   {
      private int myPounds, myOunces;
      public Widget()
      {
         myPounds = myOunces = 0;
      }
      public Widget(int x)
      {
         myPounds = x;
         myOunces = 0;
      }
      public Widget(int x, int y)
      {
         myPounds = x;
         myOunces = y;
      }
      public Widget(Widget arg)
      {
         myPounds = arg.getPounds();
         myOunces = arg.getOunces();
      }
      public int getPounds()
      {
         return myPounds;
      }
      public int getOunces()
      {
         return myOunces;
      }
      public void setPounds(int x)
      {
         myPounds = x;
      }
      public void setOunces(int x)
      {
         myOunces = x;
      }
      
      //////////////////////////////
   	public int compareTo(Widget w)
      {
         if(myPounds < w.getPounds())
            return -1;
         else if (myPounds > w.getPounds())
            return 1;
         else
         {
            if(myOunces < w.getOunces())
               return -1;
            else if(myOunces > w.getOunces())
               return 1;
            else
               return 0;
         }
            
      }
      
      ///////////////////////////////// 
   	public boolean equals(Widget arg)  
      {
         if(this.compareTo(arg) == 0)
            return true;
         else 
            return false;
      }
      
      ////////////////////////
   	public String toString()
      {
         return myPounds + " lbs. " + myOunces + " oz.";
      }
      
      /////////////////////////////////
   	public boolean equals(Object arg)
      {
         if(this.toString().equals(arg.toString()))
            return true;
         else
            return false;
      }
      
      //////////////////////
      public int hashCode()
      {
         return this.toString().hashCode();
      }
   }