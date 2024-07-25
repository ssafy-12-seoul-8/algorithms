import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int shorter = n < m ? n : m;
			int longer = n < m ? m : n;
			int[] a = new int[shorter];
			int[] b = new int[longer];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				if (shorter == n) {
					a[i] = Integer.parseInt(st.nextToken());
					continue;
				}
				
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < m; i++) {
				if (shorter == n) {
					b[i] = Integer.parseInt(st.nextToken());
					continue;
				}
				
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			
			for (int i = 0; i <= longer - shorter; i++) {
				int temp = 0;
				
				for (int j = 0; j < shorter; j++) {
					temp += a[j] * b[i + j];
				}
				
				max = Math.max(temp, max);
			}
			
			StringBuilder sb = new StringBuilder("#")
					.append(t)
                	.append(" ")
					.append(max)
					.append("\n");
			
			System.out.print(sb);
		}
	}
	
}
