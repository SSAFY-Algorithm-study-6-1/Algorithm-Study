package beakJoon;

import java.util.Scanner;

public class BOJ_9663_NQueen {

	static boolean[] ableCol;
	static boolean[] ableLeftDiago;
	static boolean[] ableRightDiago;
	static int cnt;
	static int N;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ableCol = new boolean[N+1];
		ableLeftDiago = new boolean[N*2+1];
		ableRightDiago = new boolean[N*2];
		
		nqueen(1);
		System.out.println(cnt);
	}
	private static void nqueen(int row) {
		if(row == N+1) {
			cnt++;
			
			return;
		}
		for(int i=1;i<=N;i++) {
			if(isAblePut(row,i)) {
				nqueen(row+1);
				isSetFlagFalse(row,i);
			}
		}
	}
	private static boolean isAblePut(int r, int c) {
//		System.out.println((r+c-1)+" "+(r-c + N));
		if(ableCol[c] || ableLeftDiago[r+c] || ableRightDiago[r-c + N]) return false;
		ableCol[c] = true;
		ableLeftDiago[r+c] = true;
		ableRightDiago[r-c + N] = true;

		return true;
	}
	
	private static void isSetFlagFalse(int r, int c) {
		ableCol[c] = false;
		ableLeftDiago[r+c] = false;
		ableRightDiago[r-c + N] = false;

	}
}
