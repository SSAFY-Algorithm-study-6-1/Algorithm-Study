package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4963_섬의_개수 {
    static StringBuilder sb = new StringBuilder();
    static int[][] map;

    static int w, h;

    //델타 이동 배열
    static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st;
        //인근 섬 탐색용 델타 이동 배열
        //


        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            //종료 조건 입력시 break;
            if(w == 0 && h == 0)    break;

            map = new int[h + 2][w + 2];   //padding을 넣어 index에러 방지

            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= w; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            cnt = 2;

            for (int r = 1; r <= h; r++) {
                for (int c = 1; c <= w; c++){
                    if(map[r][c] == 1){
                        dfs(r, c, cnt);
                        cnt++;
                    }
                }
            }

            sb.append(cnt - 2).append("\n");

        }
        System.out.println(sb);
        br.close();
    }

    static void dfs(int row, int col, int islandIdx){
        for (int i = 0; i < 8; i++) {
            int check = map[row + dr[i]][col + dc[i]];// map[r][c]섬과 인접한 땅들 체크용 변수

            map[row][col] = islandIdx;    //현재 섬에 번호 부여
            if(check == 1){
                map[row + dr[i]][col + dc[i]] = islandIdx; //인접 섬도 같은 번호 부여
                dfs(row + dr[i], col + dc[i], islandIdx);  //인접 섬 재귀호출
            }
        }
    }

}
