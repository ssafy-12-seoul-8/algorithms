import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int D = Integer.parseInt(br.readLine());
		long[] dp = new long[8];
		dp[0] = 1;

		for (int i = 1; i <= D; i++) {
			long a = dp[0];
			long b = dp[1];
			long c = dp[2];
			long d = dp[3];
			long e = dp[4];
			long f = dp[5];
			long g = dp[6];
			long h = dp[7];
			dp[0] = (b + c) % MOD;
			dp[1] = (a + c + d) % MOD;
			dp[2] = (a + b + d + e) % MOD;
			dp[3] = (b + c + e + f) % MOD;
			dp[4] = (c + d + f + g) % MOD;
			dp[5] = (d + e + h) % MOD;
			dp[6] = (e + h) % MOD;
			dp[7] = (f + g) % MOD;
		}

		System.out.println(dp[0]);
	}
}