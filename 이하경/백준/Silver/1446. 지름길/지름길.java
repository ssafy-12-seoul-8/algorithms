import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, d;
	static ArrayList<int[]> shortcut;

	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		shortcut = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			shortcut.add(new int[] { from, to, len });
		}
	}

	static void solve() {
		int[] dp = new int[d + 1];
		dp[0] = 0;
		for (int i = 1; i <= d; i++) {
			dp[i] = dp[i - 1] + 1;

			for (int[] sc : shortcut) {
				if (sc[1] == i) {
					dp[i] = Math.min(dp[i], dp[sc[0]] + sc[2]);
				}
			}
		}
		System.out.println(dp[d]);
	}
}
