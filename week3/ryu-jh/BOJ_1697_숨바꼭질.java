import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int Solution;
	static boolean visit[] = new boolean[400001];

	public static void bfs() {
		Queue <int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {N,0});

		while(!que.isEmpty()) {
			int [] qfront = que.poll();
			int currnb = qfront[0];
			int currturn = qfront[1];

			if(currnb == K) {
				Solution = currturn;
				System.out.println(Solution);
				System.exit(0);
			}
			if (visit[currnb + 1] == false){
				visit[currnb + 1] = true;
				que.offer(new int[] { currnb + 1,currturn + 1 });
			}
			if (currnb - 1 >= 0){
				if (visit[currnb - 1] == false)	{
					visit[currnb - 1] = true;
					que.offer(new int[] { currnb - 1,currturn + 1 });
				}
			}
			if (currnb * 2 - K <= K - currnb)
			{
				if (visit[currnb * 2] == false)	{
					visit[currnb * 2] = true;
					que.offer(new int[] { currnb * 2,currturn + 1 });
				}
			}
		}
	}

	public static void main(String args[])throws IOException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		bfs();
	}
}