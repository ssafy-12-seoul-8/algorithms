import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][][] dp = new int[2][5][5];

		for (int i = 0; i < 5; i++) {
			Arrays.fill(dp[1][i], 100_000_000);
		}

		dp[1][0][0] = 0;
		int cur = 0;

		while (true) {
			cur %= 2;
			int prev = (cur + 1) % 2;
			int command = Integer.parseInt(st.nextToken());

			if (command == 0) {
				break;
			}

			for (int i = 0; i < 5; i++) {
				Arrays.fill(dp[cur][i], 100_000_000);
			}

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (dp[prev][i][j] == 100_000_000) {
						continue;
					}

					dp[cur][command][j] = Math.min(dp[cur][command][j], dp[prev][i][j] + cost(i, command));
					dp[cur][i][command] = Math.min(dp[cur][i][command], dp[prev][i][j] + cost(j, command));
				}
			}

			cur++;
		}

		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				ans = Math.min(ans, dp[(cur + 1) % 2][i][j]);
			}
		}

		System.out.println(ans);
	}

	static int cost(int prev, int command) {
		if (prev == command) {
			return 1;
		}

		if (prev == 0) {
			return 2;
		}

		if (Math.abs(prev - command) == 2) {
			return 4;
		}

		return 3;
	}
}
