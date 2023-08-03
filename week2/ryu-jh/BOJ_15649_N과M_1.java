import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N ,M;

	public static int progression[];
	public static boolean visited[];
	public static int result[];
	public static StringBuilder sb = new StringBuilder();
	
	public static void fprogression(int n) {
		if (n == M) {
			String ss;
			for(int i= 0; i< M;i++) {
				sb.append(String.format("%d ", result[i]));
			}
			sb.append("\n");
			return;
		}
		
		
		for(int i = 0; i < progression.length;i++) {
			if (visited[i] == false){
				result[n] = progression[i];
				visited[i] = true;
				fprogression(n+1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		progression = new int [N];
		result = new int[M];
		
		for(int i = 1; i <= N;i++) {
			progression[i-1] = i;
		
		}
		
		visited = new boolean [N];
		fprogression(0);
		System.out.println(sb);
	}
}
