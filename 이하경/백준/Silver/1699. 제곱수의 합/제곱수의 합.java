import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            int k = 2;
            while (k * k <= i) {
                dp[i] = Math.min(dp[i], dp[i - k * k] + 1);
                k++;
            }
        }

        System.out.println(dp[n]);
    }
}

