import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int kits[];
	static boolean visited[];
	static int Solution = 0;

	private static void dfs(int depth, int weight) {

		if (depth == N) {
			//int leftdays = K - N >= 0 ? K - N : 0;
			//int lessWeight = weight - 4 *(leftdays);
			//System.out.println(K - N);
			//System.out.println(lessWeight);
			if(weight >=500) {
				Solution++;
			}
			return;			
		}


		for(int i =0; i< N; i++) {
			if (visited[i])
				continue;

			int nextweight = kits[i] + weight - K;
			if (nextweight < 500)
				continue;

			visited[i] = true;
			dfs(depth + 1, nextweight);
			visited[i] = false;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		kits = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer (br.readLine());
		for(int i =0; i < N;i++) {
			kits[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 500);
		System.out.println(Solution);
	}
}