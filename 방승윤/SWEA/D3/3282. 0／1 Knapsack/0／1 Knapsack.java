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
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] goods = new int[N][2];
			int[] value = new int[K + 1];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				goods[i][0] = Integer.parseInt(st.nextToken());
				goods[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = K; j >= goods[i][0]; j--) {
					value[j] = Math.max(goods[i][1] + value[j - goods[i][0]], value[j]);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(value[K]).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}