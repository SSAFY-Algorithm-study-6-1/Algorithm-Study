import java.util.*;
import java.io.*;

class Tuple{
	int z, y, x;
	public Tuple(int z, int y, int x) {
		this.z = z;
		this.y = y;
		this.x = x;
	}
}

public class BOJ_7569_토마토{
	static StringTokenizer st;
	static int m,n,h;
	static int cube[][][], dist[][][];
	static Queue<Tuple> q = new LinkedList<>();
	
	static int dz[] = {-1,1,0,0,0,0};
	static int dy[] = {0,0,-1,1,0,0};
	static int dx[] = {0,0,0,0,-1,1};
	static boolean OOB(int z,int y, int x) {
		return z<=0 || z> h || y<=0 || y>n ||x<=0 || x>m;
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			Tuple cur = q.poll();
			
			for(int dir = 0; dir < 6; dir++) {
				int nz = cur.z + dz[dir];
				int ny = cur.y + dy[dir];
				int nx = cur.x + dx[dir];
				
				if(OOB(nz,ny,nx))
					continue;
				if(dist[nz][ny][nx] != -1 || cube[nz][ny][nx] == -1)
					continue;
				
				dist[nz][ny][nx] = dist[cur.z][cur.y][cur.x] + 1;
				q.add(new Tuple(nz,ny,nx));
			}
		}
	}
	
	static void print(int cube[][][]) {
		for(int z=1; z<=h; z++) {
			for(int y=1; y<=n; y++) {
				for(int x=1; x<=m; x++) {
					System.out.print(cube[z][y][x]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	static boolean allGrown() {
		for(int z=1; z<=h; z++) {
			for(int y=1; y<=n; y++) {
				for(int x=1; x<=m; x++) {
					if(cube[z][y][x] == -1)
						continue;
					if(dist[z][y][x] == -1)
						return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		cube = new int[h+1][n+1][m+1];
		dist = new int[h+1][n+1][m+1];
		
		
		for(int z = 1; z<=h; z++) {
			for(int y = 1; y<=n; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x= 1; x<=m; x++) {
					dist[z][y][x] = -1;
					cube[z][y][x] = Integer.parseInt(st.nextToken());
					if(cube[z][y][x] == 1) {
						dist[z][y][x] = 0;
						q.add(new Tuple(z,y,x));
					}
				}
			}
		}
		
		if(allGrown()) {
			System.out.println(0);
		}else {
			
			
			
			bfs();
			
			
//			print(dist);
			
			if(!allGrown())
				System.out.println(-1);
			else {
				int ans = -1;
				for(int z=1; z<=h; z++) {
					for(int y=1; y<=n; y++) {
						for(int x=1; x<=m; x++) {
							ans = Math.max(ans, dist[z][y][x]);
						}
				
					}
				}
				System.out.println(ans);
			}
				
			
		}
			
		
	}
}