import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coin = new int[n];
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[k + 1];
		Arrays.fill(dp, 10001);
		dp[0] = 0;

		for (int i = 1; i <= k; i++) { // 금액
			for (int j = 0; j < n; j++) { // coin의 인덱스
				if (i >= coin[j]) {
					dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
				}
			}
		}

		System.out.println(dp[k] == 10001 ? -1 : dp[k]);
	}
}
