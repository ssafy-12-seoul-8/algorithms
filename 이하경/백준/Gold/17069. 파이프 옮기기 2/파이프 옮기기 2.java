import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] house = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][][] dp = new long[n][n][3]; // 가로 0 대각 1 세로 2

        for (int i = 1; i < n; i++) {
            if (house[0][i] == 1) {
                break;
            }
            dp[0][i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if (house[i][j] == 1) {
                    continue;
                }
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];
                dp[i][j][2] = dp[i - 1][j][1] + dp[i - 1][j][2];
                if (house[i - 1][j] == 0 && house[i][j - 1] == 0) {
                    dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }

        System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
    }
}
