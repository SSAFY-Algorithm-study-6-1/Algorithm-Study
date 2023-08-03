

import java.util.*;
import java.io.*;

public class BOJ_14889_스타트와링크{
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int board[][];
	static int ans = Integer.MAX_VALUE;
	static boolean teamA[];
	static ArrayList<Integer> a,b;
	
	static void makeTeam(){
		a = new ArrayList<>();
		b = new ArrayList<>();
		for(int i = 1; i <=n ; i++) {
			if(teamA[i])
				a.add(i);
			else
				b.add(i);
		}
	}
	
	static int getScore(ArrayList<Integer> team) {
		int score = 0;
		int size = team.size();
		for(int i : team) {
			for(int j : team) {
				score += board[i][j];
			}
		}
		
		return score;
	}
	
	static void solve(int cur, int cnt) {
		if(cnt * 2 == n) {
			makeTeam();
			
			int scoreA = getScore(a);
			int scoreB = getScore(b);
			
			ans = Math.min(ans,  Math.abs(scoreA-scoreB));
			return;
		}
		
		if(cur == n+1 )
			return;
		
		teamA[cur] = true;
		solve(cur+1, cnt+1);
		teamA[cur] = false;
		
		solve(cur+1, cnt);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n+1][n+1];
		for(int y=1; y<=n; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=1; x<=n; x++) {
				board[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		teamA = new boolean[n+1];
		
		solve(1,0);
		System.out.println(ans);
	}
}