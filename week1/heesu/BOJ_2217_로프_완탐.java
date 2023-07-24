import java.util.*;
import java.io.*;

public class BOJ_2217_로프_완탐{
	static StringTokenizer st;
	static int n, m;
	static ArrayList<Integer> arr = new ArrayList<>();
	static ArrayList<Integer> selected;
	
	static boolean isPossible(int weight, int k, int m) {
		return ((double)weight / k )<= (double)m;
	}
	
	static void choose(int cur,int cnt, int maxCnt) {
		if(cnt == maxCnt) {
			ArrayList<Integer> temp = new ArrayList<>(selected);
			Collections.sort(temp);
			m = temp.get(0);
			
			return;
		}
		
		if(cur == arr.size())
			return;
		
		selected.add(arr.get(cur));
		choose(cur+1, cnt+1, maxCnt);
		selected.remove(selected.size() - 1);
		
		choose(cur+1, cnt, maxCnt);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int weight = Integer.MAX_VALUE;
		for(int i = 0 ;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			arr.add(num);
			weight = Math.min(weight, num);
		}
		
		boolean flag;
		int ans = 0;
		while(true) {
			flag = false;
			for(int k =1; k<=n;k++) {
//				System.out.printf("----%d-----\n", weight);
				selected = new ArrayList<>();
				m = Integer.MAX_VALUE;
				choose(0,0,k);
//				System.out.println(weight+" "+m);
				if(isPossible(weight, k, m)) {
					ans = Math.max(ans, weight);
					flag = true;
				}
			}
			if(!flag)
				break;
			
			weight += 1;
		}
		
		System.out.println(ans);
		
		
	}
}