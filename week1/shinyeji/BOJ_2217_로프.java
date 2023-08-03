import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int c = N;
		int _max = 0;
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		
		for(int i=0;i<N;i++) {
			_max = Math.max(_max,arr[i]*c--);
		}
		System.out.println(_max);
	}

}