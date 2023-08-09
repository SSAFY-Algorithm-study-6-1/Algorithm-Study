package week2.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bk2606_바이러스 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력
		int N=Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int [][]arr = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {//그래프 구성
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b]=arr[b][a]=1;
		}
		//컴퓨터 1 세팅
		Queue<Integer> q = new LinkedList<>();
		boolean [] visit = new boolean[N+1];//방문배열
		q.add(1);
		visit[1]=true;
		//BFS
		int count=0;
		while(!q.isEmpty()) {
			int p=q.poll();
			for (int i = 0; i < M; i++) {//1번과 연결된 컴퓨터 찾아 count 증가
				if(arr[p][i]==1 && !visit[i]) {
					q.add(i);
					visit[i]=true;
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
