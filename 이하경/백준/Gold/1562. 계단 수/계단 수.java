import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int DIV = 1_000_000_000;
        int[][][] dp = new int[n][10][1 << 10];
        for (int i = 1; i <= 9; i++) {
            dp[0][i][1 << i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    if (j < 9) {
                        dp[i + 1][j + 1][k | (1 << (j + 1))] += dp[i][j][k];
                        dp[i + 1][j + 1][k | (1 << (j + 1))] %= DIV;
                    }
                    if (j > 0) {
                        dp[i + 1][j - 1][k | (1 << (j - 1))] += dp[i][j][k];
                        dp[i + 1][j - 1][k | (1 << (j - 1))] %= DIV;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[n - 1][i][(1 << 10) - 1];
            ans %= DIV;
        }

        System.out.println(ans);
    }
}
