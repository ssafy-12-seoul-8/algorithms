import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][][] dp = new int[100_001][5][5];
        int[][] move = {{2, 2, 2, 2, 2}, {2, 1, 3, 4, 3}, {2, 3, 1, 3, 4}, {2, 4, 3, 1, 3}, {2, 3, 4, 3, 1}};
        for (int i = 0; i < 100_001; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        int next;
        int i = 1;
        dp[0][0][0] = 0;
        while ((next = Integer.parseInt(st.nextToken())) != 0) {
            // dp[i][?][next]랑 dp[i][next][?]
            for (int j = 0; j < 5; j++) {
                if (j == next) {
                    continue;
                }
                for (int k = 0; k < 5; k++) { // 기존 위치
                    if (dp[i - 1][j][k] < Integer.MAX_VALUE) {
                        dp[i][j][next] = Math.min(dp[i][j][next], dp[i - 1][j][k] + move[k][next]);
                    }
                    if (dp[i - 1][k][j] < Integer.MAX_VALUE) {
                        dp[i][next][j] = Math.min(dp[i][next][j], dp[i - 1][k][j] + move[k][next]);
                    }
                }
            }
//            for (int[]d:dp[i]) {
//                System.out.println(Arrays.toString(d));
//            }
//            System.out.println();
            i++;
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                min = Math.min(min, dp[i - 1][j][k]);
            }
        }

        System.out.println(min);
    }
}
