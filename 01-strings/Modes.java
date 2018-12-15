	//Name: Rayyan Khan  
	//Date: 9/6/16
   
   //done
   
    public class Modes
   {
       public static void main(String[] args)
      {
         int[] tally = {0,0,10,5,10,0,7,1,0,6,0,10,3,0,0,1};
         display(tally);
         int[] modes = calculateModes(tally);
         display(modes);
         int sum = 0;
         for(int k = 0; k < tally.length; k++)
            sum += tally[k];
         System.out.println("kth \tindex"); 
         for(int k = 1; k <= sum; k++)
            System.out.println(k + "\t\t" + kthDataValue(tally, k));
      }
       public static int[] calculateModes(int[] tally)
      {
      	int m = findMax(tally);
			int n = 0;
			
			for(int k = 0; k<tally.length; k++)
			{
				if(tally[k] == m)
				{
					n++;
			   }
			}
			
			int[] modes = new int[n];
			int r = 0;
			
			for(int k = 0; k<tally.length; k++)
			{  	
				if(tally[k] == m)
				{
					modes[r] = k;
					r++;
			   }
			}
				
         return modes;
      }
       public static int kthDataValue(int[] tally, int k)
      {
			int n = 0;
			int i = 0;
      	while(n < k)
			{
				n+= tally[i];
				i++;
			}
         return i-1;
      }
       public static int findMax(int[] nums)
      {
         int pos = 0;
         for(int k = 1; k < nums.length; k++)
            if(nums[k] > nums[pos])
               pos = k;
         return nums[pos];
      }
       public static void display(int[] args)
      {
         for(int k = 0; k < args.length; k++)
            System.out.print(args[k] + " ");
         System.out.println();
         System.out.println();
      }
   }

