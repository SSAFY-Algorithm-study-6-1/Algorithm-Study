package samsung;
import java.util.*;
import java.io.*;

class Pair{
	int y,x;
	public Pair(int y,int x) {
		this.y = y;
		this.x = x;
	}
}

public class BOJ_4963_섬의개수 {
	static int w,h;
	static int board[][];
	static StringTokenizer st;
	static boolean visited[][];
	static int dy[] = {-1,-1,0,1,1,1,0,-1};
	static int dx[] = {0,1,1,1,0,-1,-1,-1};
	static boolean OOB(int y,int x) {
		return y<=0 || y>h ||x<=0 || x>w;
	}
	
	static void bfs(int y,int x) {
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(y,x));
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			
			for(int dir = 0; dir<8;dir++) {
				int ny = cur.y + dy[dir];
				int nx = cur.x + dx[dir];
				if(OOB(ny,nx) || visited[ny][nx] || board[ny][nx] == 0)
					continue;
				visited[ny][nx] = true;
				q.offer(new Pair(ny,nx));
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h ==0)
				break;
			board = new int[h+1][w+1];
			for(int y=1; y<=h; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x=1; x<=w; x++) {
					board[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[h+1][w+1];
			int size = 0;
			for(int y=1; y<=h ;y++) {
				for(int x=1; x<=w; x++) {
					if(visited[y][x] || board[y][x] == 0)
						continue;
					bfs(y,x);
					size++;
				}
			}
			
			sb.append(size).append('\n');
			
		}
		System.out.println(sb);
	}
	
}
