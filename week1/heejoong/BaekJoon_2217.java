package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_2217 {
	public static void main(String[] args) {
		/*
		 * 나눠 받을 수 있는 최대 중량 == 최소 무게 수용 가능한 로프 * n
		 * 로프를 사용하지 않아도 된다는 조건 => i번째 약한 로프 * (n - i)값도 정답으로 사용 가능
		 * i 번째 약한 로프 * (n - i)의 값을 비교하며 최대값 찾기
		 */		
		Scanner sc = new Scanner(System.in);
		
		int answer = -1;
		int n = sc.nextInt();
		int [] nums = new int[n];
		
		for(int i = 0; i < n; i++)	nums[i] = sc.nextInt();
		Arrays.sort(nums);	//정렬해서 0번 index부터 최소값으로 만듬
		
		//최대값 찾기
		for(int i = 0; i < n; i++) {
			answer = Math.max(nums[i] * (n - i), answer);
		}
		
		//최소값의 n배가 최대값
		System.out.println(answer);
	}

}