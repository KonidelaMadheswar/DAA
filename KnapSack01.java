import java.util.*;
class KnapSack01 
{
    static int max(int a, int b)
    {
          return (a > b) ? a : b;
    }
    static int knapSack(int W, int wt[],int val[], int n)
    {
        int i, j;
        int K[][] = new int[n + 1][W + 1];
        for (i = 0; i <= n; i++)
        {
            for (j = 0; j <= W; j++)
            {
                if (i == 0 || j == 0)
                    K[i][j] = 0;
                else if (wt[i - 1] <= j)
                    K[i][j]= max(val[i - 1]+ K[i - 1][j - wt[i - 1]],K[i - 1][j]);
                else
                    K[i][j] = K[i - 1][j];
            }
        }
        return K[n][W];
    }
    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
    	int n;
    	System.out.println("Enter number of times: ");
    	n = sc.nextInt();
    	System.out.println("Enter item values: ");
        int val[] = new int[n];
        for(int i=0;i<n;i++)
       		val[i] = sc.nextInt();
        System.out.println("Enter item weights: ");
        int wt[] = new int[n];
        for(int i=0;i<n;i++)
        	wt[i] = sc.nextInt();
        System.out.println("Enter maximum capacity: ");
        int W = sc.nextInt();
        //int x = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}