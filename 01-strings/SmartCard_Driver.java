 //name: Rayyan Khan    date: 9/8/16
 
import java.text.DecimalFormat;
public class SmartCard_Driver
{
   public static void main(String[] args) 
   {
      Station downtown = new Station("Downtown", 1);
      Station center = new Station("Center City", 1);
      Station uptown = new Station("Uptown", 2);
      Station suburbia = new Station("Suburb", 4);
     
      Smartcard jimmy = new Smartcard(2.00); //bought with $20.00 
      jimmy.board(center);            		    //boarded in zone 1
      jimmy.disembark(suburbia);					 //disembark in zone 4
      jimmy.disembark(uptown);					 //disembark without having boarded
      jimmy.addMoney(2.5);
      jimmy.printBoarded();
   	
   	//lots more test cases!				
   }
}


//Smartcard class
class Smartcard
{
   private double myMoney;
   int zone;
   Station n;
   boolean isBoarded;
   DecimalFormat d = new DecimalFormat("$0.00");
   
   public Smartcard()
   {
      myMoney = 20.00;
      isBoarded = false;
   }
     
   public Smartcard(double m)
   {
      myMoney = m;
      isBoarded = false;
   }
   
   public void addMoney(double amount)
   {
      if(isBoarded == true && myMoney<0)
      {
         myMoney+=amount;
         if(myMoney<0)
         {
            System.out.println("You have not added enough money to disembark. To disembark, add " + d.format(myMoney*-1+0.5) + " more.");
         }
         else
         {
            isBoarded = false;
            System.out.println("You now have enough money and have been disembarked.");
         }
      }
      else
      {
         myMoney+=amount;
      }
      
   }
   
   public double getBalance()
   {  
      return myMoney;
   }
   
   public void printBoarded() //for testing
   {
      if(isBoarded)
      {
         System.out.println("Boarded.");
      }
      
      else
      {
         System.out.println("Disembarked.");
      }
   }
   
   public void board(Station s)
   {
      if(isBoarded == true)
      {
         System.out.println("Sorry, but you have to disembark before boarding again.");
         System.exit(1);
      }
      else if(myMoney < 0.5)
      {
         System.out.println("Sorry, not enough money.");
      }
      else
      {
         isBoarded = true;
         zone = s.getZone();
         n = s;
         System.out.println("Boarded at " + s.getName() + ".");
      }
   }
   
   public double cost(Station s)
   {
      int newZone = s.getZone();
      int difference = newZone-zone;
      double cost;
      if(difference<1)
      {
         difference = difference*-1;
         cost=0.5+(difference*0.75);
      }
      else if(difference == 0)
      {
         cost=0.5;
      }
      else
      {
         cost=0.5+(difference*0.75);
      }
         
      return cost;
   }
   
   public void disembark(Station s)
   {
      if(isBoarded == false)
      {
         System.out.println("Sorry, you have to board to disembark.");
         System.exit(1);
      }
      else
      {
         myMoney-=cost(s);
         if(myMoney > 0)
         {  
            isBoarded = false;
            System.out.println("Got on at " + n.getName() + " and got off at " + s.getName() + ", and it cost " + d.format(cost(s)) + ". Remaining balance is " + d.format(myMoney) + ".");
         }
         else
         {
            double add = myMoney*-1 + 0.5;
            System.out.println("Sorry, you're out of money. Add " + d.format(add) + " dollars to disembark.");
         }
      }
   }
}
     
     
//Station class    
class Station
{
   private String name;
   private int zone;
   
   public Station(String n, int z)
   {
      name = n;
      zone = z;
   }
   public String getName()
   {
      return name;
   }
   public int getZone()
   {
      return zone;
   }
 
}

 
