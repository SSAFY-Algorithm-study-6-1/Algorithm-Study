package test_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class longg {
	static int N;
	static int arr[];
	static int DP[];
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		DP = new int[N + 1];
		int ansArr[];
		int cnt;
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=1; i<=N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<=N; ++i) {
			for(int j=i+1; j<=N; ++j) {
				if(arr[i] < arr[j]) {  
					DP[j] = Math.max(DP[j], DP[i] + 1);
				}
			}
		}
				
		for(int i=1; i<=N; ++i) {
			ans = Math.max(ans, DP[i]);
		}		
		
		cnt = ans;
		ansArr = new int[ans];
		for(int i=N; i>0; --i) {
			if(DP[i] == cnt) {
				--cnt;
				ansArr[cnt] = arr[i];
			}
		}
		
		sb.append(ans + "\n");
		for (int i =0; i< ans;i++) {
			sb.append(ansArr[i]+" ");
		}
		System.out.println(sb);
	}
}
