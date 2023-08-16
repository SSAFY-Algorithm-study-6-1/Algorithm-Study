package Algorithm.BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_3896_소수사이수열 {
	/**
	 * 1. 수 입력받기
	 * 2. 소수이면 0
	 * 3. 합성수이면 그 합성수보다 큰 소수 - 더 작은 소수 값 출력
	 * 4. 에라토스테네스의 체 사용
	 * @param args
	 */
	static StringBuilder sb = new StringBuilder();
	static int MAX_NUM = 1300000;
	static boolean[] nums = new boolean[MAX_NUM + 1];
	static ArrayList<Integer> primes = new ArrayList<>();
	
	public static void main(String[] args) {
		nums[1] = true;
		for (int i = 2; i <= MAX_NUM; i++) {
			if(!nums[i]) {
				primes.add(i);
				if(i <= Math.sqrt(MAX_NUM)) {
					int cnt = 2;
					while(i * cnt <= MAX_NUM) {
						nums[i * cnt] = true;
						cnt++;
					}
				}
			}
		}
		
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for (int tc = 0; tc < testCase; tc++) {
			int k = sc.nextInt();
			if(!nums[k]) {
				sb.append(0).append("\n");
			}else {
				for (int i = 0; i < primes.size(); i++) {
					if(primes.get(i) > k) {
						sb.append(primes.get(i) - primes.get(i - 1)).append("\n");
						break;
					}
				}
			}
		}
		
		System.out.println(sb);
		sc.close();
	}

}
