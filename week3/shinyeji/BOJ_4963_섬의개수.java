package beakJoon;

import java.util.*;
import java.io.*;

public class BOJ_4963_섬의개수 {
	static int[][] land;
	static int[] dx = {0,0,1,-1, 1,1,-1,-1};
	static int[] dy = {1,-1,0,0, 1,-1,1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int w;
		int h;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0)break;
			land = new int[h][w];
			for(int i=0;i<h;i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					land[i][j] = Integer.parseInt(st1.nextToken());
				}
			}
			int cnt=0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(land[i][j]==1) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		
	}
	private static void dfs(int x,int y) {
		if(x<0 || y<0 || x>=land.length || y>=land[0].length || land[x][y]==0) {
			return;
		}
		land[x][y]=0;
		for(int i=0;i<dx.length;i++) {
			dfs(x+dx[i],y+dy[i]);
		}
	}
}
