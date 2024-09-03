import java.util.*;
import java.io.*;
 
public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] height = new int[N];
			int max = 0;
			
			for (int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
				if (height[i] > max) {
					max = height[i];
				}
			}
			
			int even = 0;
			int odd = 0;
			
			for (int i = 0; i < N; i++) {
				height[i] = max - height[i];
				even += height[i] / 2;
				odd += height[i] % 2;
			}
			
			if (even > odd + 2) {
				
				int temp = even - odd;
				even -= (temp + 1) / 3;
				odd += (temp + 1) / 3 * 2;
				
			}
			
			int day = even * 2;
			
			if (odd > even) {
				day += (odd - even - 1) * 2 + 1;
			}
			
			sb.append("#").append(tc).append(" ").append(day).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}