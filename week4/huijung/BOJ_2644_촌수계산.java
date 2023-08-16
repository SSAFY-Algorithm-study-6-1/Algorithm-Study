package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {
	/**
	 * 1. 가족 수 N 주어짐
	 * 2. 촌수를 계산해야하는 두 사람 a, b
	 * 3. 부모-자식 관계의 수 M
	 * 4. M개의 연결관계
	 * @param args
	 */
	static int N, M, a, b, x, y;
	static Map<Integer, ArrayList<Integer>> family = new HashMap<Integer, ArrayList<Integer>>();
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) family.put(i, new ArrayList<Integer>());
		visited = new boolean[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			family.get(x).add(y);
			family.get(y).add(x);
		}
		
		bfs();
		
		
		
	}
	
	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		int cnt = 1;
		queue.add(a);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int key = queue.poll();
				ArrayList<Integer> connect = family.get(key);
				
				for (Integer person : connect) {
					if(person == b){
						System.out.println(cnt);
						return;
					}
					
					if(!visited[person]) {
						visited[person] = true;
						queue.add(person);
					}
				}
			}
			cnt++;
		}
		
		System.out.println(-1);
	}

}
