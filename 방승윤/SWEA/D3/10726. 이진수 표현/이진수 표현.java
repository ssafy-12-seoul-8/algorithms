import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()); 
			String status = "OFF";
			
			while (M != 0) {
				if (M % 2 == 1) {
					if (--N == 0) {
						status = "ON";
						break;
					}
					M /= 2;
				} else {
					break;
				}
			}
			
			sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(status);
			System.out.println(sb);
			
		}
		
	}
	
}
