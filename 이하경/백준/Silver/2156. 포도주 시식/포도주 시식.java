import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int[] dp = new int[n + 3]; // 안 마시는 와인 세기
        for (int i = 3; i <= n + 2; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            int min = Math.min(dp[i - 1], dp[i - 2]);
            min = Math.min(min, dp[i - 3]);
            dp[i] = min + num;
        }

        System.out.println(sum - Math.min(dp[n + 2], Math.min(dp[n + 1], dp[n])));
    }
}
