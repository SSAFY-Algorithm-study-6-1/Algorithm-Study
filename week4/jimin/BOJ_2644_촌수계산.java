package week3.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {
	static List<Integer>[] relation;
	static boolean[] checked;
	static int res = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		relation = new ArrayList[n + 1];
		checked = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++) {
			relation[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int par = Integer.parseInt(st.nextToken());
			int kid = Integer.parseInt(st.nextToken());
			relation[par].add(kid);
			relation[kid].add(par);
		}

		dfs(x, y, 0);
		System.out.println(res);

	}

	static void dfs(int from, int to, int cnt) {
		if (from == to) {
			res = cnt;
			return;
		}

		checked[from] = true;
		for (int i = 0; i < relation[from].size(); i++) {
			int next = relation[from].get(i);
			if (!checked[next]) {
				dfs(next, to, cnt + 1);
			}
		}
	}
}
