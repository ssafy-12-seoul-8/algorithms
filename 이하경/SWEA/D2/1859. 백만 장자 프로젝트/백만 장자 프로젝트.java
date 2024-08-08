import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			// 2 <= n <= 1,000,000
			int n = Integer.parseInt(br.readLine());
			
			// 매매가 <= 10,000
			// 하루에 최대 9,999 이득이고, 1,000,000개니까
			// 9,999,000,000
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = arr[n - 1];
			long cnt = 0;
			for (int i = n - 2; i >= 0; i--) {
				int now = arr[i];
				// 미래에 오를 예정이면 사준다
				if (now < max) {
					// 고점 가격에서 현재가격을 뺀 만큼 이득
					cnt += (max - now);
				} else {
					max = now;
				}
			}
			
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);

	}

}