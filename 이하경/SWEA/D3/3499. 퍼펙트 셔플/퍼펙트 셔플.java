import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			String[] cards = br.readLine().split(" ");
			
			sb.append("#").append(t);
			
			for (int i = 0; i < n / 2; i++) {
				sb.append(" ").append(cards[i]);
				sb.append(" ").append(cards[(n + 1) / 2 + i]);
			}
			
			// 홀수면 마지막장 넣어주기
			if (n % 2 == 1) {
				sb.append(" ").append(cards[n / 2]);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

}