

import java.util.*;
import java.io.*;

public class BOJ_14002_가장_긴_증가하는_부분수열_4{
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int arr[], dp[];
	static ArrayList<Integer> dp2[];
	static final int INT_MIN = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		dp = new int[n+1];
		dp2 = new ArrayList[n+1];
		for(int i = 0; i<=n; i++) {
			dp2[i] = new ArrayList<>();
		}
		Arrays.fill(dp, INT_MIN);
		dp[0] = 0;
		
		
		for(int i = 1; i<=n; i++) {
			for(int j = 0; j<i; j++) {
				if(dp[j] == INT_MIN)
					continue;
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					
					
					ArrayList<Integer> temp = (ArrayList<Integer>)dp2[j].clone();
					temp.add(arr[i]);
					if(dp2[i].size() < temp.size())
						dp2[i] = temp;
				}
			}
		}
		
		ArrayList<Integer> result = null;
		int ans = INT_MIN;
		for(int i = 0; i <=n ;i++) {
			if(ans < dp2[i].size()) {
				ans = dp2[i].size();
				result = dp2[i];
			}
		}
		
		sb = new StringBuilder();
		sb.append(ans).append("\n");
		for(int i = 0; i<result.size(); i++) {
			sb.append(result.get(i)).append(' ');
		}
		System.out.println(sb);
	
	}
}