
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * 오늘 배운 코드와 90%정도 동일합니다
 */
public class Main {
	static int N ,M;

	public static int result[];
	public static StringBuilder sb = new StringBuilder();
	
	//순열 백 트레킹 함수
	public static void fprogression(int n) {
		if (n == M) {//n이 M만큼 선택 되었을 때, StringBuilder를 통하여 append 시킴
			for(int i= 0; i< M;i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i < N;i++) {
			result[n] = i + 1;
			fprogression(n+1);
		}
	}
	
	public static void main(String args[])throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		String s = bf.readLine(); //String
		StringTokenizer st = new StringTokenizer(s, " "); //StringTokenizer인자값에 입력 문자열 넣음
		N = Integer.parseInt(st.nextToken()); //첫번째 호출
		M = Integer.parseInt(st.nextToken()); //두번째 호출
		
		result = new int[M];

		fprogression(0);
		System.out.println(sb);
	}
}
