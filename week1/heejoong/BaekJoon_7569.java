package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon_7569 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		int h = sc.nextInt();
		
		int [][][] matrix = new int[h][n][m];
		
		//더 빠른 입력 있나 찾아보면 좋을듯
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					matrix[i][j][k] = sc.nextInt();
				}
			}
		}
		
		System.out.println(bfs(matrix, h, n, m));
		
		
	}
	
	static int bfs(int[][][] matrix, int h, int n, int m) {
		int day = -1;
		
		//2차원 왼오위아래, 3차원 위아래 비교해야함
		int[] dx = {-1, 0, 1, 0, 0, 0};	//row 이동
		int[] dy = {0, 1, 0, -1, 0, 0};	//col 이동
		int[] dz = {0, 0, 0, 0, 1, -1};	//floor 이동
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				for(int k = 0; k < matrix[i][j].length; k++) {
					//queue에 시작 노드들 삽입
					if (matrix[i][j][k] == 1) {
						int[] a = {i, j, k};	// 변수 바꾸자
						queue.add(a);
					}
				}
			}
		}
		
		//queue가 빌때까지 반복
		while(!queue.isEmpty()) {
			
			/**
			 * 현재의 큐가 완전히 비워져야 하루가 지난것
			 * 코드 살짝 변형 필요
			 */
			int lenQue = queue.size();
			
			for(int i = 0; i < lenQue; i++) {
				
				int[] node = queue.poll();	//queue에서 하나 뽑아옴
				int[] temp = new int[3];	//
				
				for(int d = 0; d < 6; d++) {
					//temp를 찾기
					temp[0] = node[0] + dz[d];
					temp[1] = node[1] + dy[d];
					temp[2] = node[2] + dx[d];
	
					//idx 범위 체크 - 범위 넘어가면 skip
					if(temp[0] < 0 || temp[0] >= h || temp[1] < 0 || temp[1] >= n || temp[2] < 0 || temp[2] >= m)	continue;
					
					int checked = matrix[temp[0]][temp[1]][temp[2]]; 	//검사 받는 칸의 값을 저장
					
					if(checked == 0) {	//만약 안익었으면
						matrix[temp[0]][temp[1]][temp[2]] = 1;	//안익은 토마토 익히기
						
						//queue에 익은 토마토 노드 추가 ==== 변수 바꾸자
						int[] b = {temp[0], temp[1], temp[2]};
						queue.add(b);
					}//end of if
				}//end of for(d)
			}//end of for(i)
			
			//하루치 노드가 끝나면 날짜++
			day++;
		}
		
		//안 익은 토마토가 있으면 return -1
		//마찬가지로 탐색 너무 느려보임
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				for(int k = 0; k < matrix[i][j].length; k++) {
					if(matrix[i][j][k] == 0)	return -1;
				}
			}
		}

		return day;
	}
}
