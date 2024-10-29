import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] dp = new int[3][n][n]; // 0:가로, 1: 세로, 2: 대각선
		dp[0][0][1] = 1; // 시작은 가로 (1,2)

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// (i,j)에 한쪽 끝을 놓는 경우의 수를 구한다
				if (map[i][j] == 1) {
					continue;
				}
				
				// 가로로 움직이는 경우
				if (j > 0) {
					dp[0][i][j] += dp[0][i][j - 1] + dp[2][i][j - 1];
				}
				
				// 세로로 움직이는 경우
				if (i > 0) {
					dp[1][i][j] += dp[1][i - 1][j] + dp[2][i - 1][j];
				}
				
				// 대각선으로 움직이는 경우
				if (i > 0 && j > 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0) {
					dp[2][i][j] += dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1];
				}
			}
		}

		System.out.println(dp[0][n - 1][n - 1] + dp[1][n - 1][n - 1] + dp[2][n - 1][n - 1]);
	}
}
