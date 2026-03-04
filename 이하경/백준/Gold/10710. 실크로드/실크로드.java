import javax.xml.transform.Source;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] d = new int[n];
        int[] c = new int[m];

        for (int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            c[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 1_000_000_000);
            dp[i][0] = 0;
        }

        dp[0][0] = 0;
        for (int j = 1; j <= n; j++) {
            for (int i = j; i <= m; i++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1] + c[i - 1] * d[j - 1]);
            }
        }

        System.out.println(dp[m][n]);
    }
}
