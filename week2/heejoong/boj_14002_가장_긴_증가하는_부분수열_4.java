package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * 14002 가장 긴 증가하는 부분 수열 4
 */
public class boj_14002_가장_긴_증가하는_부분수열_4{
	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer();
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		int nums[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		/**
		 * dp - 뒤에서 부터 탐색
		 * 1. 초기 값(숫자배열의 맨 뒤에 값)을 넣어주고 1번째 순서라고 dp 배열에 저장해줌
		 * 2. 더 작은값이 올 경우 이전 dp값 + 1 && 최장거리 dp값 인덱스 갱신
		 * 		- 최장거리 dp값보다 작은 값이므로 현재 값이 새로운 최장거리 dp값이 된다
		 * 3. 크거나 같은 값이 올 경우
		 * 		3.1 현재 값 이전 값들이 저장된 nums & dp 배열 탐색
		 * 		3.2 현재 비교하는 nums값보다 큰 값을 가진 곳 중 dp값이 최대인 값에 + 1한 값을 준다.
		 */
		int[] dp = new int[n];
		dp[n - 1] = 1;	//1. 초기값 설정
		int dpMax = n - 1;	//현재 시행 중 dp값이 가장 큰 곳의 index값 저장
		
		for (int i = n - 2; i >= 0; i--) {
			if(nums[i] < nums[dpMax]) {	//2. 더 작은값이 올 경우 이전 dp값 + 1 && 최장거리 dp값 인덱스 갱신
				dp[i] = dp[dpMax] + 1;
				dpMax = i;	//최장거리 dp값 인덱스 갱신
			}else if(nums[i] >= nums[dpMax]) {//3. 크거나 같은 값이 올 때
				for (int j = i + 1; j < n; j++) {	//3.1 현재 값 이전 값들이 저장된 nums & dp 배열 탐색	
					if(nums[i] < nums[j]) {	//3.2 현재 비교하는 nums값보다 큰 값을 가진 곳 중 dp값이 최대인 값에 + 1한 값을 준다.
						if(dp[i] < dp[j] + 1)	dp[i] = dp[j] + 1;
						if(dp[dpMax] < dp[i])	dpMax = i;
					}
				}
				if(dp[i] == 0)	dp[i] = 1;	//이 전 nums 값에 더 큰 숫자가 없으면 dp값을 1로 준다(초기값 중 하나로 설정)
			}
			
		}		
		
		/**
			2. 최장 길이 찾기
		 */
		
		//최장 길이 len 찾기
		int len = 0;
		for (int d : dp) {
			len = Math.max(len, d);
		}
		
		System.out.println(len);
		
		//dp배열 탐색하면서 최장 배열 뽑기
		for (int i = 0; i < n; i++) {
			if(len == 0)	break;
			if(dp[i] == len) {
				sb.append(nums[i] + " ");
				len--;
			}
		}
		System.out.println(sb.toString());
		
		
	}	
	
}
