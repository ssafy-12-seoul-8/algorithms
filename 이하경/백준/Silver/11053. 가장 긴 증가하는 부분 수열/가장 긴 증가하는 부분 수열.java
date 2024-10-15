
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] dp = new int[1001]; // i보다 작은 수로로 끝나는 LIS 최대길이
		while (n-- > 0) {
			int a = Integer.parseInt(st.nextToken());
			int tmp = dp[a - 1] + 1;
			for (int i = a; i <= 1000; i++) {
				dp[i] = Math.max(dp[i], tmp);
			}
		}
		
		System.out.println(dp[1000]);

	}
}
