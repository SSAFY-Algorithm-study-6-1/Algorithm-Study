package week2.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	static int check[] = new int[100001];//위치 범위
	static int N,K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		
		if(N>=K) {//K위치가 N보다 작거나 같다면 +-1이동
			System.out.println(N-K);
		}else
			move(N);
	}
	private static void move(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		check[num]=1;//N의 위치를 1로 초기화
		
		while (!q.isEmpty()) {//큐가 빌 때까지 반복
			int qNum=q.poll();
			for (int i = 0; i < 3; i++) {//이동 경우,+1,-1,*2.
				int next;
				if(i==0) next=qNum+1;
				else if(i==1) next=qNum-1;
				else next=qNum*2;
				
				if(next ==K) {
					System.out.println(check[qNum]);
					return;
				}
				if(next >=0 && next<check.length&&check[next]==0) { //범위체크
					q.add(next);
					check[next] = check[qNum]+1;
				}
			}
			
		}
		
	}

}
