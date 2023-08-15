package beakJoon;

/**
 * 하루가 지나면 k만큼 감소, 1개의 키트 사용
 * N개의 운동 키트
 * N일간 매일 중량 500이상으로 유지되도록 키트 순서의 경우의 수
 * 
 *  문제 해결
 *  키트 배열의 순열 구하기
 *  구한 순열을 기반으로 하루 중량이 500미만이 없다며 카운팅
 *  
 *  재귀로 순열 구해서 가지치기로 시간초과 해결하기
 */
import java.io.*;
import java.util.*;
public class BOJ_18429_근손실2 {
	static int N;
	static boolean[] visited;
	static int cnt;
	static int[] pick;
	static int[] kit;
	static int K;
		
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  
		K = Integer.parseInt(st.nextToken());
		
		pick = new int[N];
		st = new StringTokenizer(br.readLine());
		kit = new int[N];
		for(int i=0;i<N;i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[N];
		backtracking(0 , 500);   // depth, 초기 중량
		System.out.println(cnt);
	}
	
	private static void backtracking(int depth, int init) {
		if(N == depth) {
			cnt++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
				
			int temp = init - K + kit[i];
			if(temp < 500) continue;

			pick[depth] = kit[i]; 
			visited[i] = true;
			backtracking(depth+1, temp);
			visited[i] = false;
			
			
		}
	}
}

