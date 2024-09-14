import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int[] price = new int[4];
			int[][] month = new int[13][2];
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= 12; i++) {
				month[i][0] = Integer.parseInt(st.nextToken());
				month[i][1] = month[i - 1][1] + Math.min(price[0] * month[i][0], price[1]);
				
				if (i >= 3) {
					month[i][1] = Math.min(month[i][1], month[i - 3][1] + price[2]);
				}
				
				if (i == 12) {
					month[i][1] = Math.min(month[i][1], price[3]);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(month[12][1]).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}