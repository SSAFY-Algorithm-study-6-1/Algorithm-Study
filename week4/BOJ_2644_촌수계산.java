package samsung;
import java.util.*;
import java.io.*;


public class BOJ_2644_촌수계산 {
	static int n,m;
	static int a,b;
	static StringTokenizer st;
	static ArrayList<Integer> adj[];
	static int dist[];

	static void bfs(int root) {
		Queue<Integer> q = new LinkedList<>();
		q.add(root);
		dist[root] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int nxt : adj[cur]) {
				if(dist[nxt] != -1)
					continue;
				dist[nxt] = dist[cur] + 1;
				q.add(nxt);
						 
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		adj = new ArrayList[n+1];
		for(int i = 1; i<=n; i++)
			adj[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		for(int i = 0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		
		dist = new int[n+1];
		Arrays.fill(dist,-1);
		bfs(a);
		System.out.println(dist[b]);
		
	}

}
