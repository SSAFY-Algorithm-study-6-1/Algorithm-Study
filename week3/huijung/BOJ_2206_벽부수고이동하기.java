package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
    static int n, m;
    static int[][] map;

    static int dr[] = { -1, 0, 1, 0 };
    static int dc[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {

        // 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        // 방문 체크 배열
        // 벽 부수기 가능일떄와 벽 부수기 불가능일때의 경우가 있기 때문에 3차원 배열로 나누어줌

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), "");
            String input[] = st.nextToken().split("");
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(input[j]);
        }
        /////////////////////

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        int cnt = 0;
        int[] location = new int[3];
        map[0][0] = -2;	//시작 지점 초기화(방문 체크), -2 초기화한 이유는 아래 설명됨.

        // queue에 row, col, 벽을 부쉈는지 확인하는 flag값을 배열 형태로 넣는다.
        queue.add(new int[] { 0, 0, 0 });

        // 한 노드에 인접하여 들어간 노드 끼리 그룹으로 묶어주기 위한 변수 => cnt를 층별로 카운트 할 수 있다.
        int queueSize = queue.size();

        // 만약 벽을 부수고 지나갔으면 flag = 1
        while (!queue.isEmpty()) {
            cnt++;

            // 이전값과 인접한 노드들끼리의 연산 진행 후 cnt를 늘려주기 위해 queue 사이즈로 묶어줌
            for (int i = 0; i < queueSize; i++) {
                location = queue.poll();
                int row = location[0];
                int col = location[1];
                int flag = location[2];

                // 끝점 도착시 종료
                if (row == n - 1 && col == m - 1)
                    return cnt;

                // 인접 길 탐색하여 진행 가능하면 queue에 넣기
                for (int d = 0; d < 4; d++) {
                    int nextRow = row + dr[d];
                    int nextCol = col + dc[d];

                    // 지나온 길이 아니면 queue에 넣기
                    // 만약 벽이면 부술 수 있는지 확인 후 진행, 진행 후 벽 부수기를 사용하였다고 표시(flag = 1일때 이미 한번 벽을 부순상태)
                    // 현재 지점이 벽을 부수지 않은 상태여야함

                    // 벽을 부술 수 있는 상태로 지난 칸들이 벽을 부순 후 지난 칸들보다 가중치가 높다.
                    // 벽을 부술 수 있는 상태로 빈 칸을 지나면 -2으로 지정
                    // 벽을 부술 수 없는 상태로 빈 칸을 지나면 -3으로 지정
                    // 0인 칸은 모두 지나감, -2인 칸은 아무도 못지나감, -3인 칸은 벽을 부술 수 있는 상태에서만 지나갈 수 있음
                    // 벽을 부술 수 있는 상태에서 -3인 칸을 지나가게 되면 해당 칸의 값을 -2로 바꿔줌
                    if (checkBoundary(nextRow, nextCol)) {
                        if (map[nextRow][nextCol] == 1 && flag == 0) {
                            queue.add(new int[] { nextRow, nextCol, 1 });
                        }
                        else if (map[nextRow][nextCol] != 1) {
                            //벽을 부수지 않고 지나간 경우를 만나면 continue
                            if(map[nextRow][nextCol] == -2)
                                continue;
                            else if(map[nextRow][nextCol] == -3 && flag == 0) {
                                map[nextRow][nextCol] = -2;
                                queue.add(new int[] { nextRow, nextCol, flag });
                            }else if(map[nextRow][nextCol] == 0) {
                                if(flag == 1) map[nextRow][nextCol] = -3;
                                if(flag == 0) map[nextRow][nextCol] = -2;
                                queue.add(new int[] { nextRow, nextCol, flag });
                            }
                        }
                    }
                }
            }
            // 이전값과 인접한 노드들끼리의 연산 진행 후 cnt를 늘려주기 위해 현재 queue 크기 저장
            queueSize = queue.size();
        }
        // 끝에 도달하지 못했으면 return -1
        return -1;
    }

    // 경계 체크
    static boolean checkBoundary(int row, int col) {
        if (row < n && row >= 0 && col < m && col >= 0)
            return true;
        return false;
    }

}