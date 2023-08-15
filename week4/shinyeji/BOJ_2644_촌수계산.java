package beakJoon;

/**
 * 더 작은수 부터 시작하여 탐색 
 * 위로 올라가며 탐색 - 부모와 부모의 자식들 탐색
 * 
 * 재귀 돌려서 자식에 
 * 모두 탐색 후 없으면 -1
 */

import java.io.*;
import java.util.*;

public class BOJ_2644_촌수계산 {

	static int p2;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		if(p1<p2) {
			int temp = p1;
			p1 = p2;
			p2 = temp;
		}
		list = new ArrayList[n+1];
		int m = Integer.parseInt(br.readLine());
		for(int i=0;i<=n;i++) {
			list[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); 
			list[c].add(p);
			list[p].add(c);

		}
		visited = new boolean[n+1];
		if(dfs(p1,0)) {
			System.out.println("-1");
		}
	}
	private static boolean dfs(int child, int depth) {
		if(child == p2) {
			System.out.println(depth);
			return false;
		}
		for(int i=0;i<list[child].size();i++) {
			if(!visited[child]) {
				visited[child] = true;
				boolean isFound = dfs(list[child].get(i),depth+1);
				if(!isFound) return false;
				visited[child] = false;
			}
		}
		return true;
		
	}

}
