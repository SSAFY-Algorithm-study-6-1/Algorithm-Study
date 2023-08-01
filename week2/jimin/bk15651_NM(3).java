package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk15651 {
	/*
	 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. 1부터 N까지 자연수 중에서
	 * M개를 고른 수열 같은 수를 여러 번 골라도 된다.
	 */
	static int N, M;
	static int[] picked;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		picked = new int[M];

		recursive(0);
		System.out.println(sb);
	}

	private static void recursive(int idx) {
		// 종료 조건
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(picked[i]+" ");
			}
			sb.append('\n');
			return;
		}
		for (int i = 1; i <= N; i++) {
			picked[idx] = i;// 요소 뽑기

			recursive(idx + 1);// 다음 요소 뽑기
		}

	}
}
