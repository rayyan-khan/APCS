// Name:Rayyan Khan Date:10/11/16

public class MatrixRecreate
{
   public static void main(String[] args)
   {
      int[][] matrix = TheMatrix.create();
      int[] rowcount = new int[matrix.length];
      int[] colcount = new int[matrix[0].length];
      TheMatrix.count(matrix, rowcount, colcount);
      System.out.println("Original Matrix");
      TheMatrix.display(matrix, rowcount, colcount);
      TheMatrix.re_create(rowcount, colcount);
      System.out.println("Recreated Matrix");
      TheMatrix.display(TheMatrix.getRecreatedMatrix(), rowcount, colcount);
   }
}
class TheMatrix
{
	//do not instantiate recreatedMatrix yet. Only instantiate and set that in recur.
   private static int[][] recreatedMatrix; 
   public static int[][] getRecreatedMatrix()
   {
      return recreatedMatrix;
   }
   public static int[][] create()
   {
       int row = 2 + (int)(Math.random()*4);
       int col = 2 + (int)(Math.random()*4);
       
       int[][] matrix = new int[row][col];
       
       for(int r = 0; r<row; r++)
       {
         for(int c = 0; c<col; c++)
         {
            int num = (int)(Math.random()*10);
            if(num>5)
               matrix[r][c] = 1;
            else
               matrix[r][c] = 0;
         }
       }
       return matrix;
   }
   public static void count(int[][] matrix, int[] rowcount, int[] colcount)
   {
      for(int r = 0; r<rowcount.length; r++)
      {
         int ones = 0;
         for(int c = 0; c<matrix[0].length; c++)
         {
            if(matrix[r][c] == 1)
            {
               ones++;
            }
         }
         rowcount[r] = ones;                     //rowcount
      }
      
      for(int c = 0; c<matrix[0].length; c++)
      {
         int ones = 0;
         for(int r = 0; r<matrix.length; r++)
         {
            if(matrix[r][c] == 1)
            {
               ones++;
            }
         }
         colcount[c] = ones;                     //colcount
      }
   }
   public static void display(int[][] matrix, int[] rowcount, int[] colcount)
   {
      System.out.print("  ");
      for(int a = 0; a<rowcount.length; a++) //top row of colcounts
      {
         if(a==(rowcount.length-1))
            System.out.println(rowcount[a]);
         else
            System.out.print(rowcount[a]);
      }
      for(int d = 0; d<matrix.length+2; d++)
      {
         if(d==matrix.length+1)
            System.out.println("-");
         else
            System.out.print("-");
      }
      for(int b = 0; b<matrix[0].length; b++)
      {
         for(int c = 0; c<matrix.length; c++)
         {
            if(c==0)
               System.out.print(colcount[b] + "|" + matrix[c][b]);
            else if(c==matrix.length-1)
               System.out.println(matrix[c][b]);
            else 
               System.out.print(matrix[c][b]);
         }
      }
   }
	//should call recur.
   public static void re_create(int[] rowcount, int[] colcount)
   {
      recreatedMatrix = new int[rowcount.length][colcount.length];
      int[] r = new int[rowcount.length];
      int[] c = new int[colcount.length];
      
      for(int a = 0; a<rowcount.length; a++)
      {
         r[a]=rowcount[a];
      }
      for(int b = 0; b<colcount.length; b++)
      {
         c[b] = colcount[b];
      }
      
      count(recreatedMatrix, r, c);
      
      for(int d = 0; d<rowcount.length; d++)
      {
         if(rowcount[d] == r[d]);
         {
            for(int e = 0; e<colcount.length; e++)
            {
               if(colcount[e] == c[e])
               {
                  break;
               }
               else
               {
                  recur(recreatedMatrix, rowcount, colcount, d, e);
               }
            }
         }
      }
   }
   private static void recur(int[][] m, int[] rowcount, int[] colcount, int row, int col)
   {
      if(compare(m, rowcount, colcount))    //base case: if new matrix works, then copy over to recreatedMatrix
      {
      	//copy over from m to recreatedMatrix (not just references)
         recreatedMatrix = new int[m.length][];
         for(int i = 0; i < m.length; i++)
         {
            recreatedMatrix[i] = new int[m[i].length];
            for (int j = 0; j < m[i].length; j++)
            {
               recreatedMatrix[i][j] = m[i][j];
            }
         }    //we're done!
         
      }
     	if(row < m.length)
      {
          if(col < m[0].length)
          {
            m[row][col]=1;
            recur(m, rowcount, colcount, row, col+1);
            m[row][col] = 0;
            recur(m, rowcount, colcount, row, col+1);
          }
          else
            recur(m, rowcount, colcount, row+1, 0);
      }           
     
   }
   private static boolean compare(int[][] m, int[] rowcount, int[] colcount)
   {
      int[] a = new int[m[0].length];
      int[] b = new int[m.length];
      count(m, b, a);
      boolean bl = true;
      
      if(rowcount.length == b.length)
      {
         for(int d = 0; d<rowcount.length; d++)
         {
            if(b[d] != rowcount[d])
               bl = false;
         }
      }
      else
      {
         bl = false;
      }
      
      if(colcount.length == a.length)
      {
         for(int e = 0; e<colcount.length; e++)
         {
            if(a[e] != colcount[e])
               bl = false;
         }
      }
      else
      {
         bl = false;
      }
     return bl;
   }
}
