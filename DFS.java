import java.io.*;
import java.util.*;
class DFS {
    private int V;
    private LinkedList<Integer> adj[];
    @SuppressWarnings("unchecked") DFS(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int v, int w)
    {
        adj[v].add(w);
    }
    void DFSUtil(int v, boolean visited[])
    {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
    void DFS(int v)
    {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nuber of edges: ");
        int n  = sc.nextInt();
        DFS g = new DFS(n);
        System.out.println("Enter the edges: ");
        for(int i=0;i<n;i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            g.addEdge(x,y);
        }
        System.out.println("Enter source vertex: ");
        int z = sc.nextInt();
        System.out.println("Following is Depth First Traversal ");
        g.DFS(z);
    }
}