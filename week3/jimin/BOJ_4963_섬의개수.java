package week2.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 8방 탐색,
 * 시간복잡도 n
 *
 */
public class bk4963_섬의개수 {
	static int W,H;
	static int [][]map;
	static int []dx= {0,0,1,-1, 1,1,-1,-1};
	static int []dy= {1,-1,0,0, 1,-1,1,-1};
	static boolean [][]check;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			if(W==0&&H==0) break;//종료조건
			map=new int[H][W];
			check=new boolean[H][W];
			int cnt=0;
			
			//map
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
						
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j]==1 && !check[i][j]) {
						check[i][j]=true;
						dfs(i,j);
						cnt++;
					}						
				}
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int x,int y) {
		//8방향 탐색
		for (int d = 0; d < 8; d++) {
			int nx=x+dx[d];
			int ny=y+dy[d];
			if(nx<0 || ny<0 || nx>=H || ny >=W || map[x][y]==0 || check[nx][ny])
				continue;//범위
			check[x][y]=true;
			dfs(nx,ny);
		}
		return;
	}

}
