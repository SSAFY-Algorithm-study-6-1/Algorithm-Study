import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int Map[][] = new int[20][20];
	static boolean isSelected[] = new boolean[20];
	public static ArrayList<Integer> team1 = new ArrayList<Integer>();
	public static ArrayList<Integer> team2 = new ArrayList<Integer>();
	public static int Mintestdiff = Integer.MAX_VALUE;
	
	
	//팀 점수 얻어오기
	private static int GetTeamPoint(int team) {
		int res =0;
		
		if (team == 1){
			for(int a: team1) {
				for(int b: team1) {
					res += Map[a][b];
				}
			}	
		}
		if (team == 2){
			for(int a: team2) {
				for(int b: team2) {
					res += Map[a][b];
				}
			}	
		}
		return res;
	}
	

	//팀원을 N/2만큼 뽑은 뒤, 최솟값 확인
	private static void dfs(int curr,int depth) {
		if (curr >= N)
			return;
		
		if (depth == N/2) {
			team1.clear();
			team2.clear();
			for(int i = 0; i< N;i++) {
				if ( isSelected[i]) {
					team1.add(i);
				}else {
					team2.add(i);
				}
			}
			
			int team1point = GetTeamPoint(1);
			int team2point = GetTeamPoint(2);
			
			Mintestdiff = Math.min(Math.abs(team1point-team2point), Mintestdiff);
			return;
		}
		

		isSelected[curr] = true;
		dfs(curr + 1, depth+1);
		isSelected[curr] = false;
		dfs(curr + 1, depth);
		 
	}
	
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		Mintestdiff = Integer.MAX_VALUE;
		N = sc.nextInt();
		for(int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				Map[y][x] = sc.nextInt();
			}
		}
		dfs(0,0);
		System.out.printf("%d\n",Mintestdiff);
	}
}