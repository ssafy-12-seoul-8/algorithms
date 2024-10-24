import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int X = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[][] dp = new int[X + 1][5];

		for (int i = 1; i <= A && i <= X; i++) {
			dp[i][0] = i;
			dp[i][4] = i;
		}

		for (int i = A + 1; i <= B * 5 + A && i <= X; i++) {
			if (i < 5) {
				continue;
			} else {
				dp[i][0] = dp[i - 5][0];
				dp[i][1] = dp[i - 5][1] + 1;
				dp[i][4] = dp[i - 5][4] + 1;
			}
		}

		for (int i = B * 5 + A + 1; i <= C * 10 + B * 5 + A && i <= X; i++) {
			if (i < 10) {
				continue;
			} else {
				dp[i][0] = dp[i - 10][0];
				dp[i][1] = dp[i - 10][1];
				dp[i][2] = dp[i - 10][2] + 1;
				dp[i][4] = dp[i - 10][4] + 1;
			}
		}

		for (int i = 25; i <= D * 25 + C * 10 + B * 5 + A && i <= X; i++) {
			if (dp[i][4] < dp[i - 25][4] + 1) {
				dp[i][0] = dp[i - 25][0];
				dp[i][1] = dp[i - 25][1];
				dp[i][2] = dp[i - 25][2];
				dp[i][3] = dp[i - 25][3] + 1;
				dp[i][4] = dp[i - 25][4] + 1;
			}
		}

		int x = dp[X][0] + dp[X][1] * 5 + dp[X][2] * 10 + dp[X][3] * 25;

		if (x == X) {
			sb.append(dp[X][0]).append(" ").append(dp[X][1]).append(" ").append(dp[X][2]).append(" ").append(dp[X][3]);
		} else {
			sb.append("0 0 0 0");
		}

		System.out.println(sb);

	}

}