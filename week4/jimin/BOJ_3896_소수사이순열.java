package week3.study;

import java.util.Scanner;

public class BOJ_3896_소수사이순열 {

	static StringBuilder sb = new StringBuilder();
	static int MAX=1299710;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean find[] = new boolean[MAX];
		for (int i = 2; i < 1299710; i++)
			for (int j = i; i * j > 2 && i * j < MAX; j++)
				find[i * j] = true;

		int t = sc.nextInt();
		while (t > 0) {
			int k = sc.nextInt();
			if (find[k]) {
				int a = k;
				int b = k;
				while (true) {
					if (!find[--a])
						break;
				}
				while (true) {
					if (!find[++b])
						break;
				}
				sb.append(b - a).append("\n");
			} 
			else
				sb.append(0).append("\n");
			t--;
		}
		System.out.println(sb);
	}

}
