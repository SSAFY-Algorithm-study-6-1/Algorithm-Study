package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bk_7569 {
		static int dx[] = {-1, 0, 0, 1, 0, 0};
		static int dy[] = {0, -1, 1, 0, 0, 0};
		static int dz[] = {0, 0, 0, 0, 1, -1};

		static int[][][] ch, box;
		static int x,y,z;// 가로,세로,높이 칸 수
		static Queue<Point> q = new LinkedList<>();

		static class Point {
			int x, y,z;

			public Point(int hz, int x, int y) {				
				this.x = x;
				this.y = y;
				this.z = z;
			}
		}

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			x = sc.nextInt(); 
			y = sc.nextInt();
			z = sc.nextInt();

			box = new int[z][y][x];
			ch = new int[z][y][x];

			// 입력 받기 - 박스의 아래부터 저장 ->  n-1로 시작
			for(int k = z-1; k >= 0; k--) {
				for (int i = y - 1; i >= 0; i--) {
					for (int j = x - 1; j >= 0; j--) {
						int t = sc.nextInt();
						box[k][i][j] = t;
						if (t == 1) q.add(new Point(k,i,j));
					}
				}
			}

			BFS();

			if(checkTomato()) System.out.print(findLastDay());
			else System.out.print(-1);
		}

		private static int findLastDay() {
			int answer = Integer.MIN_VALUE;
			for(int i = z-1; i >= 0; i--) {
				for(int j = y-1; j >= 0; j--) {
					for(int k = x-1; k >= 0; k--) {
						answer = Math.max(answer, ch[i][j][k]);
					}
				}
			}
			return answer;
		}

		private static boolean checkTomato() {
			for(int k = z -1; k >= 0; k--) {
				for (int i = y - 1; i >= 0; i--) {
					for (int j = x - 1; j >= 0; j--) {
						if(box[k][i][j] == 0) return false;
					}
				}
			}
			return true;
		}

		// 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 토마토 x
		public static void BFS() {
			while(!q.isEmpty()) {
				Point tmp = q.poll();
				for(int i = 0; i < dx.length; i++) {
					int nx = tmp.x - dx[i];
					int ny = tmp.y - dy[i];
					int nz = tmp.z - dz[i];
					if(nx >= 0 && nx < y && ny >= 0 && ny < x && nz >= 0 && nz < z && box[nz][nx][ny] == 0) {
						box[nz][nx][ny] = 1;
						q.add(new Point(nz, nx, ny));
						ch[nz][nx][ny] = ch[tmp.z][tmp.x][tmp.y] + 1;
					}
				}
			}
		}

	}
