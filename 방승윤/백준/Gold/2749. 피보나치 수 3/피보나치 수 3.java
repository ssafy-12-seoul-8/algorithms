import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int[] dp = new int[1_500_001];
        dp[1] = 1;

        for (int i = 2; i <= 1_500_000; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1_000_000;
        }

        System.out.println(dp[(int) (n % 1_500_000)]);
    }
}