import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] row = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                row[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = dp[j] + row[j];
                } else if (j == i) {
                    dp[j] = dp[j - 1] + row[j];
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]) + row[j];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}