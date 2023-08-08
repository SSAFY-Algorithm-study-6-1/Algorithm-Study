import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class vec2{
	public int x,y;
	public vec2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_4963 {
	static int N, M;
	static int map[][];
	static int dx[] = {0,0,-1,1,-1,1,-1,1};
	static int dy[] = {1,-1,0,0, 1,1,-1,-1};
	
	public static void countisland(int x, int y) {
		Queue<vec2> q = new LinkedList<vec2>();
		
		
		q.offer(new vec2(x,y));

		map[y][x] = 0;
		while(!q.isEmpty()) {
			vec2 curr = q.poll();
			
			for(int i =0;i < 8;i++) {
				int newx = curr.x + dx[i];
				int newy = curr.y + dy[i];
				if (newx < 0 || newx >=M || newy <0 || newy >= N)
					continue;
				if (map[newy][newx] == 0)
					continue;
				map[newy][newx] = 0; //방문 전에 방문 처리를 해야 중복 방문이 일어나지 않는다고 합니다
				q.offer(new vec2(newx,newy));
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[51][51];
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			if (N == 0 && M == 0)
				System.exit(0);
			
			for(int y = 0; y <N ;y++) {
				st = new StringTokenizer(br.readLine());
				for(int x =0; x < M; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}

			int solution = 0;
			for(int y = 0; y <N ;y++) {
				for(int x =0; x < M; x++) {
					if (map[y][x] == 1){
						countisland(x, y);
						solution++;
					}
				}
			}
			System.out.println(solution);
		}
	}
}
