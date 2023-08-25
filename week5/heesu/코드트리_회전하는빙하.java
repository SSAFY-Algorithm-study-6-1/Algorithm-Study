import java.util.*;
import java.io.*;
/**
 * 1. level에 맞춰서 회전하기
 * 	1-1. 시작점 정하기 
 *  1-2. 시작점을 포함한 4개의 꼭짓점 만들기
 *  1-3. 초기값 저장하기
 *  1-4. 4개의 꼭짓점을 기준으로 4개의 격자를 당기기
 *  1-5. 초기값을 복원하기 
 * 2. 회전이 한번 끝나면 얼음 녹이기
 *  2-1. 얼음이 녹는건 동시에 진행됨 -> 이전 칸에서 녹은게 현재 칸이 녹을때 반영되지 않음 
 *  2-2. 각 칸마다 상하좌우로 얼음개수 세기
 *  2-3. 얼음 개수가 2개 이하일때 현재칸의 얼음수가 0개이면 그대로 냅두고 0개보다 크면 1개 줄이기
 *  2-4. 3개 이상이면 그대로 냅두
 * 3. 모두 끝났으면 가장 큰 얼음군집의 크기와 얼음의 크기합 구하기 
 * 
 * 
 * @author heesukim
 *
 */
public class 코드트리_회전하는빙하 {
	static int n,q;
	static int board[][], nxtBoard[][];
	static int boardSize;
	static StringTokenizer st;
	
	static class Pair{
		int y,x;
		public Pair(int y,int x) {
			this.y = y;
			this.x = x;
		}
		
		public String toString() {
			return y+" "+x;
		}
	}
	
	static int dy[] = {1,0,-1,0};
	static int dx[] = {0,1,0,-1};
	
	static Pair[] makePoints(int sy,int sx,int size){
//		ArrayList<Pair> ret = new ArrayList<>();
		Pair ret[] = new Pair[4];
		int y = sy;
		int x = sx;
		
		for(int dir = 0; dir<4;dir++) {
//			ret.add(new Pair(y,x));
			ret[dir] = new Pair(y,x);
			y = y + dy[dir] * size;
			x = x + dx[dir] * size;
		}
		
		return ret;
		
	}
	
	static boolean OOB(int y,int x) {
		return y<=0 || y>boardSize || x<=0 || x>boardSize;
	}
	
	// 각 시작점과 level을 기준으로 돌리기 
	static void rotate(int sy,int sx, int level) {
		if(level == 0) // level이 0이면 돌리지 않는다. 
			return;
		
		// 돌릴 격자 크기 구하기 
		int size = (1 << (level-1));
		
		// 꼭짓점 구하기 
		Pair points[] = makePoints(sy,sx,size);
		
		
		//0번째 격자의 값 저장 
		int temp[][] = new int[size][size];
		int d = 0;
		for(int y=0;y<size;y++) {
			for(int x=0; x<size;x++) {
				Pair cur = points[d];
				temp[y][x] = board[cur.y+y][cur.x+x];
			}
		}
		
		// 꼭짓점 기준으로 당기기 
		for(d= 0; d<4;d++) {
			for(int y= 0; y<size; y++) {
				for(int x= 0; x<size;x++) {
					Pair cur = points[d];
					Pair nxt = points[(d+1)%4];
					board[cur.y+y][cur.x+x] = board[nxt.y+y][nxt.x+x];
					
				}
			}
			
		}
		
		// 초기값 복원 
		Pair cur = points[3];
		for(int y= 0; y<size;y++) {
			for(int x=0; x<size; x++) {
				board[cur.y+y][cur.x+x] = temp[y][x];
			}
		}
		
//		printBoard(board);
		
	}
	
	
	// level에 맞춰서 회전하
	static void rotateAll(int level) {
		int len = 1 << level; // 돌릴 격자의 크기
		
		// 시작점 sy,sx
		for(int sy=1; sy<=boardSize; sy += len) {
			for(int sx=1; sx<=boardSize; sx+=len) {
				rotate(sy,sx, level);
			}
		}
	}
	
	static void printBoard(int board[][]) {
		for(int y=1; y<=boardSize;y++) {
			for(int x=1; x<=boardSize; x++)
				System.out.print(board[y][x]+" ");
			System.out.println();
		}
		System.out.println();
	}
	
	static boolean visited[][]; 
	
	static int bfs(int y,int x) {
		Queue<Pair> q = new ArrayDeque<>();
		visited[y][x] = true;
		q.offer(new Pair(y,x));
		int cnt = 0;
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			cnt++;
			for(int dir = 0; dir<4;dir++) {
				int ny = cur.y + dy[dir];
				int nx = cur.x + dx[dir];
				
				if(OOB(ny,nx) || board[ny][nx] == 0 || visited[ny][nx])
					continue;
				visited[ny][nx] = true;
				q.offer(new Pair(ny,nx));
			}
			
		}
		return cnt;
	}
	
	
	static void melt() {
		nxtBoard = new int[boardSize+1][boardSize+1];
		
		for(int y=1; y<=boardSize; y++) {
			for(int x=1; x<=boardSize;x++) {
				int cnt = 0;
				for(int dir = 0; dir<4;dir++) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if(OOB(ny,nx) || board[ny][nx] == 0)
						continue;
					cnt++;
				}
				
				// 얼음이 동시에 녹는걸 구현하기 위해 nxtBoard이용.
				// nxtBoard는 "다음 상태"를 의미한다.
				// 현재 board에서의 얼음이 녹은건 nxtBoard에 저장된다.
				// 따라서 이전칸에서 얼음이 녹은건 현재 칸을 검사할때 반영되지 않는다.
				if(cnt <= 2)
					nxtBoard[y][x] = board[y][x] > 0 ? board[y][x] - 1 : board[y][x];
				else
					nxtBoard[y][x] = board[y][x];
			}
		}
		
		board = nxtBoard;
	}
	
	public static void main(String[] args) throws IOException{
//		System.setIn(new FileInputStream("./input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		boardSize = 1 << n;
		board = new int[boardSize+1][boardSize+1];
		for(int y=1; y<=boardSize; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x = 1; x<=boardSize; x++) {
				board[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		
		
		for(int i = 0; i<q;i++) {
			int level = Integer.parseInt(st.nextToken());
			rotateAll(level);

			// 회전이 끝나면 얼음이 녹는다 
			melt();
		}
		
		int sum = 0;
		int maxSize = 0;
		visited = new boolean[boardSize+1][boardSize+1];
		for(int y=1; y<=boardSize;y++) {
			for(int x= 1; x<=boardSize;x++) {
				sum += board[y][x];
				if(visited[y][x] || board[y][x] == 0)
					continue;
				maxSize = Math.max(maxSize, bfs(y,x));
			}
		}
		
		System.out.println(sum+"\n"+maxSize);
	}
	
	
}
