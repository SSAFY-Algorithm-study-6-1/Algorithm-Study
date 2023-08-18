package baekjoon;

import java.util.Scanner;
public class BOJ_9663_NQueen {
    static int N, ans;
    static int[] column;
    static boolean visited[];   //각 행에 column 사용 확인

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        column = new int[N];
        visited = new boolean[N];
        nQuenn(0);

        System.out.println(ans);
        sc.close();
    }

    private static void nQuenn(int row){
        if(row == N){
            ans++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if(!visited[col] && checkCross(row, col)){
                column[row] = col;
                visited[col] = !visited[col];
                nQuenn(row + 1);
                visited[col] = !visited[col];
            }

        }

    }

    private static boolean checkCross(int row, int col){
        for (int bRow = 0; bRow < row; bRow++) {
            if(row + col == column[bRow] + bRow || row - col == bRow - column[bRow])
                return false;
        }
        return true;
    }

}
