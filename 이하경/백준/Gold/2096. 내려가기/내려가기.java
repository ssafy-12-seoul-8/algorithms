import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][3];
        int[][] max = new int[n][3];
        int[][] min = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max[0] = min[0] = board[0];

        for (int i = 1; i < n; i++) {
            max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + board[i][0];
            max[i][1] = Math.max(Math.max(max[i - 1][0], max[i - 1][1]), max[i - 1][2]) + board[i][1];
            max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + board[i][2];

            min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + board[i][0];
            min[i][1] = Math.min(Math.min(min[i - 1][0], min[i - 1][1]), min[i - 1][2]) + board[i][1];
            min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + board[i][2];
        }

        sb.append(Math.max(Math.max(max[n - 1][0], max[n - 1][1]), max[n - 1][2]))
                .append(" ")
                .append(Math.min(Math.min(min[n - 1][0], min[n - 1][1]), min[n - 1][2]));
        System.out.println(sb);
    }
}
