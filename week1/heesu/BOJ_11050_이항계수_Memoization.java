import java.util.*;
import java.io.*;

public class BOJ_11050_이항계수_Memoization{
	static int n,k;
	static StringTokenizer st;
	static int MAX_N = 10;
	static int memo[][] = new int[MAX_N+1][MAX_N+1];
	static int solve(int i, int j) {
		if(memo[i][j] != -1)
			return memo[i][j];
		
		if(j == 0 || j == i) {
			return memo[i][j] = 1;
		}
			
		
		memo[i][j] = solve(i-1,j-1) + solve(i-1,j);
		return memo[i][j];
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int y=0; y<=MAX_N; y++) {
			for(int x=0; x<=MAX_N;x++)
				memo[y][x] = -1;
		}
		
		System.out.println(solve(n,k));
	}
	}
}