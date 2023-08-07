package baekjoon;

import java.io.IOException;
import java.util.*;

public class BOJ_2606_바이러스_bfs {
	/**
	 * 1. 첫 째 줄에 컴퓨터 대 수 N 입력
	 * 2. 두번 쨰 줄에 노드 간 연결된 수 K
	 * 3. 연결 관계 K개 주어짐
	 */
	static Map<Integer, ArrayList<Integer>> connect = new HashMap<>();
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		//입력부
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		visit = new boolean[N];
		visit[0] = true;

		for (int i = 1; i <= N; i++) connect.put(i, new ArrayList<>());
		
		//연결 관계 입력
		// ArrayList<ArrayList>> 혹은 Map<Integer, ArrayList>>꼴로 만들어 정보 저장
		// 이럴 경우 [1 : 1,2,3 | 2 : 1,3,5 | 3 : 1,2,5 | ... ] 이런식으로 정보 저장 가능
		ArrayList<Integer> temp;
		for (int i = 0; i < K; i++) {
			int cpu1 = sc.nextInt();
			int cpu2 = sc.nextInt();
			temp = connect.get(cpu1);
			temp.add(cpu2);
			temp = connect.get(cpu2);
			temp.add(cpu1);
		}

		System.out.println(bfs());
	}

	//bfs
	//인근 노드 탐색
	//감염된 초기 노드 1을 queue에 삽입
	//만약 인접 노드가 감염되지 않은 노드(visit[i] == false)면 감염시키고 감염된 cpu 번호를 queue에 넣음
	static int bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		int cnt = 0;

		while (!queue.isEmpty()) {
			int cpuNum = queue.poll();
			ArrayList<Integer> cpuList = connect.get(cpuNum);
			for (int cpu : cpuList) {
				if(!visit[cpu - 1]){
					queue.add(cpu);
					visit[cpu - 1] = true;
					cnt++;
				}
			}
		}

		return cnt;
	}

}
