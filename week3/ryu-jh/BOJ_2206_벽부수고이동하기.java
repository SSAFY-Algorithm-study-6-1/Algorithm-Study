import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {
	static int N,M;
	static int map[][];
	static boolean visited[][][];
	static int boareddist[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	static int mindist = Integer.MAX_VALUE;
	static boolean solutionfound = false;
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {0,0,1});// 0 - x // 1 - y // 2 - 벽부수기를 쓸 수 있나?//
		boareddist[0][0] = 1;
		visited[0][0][1] = true;

		while(!q.isEmpty()) {
			int qfront[] = q.poll();
			int x= qfront[0];
			int y= qfront[1];
			int skill= qfront[2];
			
			if (x == M - 1 && y == N - 1) {
				mindist =Math.min(boareddist[y][x] , mindist);
				solutionfound = true;
			}
			
			for(int d = 0;d < 4; d++) {
				int newx = x + dx[d];
				int newy = y + dy[d];
				int newItem = skill;
				
				if (newy<0 || newy >=N || newx <0 || newx >=M) continue;
				if (visited[newy][newx][newItem]) continue;
				if (map[newy][newx] == 1) {//벽을 만날 경우
					if (newItem == 1) //스킬이 있다면
						newItem = 0;// 스킬을 0으로 만들고 진행
					else//스킬이 없다면 벽 진행 X
						continue;
				}
				
				visited[newy][newx][newItem] = true;//방문 처리
				boareddist[newy][newx] = boareddist[y][x] + 1; //거리 계산
				q.offer(new int[] {newx,newy,newItem});
			}
		}
	}
	
	public static void main(String args[])throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//N - Y축 M - X축
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//초기화
		map = new int[N][M];
		boareddist = new int[N][M];
		visited = new boolean[N][M][2];
		
		//맵 입력
		for(int y =0; y< N;y++) {
			char mapc[] = br.readLine().toCharArray();
			for(int x = 0; x< M;x++) {
				if (mapc[x] == '1')
					map[y][x] =  1;
			}
		}
		bfs();
		
		if (solutionfound)
			System.out.println(mindist);
		else
			System.out.println(-1);
	}
}
