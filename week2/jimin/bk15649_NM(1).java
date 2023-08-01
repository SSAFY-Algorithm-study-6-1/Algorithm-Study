package recursive;

import java.util.Scanner;

public class bk15649 {
//자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
//1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
	static int N,M;//입력1,2
	static int[] picked;//뽑는 배열		
	static boolean []isSelected;//중복 체크를 위한 배열
	public static void main(String[] args) {
		//숫자1,2입력
		Scanner sc = new Scanner(System.in);		
		N=sc.nextInt();
		M=sc.nextInt();
		
		picked=new int[M];
		isSelected = new boolean[N];
		
		permutation(0);
	}
		
	private static void permutation(int idx) {
		//중복 체크
		if(idx==M) {
			//순열 출력
			for(int i=0;i<M;i++)
				System.out.print(picked[i]+" "); 
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) {
			//중복제거
			if (isSelected[i])
				continue;
			picked[idx]=i+1;		//요소뽑기
			
			isSelected[i]=true;	//사용 처리
			permutation(idx+1);	//다음 숫자 뽑기
			
			isSelected[i]=false;//다음 숫자 뽑기 위해 체크 해제
		}
	}
}
