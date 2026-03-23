import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] profit = new int[m][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for (int j = 0; j < m; j++) {
                profit[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dp = new int[n + 1];
        int[][] prevs = new int[m][n + 1]; // 총 j원 투자했을때 i번 기업에 투자한 금액

        for (int i = 0; i < m; i++) {
            for (int j = n; j >= 0; j--) {
                for (int k = 1; k <= n; k++) {
                    if (j < k) {
                        break;
                    }
                    if (dp[j] < dp[j - k] + profit[i][k]) {
                        dp[j] = dp[j - k] + profit[i][k];
                        prevs[i][j] = k;
                    }
                }
            }
        }

        sb.append(dp[n]).append("\n");

        int cost = n;
        int company = m - 1;
        int[] ans = new int[m];
        while (company >= 0) {
            ans[company] = prevs[company][cost];
            cost -= prevs[company][cost];
            company -= 1;
        }

        for (int i : ans) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
