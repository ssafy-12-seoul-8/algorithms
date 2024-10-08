import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[41];
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		
		for (int i = 3; i <= 40; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			if (N == 0) {
				sb.append("1 0\n");
				continue;
			} else if (N == 1) {
				sb.append("0 1\n");
				continue;
			}
			
			sb.append(dp[N - 1]).append(" ").append(dp[N]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}