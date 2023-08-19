package week3.study;

import java.util.Scanner;

public class BOJ_9663_NQueen {
	static int N,result=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		 // 첫번째 행 1...N열 차례대로 퀸 놓고 다음 행 호출
        for (int col = 1; col <= N; col++) {
            int[] map = new int[N + 1];
            map[1] = col;
            dfs(map, 1);
        }
        System.out.println(result);
	}
	 static void dfs(int[] map, int row) {
	        if (row == N) { // 마지막 행까지 탐색 완료
	            result++;
	        } else { // 해당 행의 열을 처음 부터 N 까지 차례대로 탐색
	            for (int col = 1; col <= N; col++) {
	                map[row + 1] = col;
	                if (check(map, row + 1)) {	                   
	                    dfs(map, row + 1); // 놓을 수 있는 경우 다음 행 재귀
	                }
	            }
	        }
	    }
	 // 퀸 놓을 수 있는 자린지 체크하는 함수
    static boolean check(int[] map, int row) {        
        for (int i = 1; i < row; i++) {// 현재 퀸을 놓을려는 행의 이전 행들 차례대로 검사
        	if (map[i] == map[row]) { // 이전 행들에 같은 열에 퀸이 있는 경우
                return false;
            }            
            if (Math.abs(i - row) == Math.abs(map[i] - map[row])) {// 이전 행들에 대각선 공격 가능한 퀸이 있는 경우
                return false;
            }
        }
        return true;
    }
}
