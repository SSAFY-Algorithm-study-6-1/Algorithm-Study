package beakJoon;

import java.io.*;
import java.util.*;

public class BOJ_2606_바이러스 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int V = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[N+1];
		boolean[][] path = new boolean[N+1][N+1];
		for(int i=0;i<V;i++) {
			int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			path[temp[0]][temp[1]] = true;
			path[temp[1]][temp[0]] = true;
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visited[1]=true;
		int cnt = 0;
		while(q.size()>0) {
			int cur = q.poll();
			cnt++;
			for(int i=1;i<=N;i++) {
				if(path[cur][i]==true && !visited[i]) {
					visited[i]=true;
					q.offer(i);	
				}
			}

		}
		System.out.println(cnt-1);
		
		
	}

}
