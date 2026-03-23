import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][][] dp = new long[N + 1][10][1024];

		for (int i = 1; i <= 9; i++) {
			dp[1][i][1 << i] = 1;
		}

		for (int len = 1; len < N; len++) {
			for (int num = 0; num <= 9; num++) {
				for (int mask = 0; mask < 1024; mask++) {
					if (dp[len][num][mask] == 0) {
						continue;
					}

					if (num > 0) {
						int next = mask | (1 << (num - 1));
						dp[len + 1][num - 1][next] += dp[len][num][mask];
						dp[len + 1][num - 1][next] %= 1_000_000_000;
					}

					if (num < 9) {
						int next = mask | (1 << (num + 1));
						dp[len + 1][num + 1][next] += dp[len][num][mask];
						dp[len + 1][num + 1][next] %= 1_000_000_000;
					}
				}
			}
		}

		long cnt = 0;

		for (int i = 0; i <= 9; i++) {
			cnt += dp[N][i][1023];
			cnt %= 1_000_000_000;
		}

		System.out.println(cnt);
	}
}