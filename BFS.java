import java.io.*;
import java.util.*;
class BFS
{
    private int V;  
    private LinkedList<Integer> adj[];
    BFS(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
    void BFS(int s)
    {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            s = queue.poll();
            System.out.print(s+" ");
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of edges: ");
        int n = sc.nextInt();
        System.out.println("Enter edges: ");
        BFS g = new BFS(n);
        for(int i=1;i<=n;i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            g.addEdge(x,y);
        }
        System.out.println("Enter source vertex : ");
        int z = sc.nextInt();
        System.out.println("Following is Breadth First Traversal ");
        g.BFS(z);
    }
}
