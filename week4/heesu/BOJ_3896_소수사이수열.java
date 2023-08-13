package samsung;

import java.util.*;
import java.io.*;

public class BOJ_3896_소수사이수열 {
	static int T;
	static StringBuilder sb = new StringBuilder();
	
	static boolean isPrime(int num) {
		if(num <= 1)
			return false;
		
		for(int i = 2; i * i<=num;i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T;i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(isPrime(num))
				sb.append(0).append('\n');
			else {
				int right = num;
				while(!isPrime(right))
					right++;
				int left = num;
				while(!isPrime(left))
					left--;
				sb.append(right-left).append('\n');
			}
			
		}
		System.out.println(sb);

	}

}
