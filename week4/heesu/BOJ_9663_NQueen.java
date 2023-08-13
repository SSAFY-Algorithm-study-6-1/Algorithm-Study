package samsung;
import java.util.*;
import java.io.*;
public class BOJ_9663_NQueen {
	static int n, ans;
	static int visited[][];
	
	static int dy[] = {-1,-1,0,1,1,1,0,-1};
	static int dx[] = {0,1,1,1,0,-1,-1,-1};
	static boolean OOB(int y,int x) {
		return y<=0 || y>n || x<=0 || x>n;
	}
	
	static void select(int cy,int cx) {
		visited[cy][cx]+=1;
		
		for(int dir = 0; dir<8;dir++) {
			int y = cy;
			int x = cx;
			
			while(true) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if(OOB(ny,nx))
					break;
				visited[ny][nx]+=1;
				y = ny;
				x = nx;
			}
		}
	}
	
	static void restore(int cy,int cx) {
		visited[cy][cx]-=1;
		
		for(int dir = 0; dir<8;dir++) {
			int y = cy;
			int x = cx;
			
			while(true) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if(OOB(ny,nx))
					break;
				visited[ny][nx]-=1;
				y = ny;
				x = nx;
			}
		}
	}
	
	
	static void solve(int cur_y,int cnt) {
		if(cnt == n) {
//			System.out.println(cnt);
			ans++;
			return;
		}
		
		for(int x=1; x<=n; x++) {
			if(visited[cur_y][x] != 0)
				continue;
			select(cur_y,x);
			solve(cur_y+1, cnt+1);
			restore(cur_y, x);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new int[n+1][n+1];
		solve(1,0);
		System.out.println(ans);
	}

}
