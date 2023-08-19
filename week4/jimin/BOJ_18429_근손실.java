package week3.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429_근손실 {
	static int n, k,res;
    static int[] arr;
    static boolean[] visit;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[n];
        res = 0;
        back(500, 0);
        System.out.println(res);

	}
	static void back(int sum, int idx) {
        if (idx == n) {
            res++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i] && (sum + arr[i] - k) >= 500) {
                visit[i] = true;
                back(sum + arr[i] - k, idx + 1);
                visit[i] = false;
            }
        }
    }

}
