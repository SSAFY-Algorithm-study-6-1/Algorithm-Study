import java.util.*;
import java.io.*;

public class Main{
	static int n,k;
	static StringTokenizer st;
	static int MAX_N = 10;
	static int dp[][] = new int[MAX_N+1][MAX_N+1];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		dp[1][0] = 1;
		dp[1][1] = 1;
		
		for(int i = 2; i<=MAX_N;i++) {
			dp[i][0] = dp[i][i] = 1;
			for(int j = 1; j<=i-1; j++)
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
		}
		
		System.out.println(dp[n][k]);
		
	}
}