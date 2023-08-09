
package w3rd;
/**
 * N : 수빈이 현재 점
 * K : 동생의 점 
 * 1초 경과 마다
 * 		걷는다면 X-1 or X+1
 * 		순간이동하면 2*X
 * 
 * input : N, K 
 * output : N to K의 최소 시간
 * 
 * 1. N,K 중 큰 것과 작은 것을 구별
 * 2. 재귀 (구현부) - 짝수라면  /2
 * 		         - 홀수라면  +1 or -1
 * 		  (기저조건) 도작점에 도달했을 경우
 * 
 * 예)
5 17
 * 4
 * 
 * @author SSAFY
 *
 */

import java.util.*;
import java.io.*;

public class BOJ_1697_숨바꼭질 {
	
	static int start;
	static int end;
	static int minTime = Integer.MAX_VALUE;
	static int[] visited;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		start = Integer.parseInt(input[0]);
		end = Integer.parseInt(input[1]);
		int MAX = 100001;
		visited = new int[MAX];      // bfs의 depth를 기록 (초 cnt == depth) 
		
//		calc(start,0);
		
		// bfs
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		int x;
		int size;
		int depth=0;
		k : while(!q.isEmpty()) {
			size = q.size();
			
			for(int i=0;i<size;i++) {
				x = q.poll();
				visited[x] = depth;
				if(x == end) {
					System.out.println(depth);
					break k;
				}
				if(x-1>=0 &&visited[x-1]==0) {
					q.offer(x-1);
					visited[x-1]=depth;

				}
				if(x+1<MAX &&visited[x+1]==0) {
					q.offer(x+1);
					visited[x+1]=depth;
				}
				if(x*2<MAX &&visited[x*2]==0) {
					q.offer(x*2);
					visited[x*2]=depth;

				}
			}
			++depth;

			
		}
				
		
		//
				
	}
//	private static void calc(int num, int cnt) {
//
//		if(cnt+1>minTime)return;
//		if(cnt==minTime) {
//			minTime = Math.min(minTime, cnt);
//			return;
//		}
//		
//		calc(num+1,cnt+1);
//		calc(num-1,cnt+1);
//		calc(num*2,cnt+1);
//	}
}
