import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n % 2 == 1) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n / 2 + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i - 1];
            for (int j = 0; j < i; j++) {
                dp[i] += 2 * dp[j];
            }
        }

        System.out.println(dp[dp.length - 1]);

    }
}
