package beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14002_가장긴증가하는부분수열4 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N];
		int _max = -1;
		boolean flag = true;
		for(int i=0;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[j]+1,dp[i]);
					_max = Math.max(dp[i], _max);
					flag = false;
				}
			}
		}
		if(N <= 1 )_max = 0;
//		else if (flag){
//			_max = 0;
//		}
		sb.append(_max+1).append('\n');
		int order = _max;
		int[] temp = new int[_max+1];
		for(int i=N-1;i>=0;i--) {
			if(order == dp[i]) {
				temp[order]=arr[i];
				order--;
			}
		}
		for(int i=0;i<temp.length;i++) {
			sb.append(temp[i]+" ");
		}

		System.out.println(sb);
	}

}
