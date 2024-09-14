import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] price = new int[4];
	static int[][] month = new int[12][2];
	static int cost;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 12; i++) {
				month[i][0] = Integer.parseInt(st.nextToken());
				month[i][1] = Math.min(price[0] * month[i][0], price[1]);
				cost += month[i][1];
			}
			
			findMin(0, 0);
			
			sb.append("#").append(tc).append(" ").append(cost).append("\n");
			
			cost = 0;
			
		}
		
		System.out.println(sb);
		
	}
	
	static void findMin(int idx, int sum) {
		
		if (sum > cost) {
			return;
		}
		
		if (idx >= 12) {
			cost = Math.min(cost, sum);
			return;
		}
		
		if (month[idx][0] == 0) {
			findMin(idx + 1, sum);			
		} else {
			findMin(idx + 1, sum + month[idx][1]);
			findMin(idx + 3, sum + price[2]);
			findMin(idx + 12, sum + price[3]);
		} 
		
	}
	
}