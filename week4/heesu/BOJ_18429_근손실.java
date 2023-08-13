package samsung;

import java.util.*;
import java.io.*;
public class BOJ_18429_근손실 {
	
	static int n,k,ans;
	static int arr[];
	static boolean visited[];
	static StringTokenizer st;
	
	static void solve(int cur, int weight) {
		if(cur == n) {
			ans++;
			return;
		}
		
		for(int i = 0; i<n;i++) {
			if(visited[i])
				continue;
			
			// cutting
			if(weight - k +arr[i] >= 500) {
				visited[i] = true;
				solve(cur + 1, weight - k + arr[i]);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n];
		
		solve(0, 500);
		System.out.println(ans);
		
	}

}
