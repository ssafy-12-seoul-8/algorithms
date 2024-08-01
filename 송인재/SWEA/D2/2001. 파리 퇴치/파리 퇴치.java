import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] rowSum = new int[n][n];
			int[][] flySum = new int[n][n];
			int max = 0;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				rowSum[i][0] = Integer.parseInt(st.nextToken());
				flySum[i][0] = rowSum[i][0];
				
				if (i > 0) {
					flySum[i][0] += flySum[i - 1][0];
				}
				
				if (i >= m) {
					flySum[i][0] -= rowSum[i - m][0];
				}
				
				for (int j = 1; j < n; j++) {
					int num = Integer.parseInt(st.nextToken());
					rowSum[i][j] = rowSum[i][j - 1] + num;
					flySum[i][j] = rowSum[i][j];
					
					if (i == 0) {
						continue;
					}
					
					flySum[i][j] += flySum[i - 1][j];
					
					if (i >= m) {
						flySum[i][j] -= rowSum[i - m][j];
					}
					
					if (i >= m - 1 && j >= m - 1) {
						int tempMax =  flySum[i][j];
						
						if (j >= m) {
							tempMax -= flySum[i][j - m];
						}
						
						max = Math.max(max, tempMax);
					}
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
	
}