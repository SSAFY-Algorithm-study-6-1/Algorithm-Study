package baekjoon;

import java.util.Scanner;


//08:20 ~ 08:30
public class BaekJoon_11050 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	//자연수 n
		int k = sc.nextInt();	//뽑을 수 k
		
		int answer = factorial(n) / (factorial(k) * factorial(n - k));
		System.out.println(answer);
	}

	static int factorial(int n) {
		if(n == 0)	return 1;
		
		return n * factorial(n - 1);
	}
}