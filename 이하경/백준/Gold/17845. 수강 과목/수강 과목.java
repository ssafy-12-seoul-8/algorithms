import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평범한 배낭 문제
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] dp = new int[n + 1]; // dp[i] : 시간 i에서 가질 수 있는 최대 중요도

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());

			int imp = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			for (int i = n; i >= time; i--) {
				dp[i] = Math.max(dp[i], dp[i - time] + imp);
			}
		}

		System.out.println(dp[n]);
	}
}
