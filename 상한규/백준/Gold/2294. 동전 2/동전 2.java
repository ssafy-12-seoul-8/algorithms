import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[k + 1];
		
		// 0번은 0으로 냅두는게 중요하다!
		for(int i = 1; i < k + 1; i++) {
			dp[i] = Integer.MAX_VALUE - 1;
		}
		
		for(int i = 0; i < n; i++) {
			int value = Integer.parseInt(br.readLine());
			
			for(int j = value; j < k + 1; j++) {
				dp[j] = Math.min(dp[j], dp[j - value] + 1);
			}
		}
		
		System.out.println(dp[k] == Integer.MAX_VALUE - 1 ? -1 : dp[dp.length - 1]);
	}
}
