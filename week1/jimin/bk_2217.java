import java.util.Arrays;
import java.util.Scanner;

public class bk_2217 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int []ropes = new int[N];
		
		for(int i=0;i<N;i++) {
			ropes[i] = sc.nextInt();
		}
		
		Arrays.sort(ropes);
		
		int result=-1;
		for (int i = 0; i <N; i++) {
            result=Math.max(result, ropes[i]*(N-i));
        }
		System.out.println(result);
		sc.close();
	}

}
