import java.util.*;
import java.io.*;


public class BOJ_2606_바이러스{
	static StringTokenizer st;	
	static int n,m;
	static ArrayList<Integer> adj[];
	static boolean visited[];
	
	static int dfs(int cur) {
		int cnt = 1;
		for(int nxt : adj[cur]) {
			if(visited[nxt])
				continue;
			visited[nxt] = true;
			cnt += dfs(nxt);
		}
		
		return cnt;
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[n+1];
		for(int i = 1; i<=n; i++)
			adj[i] = new ArrayList<>();
		visited = new boolean[n+1];
		m = Integer.parseInt(br.readLine());
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		visited[1] = true;
		System.out.println(dfs(1) - 1);
	}
}