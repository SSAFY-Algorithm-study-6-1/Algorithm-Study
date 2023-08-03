

import java.util.*;
import java.io.*;

public class BOJ_15651_N과M_3{
	static StringTokenizer st;
	static int n,m;
	static ArrayList<Integer> selected = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static void solve(int cnt) {
		if(cnt == m) {
			for(int i = 0; i<selected.size();i++)
				sb.append(selected.get(i)).append(" ");
			sb.append("\n");
			return;
			
		}
		
		
		for(int i = 1; i<=n; i++) {
			
			selected.add(i);
			solve(cnt+1);
			selected.remove(selected.size() - 1);
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		solve(0);
		System.out.println(sb);
	}
}