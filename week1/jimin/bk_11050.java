import java.util.Scanner;

public class bk_11050 {
	public static void main(String[] args) {
		// TODO 이항계수
		// 자연수 N과 정수 K가 주어졌을 때 이항 계수
//    \(\binom{N}{K}\)를 구하는 프로그램을 작성하시오.
		Scanner sc = new Scanner(System.in);
		int inNum;
		int inNum2;

		inNum = sc.nextInt();
		inNum2 = sc.nextInt();
		int result = factorial(inNum) / (factorial(inNum2) * factorial(inNum - inNum2));
		System.out.println(result);
		sc.close();
	}
	public static int factorial(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

}
