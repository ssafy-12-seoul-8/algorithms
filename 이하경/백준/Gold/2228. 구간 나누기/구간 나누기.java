import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[n + 1][m + 1]; // i까지 j개 구간 있을때 최댓값
        int MIN = -32768 * 100;
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], MIN);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
            dp[i][1] = arr[i];
            for (int j = 1; j <= m; j++) {
                int max = Math.max(dp[i][j], dp[i - 1][j]); // i번 포함 안하는 경우
                for (int k = i - 2; k >= 0; k--) {
                    if (dp[k][j - 1] == MIN) {
                        break;
                    }
                    max = Math.max(max, dp[k][j - 1] + (arr[i] - arr[k + 1]));
                }
                dp[i][j] = max;
            }
        }

        System.out.println(dp[n][m]);
    }
}
