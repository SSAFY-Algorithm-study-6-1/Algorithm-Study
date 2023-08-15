package beakJoon;

/**
 * 합성수 : 1이 아니고 소수도 아닌 양의 정수
 * 소수 사이 순열 : p ~ p+n의 합성수 
 * 
 * k를 포함하는 소수 사이 순열의 길이 구하기
 * 
 *	 k = 10일때 k를 포함하는 소수 사이 순열은 :  7 8 9 10 11 ; 
 * 	 길이 = 8부터 11을 포함하여 답은 4이다
 * 
 * 1. k부터 left-- right++로 진행하여 각 수가 합성수가 아닌지 판단
 * 2. 합성수가 아니라면 인덱스를 멈춘다
 * 3. left, right 두 인덱스가 멈추면 k를 포함한 길이를 출력
 */

import java.io.*;
import java.util.*;

public class BOJ_3896_소수사이수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int k = Integer.parseInt(br.readLine());
			
			int right = k;
			int left = k;
			boolean rFlag = true;
			boolean lFlag = true;
			if(isPrime(k)) {
				sb.append("0").append('\n');
				continue;
			}
			while(rFlag || lFlag) {
				if(lFlag && left>0) left--;
				if(rFlag) right++;
				
				if(left==1 || isPrime(left)) lFlag = false; // left 가 합성수가 아니면 lFlag = false;
				if(right==1 || isPrime(right)) rFlag = false; // right 가 합성수가 아니면 lFlag = right;
			}
			sb.append(right-left).append('\n');
		}
		System.out.println(sb);
	}
	private static boolean isPrime(int num) {
		
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i == 0)return false;
		}
		
		return true;
	}

}
