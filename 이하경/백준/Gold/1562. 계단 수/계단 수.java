import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int DIV = 1_000_000_000;
        int[][][] dp = new int[n][10][4]; // 0, 9 포함여부를 세번째에 저장
        for (int i = 1; i < 9; i++) {
            dp[0][i][0] = 1;
        }
        dp[0][9][2] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 9; j++) {
                dp[i][j][0] = (dp[i - 1][j - 1][0] + dp[i - 1][j + 1][0]) % DIV;
                dp[i][j][1] = (dp[i - 1][j - 1][1] + dp[i - 1][j + 1][1]) % DIV;
                dp[i][j][2] = (dp[i - 1][j - 1][2] + dp[i - 1][j + 1][2]) % DIV;
                dp[i][j][3] = (dp[i - 1][j - 1][3] + dp[i - 1][j + 1][3]) % DIV;
            }

            dp[i][0][1] = (dp[i - 1][1][0] + dp[i - 1][1][1]) % DIV;
            dp[i][0][3] = (dp[i - 1][1][2] + dp[i - 1][1][3]) % DIV;
            dp[i][9][2] = (dp[i - 1][8][0] + dp[i - 1][8][2]) % DIV;
            dp[i][9][3] = (dp[i - 1][8][1] + dp[i - 1][8][3]) % DIV;
        }

        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += dp[n - 1][i][3];
            ans %= DIV;
        }

        System.out.println(ans);
    }
}
