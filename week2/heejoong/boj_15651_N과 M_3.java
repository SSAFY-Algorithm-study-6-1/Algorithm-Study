package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedWriter;

/**
 * 
 * 15651 N과 M (3)
 *
 */
public class boj_15651 {
	static int[] arr = null;	//뽑은 수 저장용 배열
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];	//숫자 뽑아 저장하는 배열 크기 지정
		per(n, m, 0);	//숫자 뽑기 시작, StringBuilder에 숫자들을 집어 넣어 출력문 완성
		
		bw.write(sb.toString());	//BufferedWriter를 써서 출력
		bw.close();
		br.close();
	}
	
	static void per(int n, int m, int idx) {
		if(arr == null)	arr = new int[m];
		
		//꽉 찼으면 출력
		if(idx == m) {
			for (int num : arr) sb.append(num + " ");
			sb.append("\n");
			return;
		}
		
		//숫자 하나씩 골라서 배열에 넣어주기
		for (int num = 1; num <= n; num++) {
			arr[idx++] = num;
			per(n, m, idx);
			idx--;	//현재 숫자를 넣지 않은 경우를 고려하기 위해 인덱스 --
		}
	}

}