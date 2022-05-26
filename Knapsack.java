import java.util.*;
public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ob,m;
		System.out.println("Enter number of objects: ");
		ob = sc.nextInt();
		int w[]  = new int[ob];
		int p[]  = new int[ob];
		for(int i=0;i<ob;i++)
		{
			System.out.println("Enter the profit: ");
			p[i] = sc.nextInt();
			System.out.println("Enter the weight: ");
			w[i]  = sc.nextInt();
		}
		System.out.println("Enter the knapsack capacity: ");
		m = sc.nextInt();
		double pw[]  = new double[ob];
		double s = System.nanoTime();
		for(int i=0;i<ob;i++)
			pw[i] = (double)p[i]/(double)w[i];
		for(int i=0;i<ob;i++)
		{
			for(int j=i+1;j<ob;j++)
			{
				if(pw[i]<pw[j])
				{
					double temp = pw[j];
					pw[j] = pw[i];
					pw[i] = temp;
					int temp1 = p[j];
					p[j] = p[i];
					p[i] = temp1;
					int temp2 = w[j];
					w[j] = w[i];
					w[i] = temp2;
				}
			}
		}
		double e = System.nanoTime();
		System.out.println("After solving");
		System.out.print("Objects: ");
		for(int i =0;i<ob;i++)
			System.out.print(i+" ");
		System.out.println();
		System.out.print("Profit: ");
		for(int i=0;i<ob;i++)
			System.out.print(p[i]+" ");
		System.out.println();
		System.out.print("Weight: ");
		for(int i=0;i<ob;i++)
			System.out.print(w[i]+" ");
		System.out.println();
		System.out.print("p/w ratio: ");
		for(int i=0;i<ob;i++)
			System.out.print(pw[i]+" ");
		System.out.println();
		int k =0;
		double sum =0;
		double s1 = System.nanoTime();
		while(m>0)
		{
			if(w[k]<m)
			{
				sum+=1*p[k];
				m = m-w[k];
			}
			else
			{
				double x4 = m*p[k];
				double x5 = w[k];
				double x6 = x4/x5;
				sum = sum+x6;
				m = 0;
			}
			k++;
		}
		double e1 = System.nanoTime();
		System.out.println("Final profit: "+sum);
		System.out.println("Time complexity is: "+((e-s)+(e1-s1)));
	}

}
