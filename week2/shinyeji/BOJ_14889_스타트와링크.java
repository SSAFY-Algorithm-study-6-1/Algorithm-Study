import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int members[];
	static boolean visited[];
	static List<int[]> teams;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		int[][] arr = new int[N][N];
		teams = new ArrayList<int[]>();
		members = new int[N];
		for(int i=0;i<N;i++) {
			members[i]=i+1;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(0, 0, new int[N/2]); // 팀1의 조합 리스트
		

		int _min = Integer.MAX_VALUE;
		
		for(int i=0;i<teams.size();i++) {	
			int[] team1 = teams.get(i);				// 팀2의 조합 리스트 (팀1외 나머지 인원)
			int[] team2 = new int[N/2];
			int idx1 = 0;         // team1의 idx
			int idx2 = 0;			
			for(int j=0;j<N;j++) {
				if(idx2==N/2)break;
				if(idx1==N/2) {
					team2[idx2++] = j+1;
					continue;
				}
				if(j+1<team1[idx1]) team2[idx2++] = j+1;
				if(j+1 == team1[idx1])idx1++;
			}
			int sum1 = 0;
			int sum2 = 0;
			for(int j=0;j<N/2;j++) {
				for(int k=0;k<N/2;k++) {
					if(team1[j]!=team1[k]) {
						sum1 += arr[team1[j]-1][team1[k]-1];
					}
					if(team2[j]!=team2[k]) {	
						sum2 += arr[team2[j]-1][team2[k]-1];
					}
				}
			}
			_min = Math.min(Math.abs(sum1-sum2),_min);
		}
		System.out.println(_min);
	}
	/**
	 * 
	 * @param idx oneSet을 위한 인덱스
	 * @param combiIdx 조합을 위한 인덱스
	 * @param oneSet 하나의 팀 셋을 저장
	 */
	private static void combination(int idx,int combiIdx, int oneSet[]) {
		if(idx == oneSet.length) {
			int[] temp = new int[oneSet.length];
			temp = oneSet.clone();
			teams.add(temp);
			return;
		}
		for(int i=combiIdx;i<members.length;i++) {
			if(visited[members[i]]==false) {
				oneSet[idx]=members[i];// 뽑기
				visited[members[i]] = true;
				combination(idx+1,i+1,oneSet);
				visited[members[i]] = false;	
			}
		}
	}

}
