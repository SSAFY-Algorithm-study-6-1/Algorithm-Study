import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class boj2644 {
	static int N;
	static int S1,S2;
	static int map[][];
	static boolean visit[];
	static int minn = Integer.MAX_VALUE;
	public static void dfs_backtrack(int depth, int curr) {
		if (curr == S2)
			minn = Math.min(minn,depth);
		if (curr == N +1)
			return;
		for(int i = 1; i <= N;i++) {
			if (visit[i])
				continue;
			if ( map[curr][i] == 0)
				continue;
			visit[i] = true;
			dfs_backtrack(depth + 1,i);
			visit[i] = false;
		}
	}
	
	public static void main(String args[])throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		S1 = Integer.parseInt(st.nextToken());
		S2 = Integer.parseInt(st.nextToken());
		
		int gansun = Integer.parseInt(br.readLine());
		for(int i =0 ;i < gansun; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}

		visit[S1] = true;
		dfs_backtrack(0,S1);
		visit[S1] = false;
		
		if (minn == Integer.MAX_VALUE)
			minn = -1;
		System.out.println(minn);
	}
}
