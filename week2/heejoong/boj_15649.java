package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

/**
 * 
 * 15649 N과 M (1)
 *
 */
public class boj_15649 {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static boolean[] isNumChoosed;
	
	public static void main(String[] args) throws IOException {
		//입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//여러 경우의 순열을 저장하기 위한 int 배열 arr
		arr = new int[m];
		
		//중복 체크용 boolean 배열 -> 숫자 자체를 인덱스 겸 값으로 쓰기 위해(인덱스를 1부터 쓰기 위해) 배열 m+1로 만들어줌
		//해당 값의 인덱스가 true일 경우 중복 아니므로 arr에 추가 가능
		//e.g. isNumChoosed[3] == false 면 이미 arr 배열에 있다는 뜻
		isNumChoosed = new boolean[n + 1];
		for (int i = 1; i < isNumChoosed.length; i++) {
			isNumChoosed[i] = true;
		}
		
		//재귀적으로 순열 체크 시작
		per(n, m, 0);
		
		//결과값 출력
		bw.write(sb.toString());
		bw.close();
		
		br.close();
		
	}
	
	static void per(int n, int m, int idx) {
		/**종료 조건
		*idx는 arr의 크기 체크용 index변수
		*idx가 m과 같을 경우 한 가지의 순열 종료
		*StringBuilder에 해당 순열 결과 저장
		**/
		if(idx == m) {
			for(int num : arr)	sb.append(num + " ");
			sb.append("\n");
			return;
		}
		
		
		/**순열 뽑기
		 * n 범위의 숫자들 안에서 뽑기
		 * 만약 n이 이미 뽑혔으면(isNumChoosed[num] == false) continue
		 */
		for(int num = 1; num <= n; num++) {
			if(isNumChoosed[num] == false) continue;
			
			isNumChoosed[num] = false;
			arr[idx] = num;
			per(n, m, idx + 1);
			isNumChoosed[num] = true;
		}
		
	}

}
