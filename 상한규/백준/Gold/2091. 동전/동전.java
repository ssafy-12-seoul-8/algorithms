import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());
		// 1 5 10 25
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[][] dp = new int[X + 1][5];
		int[] num = new int[] {1, 5, 10, 25};
		int[] coin = new int[] {A, B, C, D};
		
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		
		for (int i = 0; i <= 4; i++) {
			dp[0][i] = 0;
		}
		
		for (int i = 1; i <= X; i++) {
			for (int j = 0; j < 4; j++) {
				if(dp[i][j]==-1) {
					dp[i][j] = 0;
				}
				
				if (i - num[j] < 0) {
					continue;
				}
				
				if (dp[i - num[j]][4] > dp[i][4]) {				
					if (coin[j] >= (dp[i - num[j]][j] + 1)) {
						for (int k = 0; k < 4; k++) {
							dp[i][k] = dp[i - num[j]][k];
						}
						
						dp[i][4] = dp[i - num[j]][4] + 1;
						dp[i][j] += 1;
					}
				}
			}
		}
		System.out.printf("%d %d %d %d\n", dp[X][0], dp[X][1], dp[X][2], dp[X][3]);
	}
}
