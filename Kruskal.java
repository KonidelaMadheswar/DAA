import java.util.*;
public class Kruskal {
		// TODO Auto-generated method stub
		int parent[] = new int[10];
		int find(int m)
		{
			int p = m;
			while(parent[p]!=0)
				p = parent[p];
			return p;
		}
		void union(int i,int j)
		{
			if(i<j)
				parent[i] = j;
			else
				parent[j] = i;
		}
	    void krkl(int[][]a,int n)
		{
			int u=0,v=0,min,k=0,i,j,sum=0;
			while(k<n-1)
			{
				min = 99;
				for(i=1;i<=n;i++)
				{
					for(j=1;j<=n;j++)
					{
						if(a[i][j]<min && i!=j)
						{
							min = a[i][j];
							u=i;
							v=j;
						}
					}
				}
						i = find(u);
						j = find(v);
						if(i!=j)
						{
							union(i,j);
							System.out.println("("+u+","+v+")"+"="+a[u][v]);
							sum = sum + a[u][v];
							k++;
						}
						a[u][v]=a[v][u]=99;
			}
					System.out.println("The cost of minimum spanning tree: "+sum);
		}
		public static void main(String[] args)
		{
			int a[][] = new int[10][10];
			int i,j;
			System.out.println("Enter number of vertices: ");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			System.out.println("Enter weighted matrix: ");
			for(i=1;i<=n;i++)
				for(j=1;j<=n;j++)
					a[i][j] = sc.nextInt();
			Kruskal k = new Kruskal();
			k.krkl(a,n);
			sc.close();
		}

}

/*
output:-
-------
Enter no of vertices : 4
Enter the Cost matrix :
0 3 4 10
3 0 20 5
4 20 0 6
10 5 6 0
1 - 2 -> 3
1 - 3 -> 4
2 - 4 -> 5
Cost of the spanning Tree = 12
*/
