package day3;
//조합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk14889_스타트링크팀 {
	static int MIN,N;
	static int [][]map;
	static boolean []isSelected;	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		isSelected=new boolean[N];


		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}

		}
		MIN=Integer.MAX_VALUE;
		cook(0,0);
		System.out.println(MIN);

	}

	private static void cook(int idx,int start) {
		//요소 2개 선택
		if(idx==N/2) {			
			//System.out.println(Arrays.toString(isSelected));//출력 확인용			
			int min=getD();
			MIN=Math.min(MIN, min);
			return;
		}
		for (int i = start; i <N; i++) {
			isSelected[i]=true;
			cook(idx+1,i+1);
			isSelected[i]=false;
		}

	}
	private static int getD() {
		int S1=0,S2=0;//팀 시너지 합S1,S2
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//팀1 S1
				if(isSelected[i]&&isSelected[j]) {
					S1+=map[i][j];
				}
				//팀2 S2
				if(!isSelected[i]&&!isSelected[j]) {
					S2+=map[i][j];
				}
			}
		}
		return Math.abs(S1-S2);//|S1-S2|팀 시너지 차

	}
}
