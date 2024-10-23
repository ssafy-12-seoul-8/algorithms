import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] color = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 3; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dp = new int[3];
		int[] tmp = new int[3];
		
		for (int i = 0; i < N; i++) {
			tmp[0] = Math.min(dp[1] + color[i][0], dp[2] + color[i][0]);
			tmp[1] = Math.min(dp[0] + color[i][1], dp[2] + color[i][1]);
			tmp[2] = Math.min(dp[0] + color[i][2], dp[1] + color[i][2]);
			dp[0] = tmp[0];
			dp[1] = tmp[1];
			dp[2] = tmp[2];
		}
		
		System.out.println(Math.min(dp[0], Math.min(dp[1], dp[2])));
		
	}
	
}