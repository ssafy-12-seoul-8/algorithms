import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= TC; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[] taste = new int[L + 1];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int T = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());
				
				for (int j = L; j >= K; j--) {
					taste[j] = Math.max(taste[j - K] + T, taste[j]);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(taste[L]).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}