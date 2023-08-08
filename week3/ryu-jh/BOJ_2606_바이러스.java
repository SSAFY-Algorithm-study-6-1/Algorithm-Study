import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class qdata{
	public int x = 0;
	public int y = 0;
}

public class Main {
	static Queue<Integer> q = new LinkedList<Integer>();
	public static int N;
	public static int M;
	public static int map[][];
	public static boolean visited[];
	
	public static void bfs() {
		q.offer(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			
			int current = q.poll();
			for(int i = 1 ; i <= N;i++) {
				if (visited[i]) continue;
				if (map[current][i] == 0) continue;
				
				visited[i] = true;
				q.offer(i);
			}
		}
	}
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		visited = new boolean [N+1];
		
		StringTokenizer st;// = new StringTokenizer();//br.readLine());
		for(int i = 0 ; i <M;i++) {
			st = new StringTokenizer(br.readLine());
			int com1 = Integer.parseInt(st.nextToken());
			int com2 = Integer.parseInt(st.nextToken());
			map[com1][com2] = 1;
			map[com2][com1] = 1;
		}
		
		bfs();
		
		int solution = 0;
		for(int i = 2; i <= N; i++) {
			if (visited[i])
				solution++;
		}
		
		System.out.println(solution);
		//br.readLine();
	}
}