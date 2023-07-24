package test;
import java.util.*;
import java.io.*;

public class BOJ_11050_이항계수_백트래킹{
	static int n,k;
	static StringTokenizer st;
	static int ans;
	static ArrayList<Integer> selected;
	static void solve(int cur,int cnt) {
		if(cnt == k) {
			ans += 1;
			return;
		}
		
		if(cur == n)
			return;
		selected.add(cur);
		solve(cur+1, cnt+1);
		selected.remove(selected.size() - 1);
		
		solve(cur+1, cnt);
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		selected = new ArrayList<>();
		solve(0,0);
		System.out.println(ans);
	}
}