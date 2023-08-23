package w5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class CodeTree_회전하는빙하 {
	
	static int[][] map;
	static int iceSum;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static List<int[]> temp = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 회전가능한 레벨 2^n x 2^n 배열
		int q = Integer.parseInt(st.nextToken()); // 회전 횟수
		
		map = new int[(int) Math.pow(2,n)][(int) Math.pow(2,n)];
		for (int i = 0; i < (int) Math.pow(2,n); i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <(int) Math.pow(2,n); j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < q; i++) {  //회전
			
			int L =  Integer.parseInt(st.nextToken());
			mapRotate((int)Math.pow(2, L));  // 빙하 회전
			melt();   // 빙학 녹이기
			
		}

		
		// 빙하 양 세기 + 가장 큰 빙합 집합 구하기
		int iceSetSum = 0;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j]!=0) {
					int cnt = bfs(i,j);
					iceSetSum = Math.max(iceSetSum, cnt);
				}
			}
		}
		System.out.println(iceSum);
		System.out.println(iceSetSum);

		
	}

	private static void melt() {
		temp.clear();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				int cnt = 0;
				for (int d = 0; d < dx.length; d++) {
					int x = i + dx[d];
					int y = j + dy[d];
					if(x<0 || y<0 || x>=map.length || y>=map[0].length || map[x][y]==0) continue;
					cnt++;
				}
				if(cnt <3 && map[i][j]!=0) temp.add(new int[] {i,j});
			}
		}
		for (int[] t:temp) {
			map[t[0]][t[1]]--;
		}
	}

	private static int bfs(int cx, int cy) {

		int cnt = 0;
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{cx, cy});
		iceSum += map[cx][cy];
		map[cx][cy] = 0;
		cnt++;
		int x = 0;
		int y = 0;
		while(!q.isEmpty()) {
			int[] pos = q.poll();
		
			for (int d = 0; d < dx.length; d++) {
				x = pos[0] + dx[d];
				y = pos[1] + dy[d];
				if(x<0 || y<0 || x>=map.length || y>=map[0].length || map[x][y]==0) continue;
				q.offer(new int[] {x,y});
				iceSum += map[x][y];
				cnt++;
				map[x][y] = 0;

			}
		}
		return cnt;
	}

	private static void mapRotate(int size) {
		for (int i = 0; i < map.length; i+=size) {  // map 전체를 각갈 회전하기 위해 size만큼 넘어 회전해야하는 촤상단을 가리키는 반복문
			for (int j = 0; j < map[i].length; j+=size) {
				//시계방향 회전
				oneSetRotate(i,j, size);   // 회전해야 하는 좌상단 위치
			}
		}
	}

	private static void oneSetRotate(int initX, int initY, int size) {
		
		int halfSize = size/2;
		
		int[] dx = {0, 1 * halfSize, 0, -1 * halfSize};
		int[] dy = {1 * halfSize, 0, -1 * halfSize, 0};
		
		
		int x,y;

		int prev;
		int temp;
		for (int i = initX; i < initX+halfSize; i++) {	
			for (int j = initY; j < initY+halfSize; j++) {
								
				prev = map[i][j];  // 좌상단 값
				x = i;
				y = j;
				for (int d = 0; d < dx.length; d++) {
					x += dx[d];
					y += dy[d];

					temp = map[x][y];   //swap
					map[x][y] = prev;
					prev = temp;
				}

			}
		}		

	}

}