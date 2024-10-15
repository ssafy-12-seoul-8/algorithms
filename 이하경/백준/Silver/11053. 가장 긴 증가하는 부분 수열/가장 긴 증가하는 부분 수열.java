
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n]; // i번째 숫자로 끝나는 LIS 길이
		Arrays.fill(dp, 1);
		int max = 1;

		for (int i = 1; i < n; i++) { // dp[i]를 채울거야
			for (int j = 0; j < i; j++) { // 근데 앞에 숫자들을 다 확인하려고
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}
