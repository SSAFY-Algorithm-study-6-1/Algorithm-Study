package samsung;
import java.util.*;
import java.io.*;


public class BOJ_1697_숨바꼭질 {
	static int n,k;
	static StringTokenizer st;
	static int MAX_R = (int)1e5;
	static int dist[] = new int[MAX_R+1];
	static boolean OOB(int cur) {
		return cur <0 || cur > MAX_R;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		Arrays.fill(dist, -1);
		
		Queue<Integer> q = new ArrayDeque<>();
		q.add(n);
		dist[n] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int nxt : new int[] {cur-1, cur+1, 2 * cur}) {
				if(OOB(nxt) || dist[nxt] != -1)
					continue;
				
				dist[nxt] = dist[cur] + 1;
				q.add(nxt);
				
			}
		}
		
		System.out.println(dist[k]);
	}
}
