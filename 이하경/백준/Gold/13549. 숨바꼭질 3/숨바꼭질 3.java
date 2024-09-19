import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println(n - k);
            return;
        }

        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            dp[i] = n - i;
        }
        for (int i = n + 1; i <= k; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i >> 1]); // i는 1 이상
            }
            dp[i] = Math.min(dp[i], dp[(i - 1) >> 1] + 1);
            dp[i] = Math.min(dp[i], dp[(i + 1) >> 1] + 1);
        }
        System.out.println(dp[k]);
    }
}
