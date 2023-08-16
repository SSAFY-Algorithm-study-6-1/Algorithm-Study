package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18429_근손실 {
	/**
	 * 1. 운동 키트와 운동일이 주어짐
	 * 2. 운동 키트 하나 사용시 그 날 근육량 증가
	 * 3. 근육량이 500 이하로 떨어지지 않게 만들기
	 * 4. 백트래킹 사용
	 * @param args
	 * @throws IOException 
	 */
	
	static int exerciseKit[];
	static boolean used[];
	static int cnt;
	static int N, K, muscle = 500;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		exerciseKit = new int[N];
		used = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) exerciseKit[i] = Integer.parseInt(st.nextToken());
		
		exercise(0);
		System.out.println(cnt);
	}
	
	static void exercise(int day) {
		if(day == N) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < exerciseKit.length; i++) {
			if(!used[i] && muscle + exerciseKit[i] - K >= 500) {
				used[i] = !used[i];
				muscle += exerciseKit[i];
				muscle -= K;
				exercise(day + 1);
				muscle += K;
				used[i] = !used[i];
				muscle -= exerciseKit[i];
			}
		} 
		
	}

}
