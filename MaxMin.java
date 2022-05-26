import java.util.*;
public class MaxMin 
{
	static class Pair 
	{
        int min;
        int max;
	}
	
    static Pair getMinMax2(int arr[], int low, int high) 
    {
        Pair minmax = new Pair();
        Pair mml = new Pair();
        Pair mmr = new Pair();
        int mid;
        if (low == high) 
        {
            minmax.max = arr[low];
            minmax.min = arr[low];
            return minmax;
        }
        if (high == low + 1) 
        {
            if (arr[low] > arr[high]) 
            {
                minmax.max = arr[low];
                minmax.min = arr[high];
            } 
            else 
            {
                minmax.max = arr[high];
                minmax.min = arr[low];
            }
            return minmax;
        }
        mid = (low + high) / 2;
        mml = getMinMax2(arr, low, mid);
        mmr = getMinMax2(arr, mid + 1, high);
        if (mml.min < mmr.min)
            minmax.min = mml.min;
        else 
            minmax.min = mmr.min;
        if (mml.max > mmr.max) 
            minmax.max = mml.max;
        else 
            minmax.max = mmr.max;
        return minmax;
    }
 
    static Pair getMinMax1(int a[],int n)
    {
    	Pair minmax=new Pair();
    	minmax.min=a[0];
    	minmax.max=a[0];
    	for (int i = 2; i <=n; i++) 
    	{
            if (a[i] > minmax.max)
                minmax.max = a[i];
            else if (a[i] < minmax.min)
                minmax.min = a[i];
        }
        return minmax;
    }
    
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of elements: ");
		int n=sc.nextInt();
		int a[]=new int [n];
		System.out.println("Enter the elements into the array: ");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		Arrays.sort(a);
		System.out.println("The elements in the array are: ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		int ch;
        long start = System.nanoTime();
        System.out.println("\nInitial time is "+start+" nanoseconds");
        if(n==1||n==2)
        {
           if(n==1)
           {
              System.out.println("Max element: "+a[0]);
              System.out.println("Min element: "+a[0]);
           }
           else
           {
              if(a[0]>a[1])
              {
                  System.out.println("Max element: "+a[0]);
                  System.out.println("Min element: "+a[1]);
              }
              else
              {
                  System.out.println("Max element: "+a[1]);
                  System.out.println("Min element: "+a[0]);
              }
           }
           long end=System.nanoTime();
           System.out.println("Time complexity is "+(end-start)+" nanoseconds");
        }
        else
        {   
         do 
         {
          System.out.println("1.Iteration 2.Recursion");
          System.out.println("Enter yout option: ");
          ch=sc.nextInt();
           switch(ch)
           {
              case 1: Pair maxmin=getMinMax1(a,a.length-1);
                      System.out.println("Max element: "+maxmin.max);
                      System.out.println("Min element: "+maxmin.min);
                      long end=System.nanoTime();
                      System.out.println("Time complexity is "+(end-start)+" nanoseconds");
                      break;
              case 2: Pair minax=getMinMax2(a, 0, a.length - 1);
                      System.out.println("Max Element is: "+minax.max);
        	          System.out.println("Min element is: "+minax.min);
        	          long end1=System.nanoTime();
        	          System.out.println("Time complexity is "+(end1-start)+" nanoseconds");
                      break;
              default:break;
           }
	     }while(ch<3);
	    }   
        sc.close();
    }
}