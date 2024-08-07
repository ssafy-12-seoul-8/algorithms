import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder()
					.append("#")
					.append(t)
					.append(" ");
			int min = Math.min(n, m);
			int max = Math.max(n, m);
			
			for (int i = min + 1; i <= max + 1; i++) {
				sb.append(i)
					.append(" ");
			}
			
			System.out.println(sb);
		}
	}
	
}