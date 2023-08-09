package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질 {

    static int[] location;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int answer = 0;	//정답 출력용 변수, n = k 일때 이동이 0이므로 그대로 출력

        if(n > k) {
            answer = n - k;
        }else if(n < k) {
            location = new int[2 * k + 1];

            bfs(n, k);
            answer = location[k];
        }

        System.out.println(answer);
        sc.close();
    }

    //bfs 사용
    //시작점 좌표를 queue에 넣고 시작점에서 이동할 수 있는 모든 좌표 주기
    //이동 후 좌표에서 다시 이동할 수 있는 모든 좌표 정보를 다시 queue에 넣기
    //queue 빌때까지 반복
    static void bfs(int n, int k) {
        int[] a = location;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            int front = current - 1;
            int back = current + 1;
            int twice = 2 * current;


            if(front >= 1 && location[front] == 0) {
                location[front] =  location[current] + 1;
                queue.add(front);
            }
            if(back <= k && location[back] == 0) {
                location[back] =  location[current] + 1;
                queue.add(back);
            }
            if(twice <= 2 *k && location[twice] == 0) {
                location[twice] =  location[current] + 1;
                queue.add(twice);
            }
            //만약 k값이 나왔으면 종료
            if(front == k || back == k || twice == k)   return;
        }
    }

}
