package baekjoon;

import java.io.IOException;
import java.util.*;

public class BOJ_2606_바이러스_dfs {
	/**
	 * 1. 첫 째 줄에 컴퓨터 대 수 N 입력
	 * 2. 두번 쨰 줄에 노드 간 연결된 수 K
	 * 3. 연결 관계 K개 주어짐
	 */
	static Map<Integer, ArrayList<Integer>> connect = new HashMap<>();
	static boolean[] visit;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		//입력부
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		visit = new boolean[N];
		visit[0] = true;

		for (int i = 1; i <= N; i++) connect.put(i, new ArrayList<>());

		ArrayList<Integer> temp;
		for (int i = 0; i < K; i++) {
			int cpu1 = sc.nextInt();
			int cpu2 = sc.nextInt();
			temp = connect.get(cpu1);
			temp.add(cpu2);
			temp = connect.get(cpu2);
			temp.add(cpu1);
		}

		System.out.println(dfs(1));
	}

	//dfs
	//감염된 cpu 번호 입력
	//해당 cpu와 인접한 cpu 리스트 가져오기
	//만약 감염되지 않은 cpu면 감염시키고 재귀호출
	static int dfs(int cpu) {
		ArrayList<Integer> cpuList = connect.get(cpu);
		for (int cpu2 : cpuList) {//cpu2 = 감염 cpu와 인접한 cpu
			if(!visit[cpu2 - 1]){
				visit[cpu2 - 1] = true;
				dfs(cpu2);
				cnt++;
			}
		}

		return cnt;
	}

}
