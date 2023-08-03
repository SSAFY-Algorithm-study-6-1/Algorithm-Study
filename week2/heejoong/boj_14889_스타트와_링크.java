package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 14489 스타트와 링크
 * 팀 나누기
 * nC(n/2) 구하기
 */
public class boj_14889_스타트와_링크 {
	static ArrayList<int[]> pick = new ArrayList<int[]>();	//조합의 모든 경우의 수 저장
	static int[][] matrix;	//사람들의 점수 정보 저장
	static int[] startTeam;	//조합을 통해 뽑힌 숫자 경우의 수들 저장
	static int[] linkTeam;	//뽑히지 않은 숫자 저장
	static boolean[] isPicked;	//이미 뽑은 수인지 확인용
	static int minScore = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		//입력 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//n값 기반 static 변수들 선언
		matrix = new int[n][n];
		startTeam = new int[n / 2];
		linkTeam = new int[n / 2];
		isPicked = new boolean[n];
		
		//matrix 입력
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//팀 나누기
		scoreMinDiff(n, 0, 0);
		System.out.println(minScore);
	}
	
	//순열을 통해 팀 나누기
	static void scoreMinDiff(int n, int idx, int start) {
		//스타트팀 모두 고르면
		if(idx == n / 2) {
			//남은 사람으로링크팀 생성
			int idx2 = 0;
			for(int i = 0; i < n; i++) {
				if(!isPicked[i]) {
					linkTeam[idx2] = i;
					idx2++;
				}
			}
			
			//각 팀 점수 구하기
			int startScore = 0;
			int linkScore = 0;
			
			for (int i = 0; i < startTeam.length - 1; i++) {
				for (int j = i + 1; j < startTeam.length; j++) {
					int startIdx1 = startTeam[i];
					int startIdx2 = startTeam[j];
					int linkIdx1 = linkTeam[i];
					int linkIdx2 = linkTeam[j];
					
					startScore += matrix[startIdx1][startIdx2] + matrix[startIdx2][startIdx1];
					linkScore += matrix[linkIdx1][linkIdx2] + matrix[linkIdx2][linkIdx1];
				}
			
			}
			
			//최소차 구하기
			minScore = Math.min(minScore, Math.abs(startScore - linkScore));
			return;
		}
		
		//스타트 팀 고르기
		for (int i = start; i < n; i++) {
				if(!isPicked[i]) {
					startTeam[idx] = i;
					isPicked[i] = !isPicked[i];
					scoreMinDiff(n, idx + 1, i + 1);
					isPicked[i] = !isPicked[i];
				}
		}
	}
	
}
	
	