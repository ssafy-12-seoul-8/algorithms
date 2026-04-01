import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int DIV = 1_000_000_003;

        long[][][] dp = new long[2][n][k + 1];

        dp[0][0][0] = 1;
        dp[0][1][1] = 1;
        dp[0][1][0] = 1;

        dp[1][0][1] = 1;
        dp[1][1][1] = 1;

        for (int i = 2; i < n; i++) {
            dp[0][i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[0][i][j] = (dp[0][i - 1][j] + dp[0][i - 2][j - 1]) % DIV;
                dp[1][i][j] = (dp[1][i - 1][j] + dp[1][i - 2][j - 1]) % DIV;
            }
        }

        System.out.println((dp[0][n - 1][k] + dp[1][n - 2][k]) % DIV);
    }
}
