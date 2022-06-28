import java.util.*;
public class NQueens {
	static int count=0;
	    public static boolean isSafe(char[][] mat, int r, int c)
	    {
	        for (int i = 0; i < r; i++)
	        {
	            if (mat[i][c] == 'Q') {
	                return false;
	            }
	        }
	 
	        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
	        {
	            if (mat[i][j] == 'Q') {
	                return false;
	            }
	        }
	 
	        for (int i = r, j = c; i >= 0 && j < mat.length; i--, j++)
	        {
	            if (mat[i][j] == 'Q') {
	                return false;
	            }
	        }
	 
	        return true;
	    }
	 
	    private static void printSolution(char[][] mat)
	    {
	        for (char[] chars: mat) {
	            System.out.println(Arrays.toString(chars).replaceAll(",", ""));
	        }
	        System.out.println();
	        
	        count++;
	    }
	 
	    private static void nQueen(char[][] mat, int r)
	    {
	        if (r == mat.length)
	        {
	            printSolution(mat);
	            return;
	        }
	        for (int i = 0; i < mat.length; i++)
	        {
	            if (isSafe(mat, r, i))
	            {
	                mat[r][i] = 'Q'; 
	                nQueen(mat, r + 1);
	                mat[r][i] = '–';
	            }
	        }
	    }
	 
	    public static void main(String[] args)
	    {
	        int N;
	        Scanner sc=new Scanner(System.in);
	        System.out.print("Enter number of Queens");	  
	        N=sc.nextInt();
	        char[][] mat = new char[N][N];
	        for (int i = 0; i < N; i++) {
	            Arrays.fill(mat[i], '–');
	        }
	 
	        nQueen(mat, 0);
	        System.out.println(count);
	    }
	}



/* 
Another program:-
import java.util.*;
class NQueens
{
	static List<List<Integer>> result = new ArrayList<List<Integer>>();
	static boolean[] cols,leftDiagonal,rightDiagonal;
	static List<List<Integer>> nQueen(int n) 
	{
		cols = new boolean[n];
		leftDiagonal = new boolean[2*n];
		rightDiagonal = new boolean[2*n];
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=0;i<n;i++)
			temp.add(0);
		solveNQUtil(result,n,0,temp);
		return result;
	}
	private static void solveNQUtil(List<List<Integer>> result,int n,int row,List<Integer> comb)
	{
		if(row==n){
			result.add(new ArrayList<>(comb));
			return;
		}
		for(int col = 0;col<n;col++)
		{
			if(cols[col] || leftDiagonal[row+col] || rightDiagonal[row-col+n])
				continue;
			cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = true;
			comb.set(col,row+1);
			solveNQUtil(result,n,row+1,comb);
			cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = false;
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n : ");
		int n = sc.nextInt();
		List<List<Integer>> res = nQueen(n);
		int s = res.size();
		System.out.println(s);
		System.out.println(res);
	}
}

/*OUTPUT
Enter n : 4
2
[[3, 1, 4, 2], [2, 4, 1, 3]]
*/
