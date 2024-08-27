import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, K, cnt;
	static int[] A;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			A = new int[N];
			
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			findTotal(0, 0);
			
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
			cnt = 0;
		}
		System.out.println(sb);
	}
	
	static void findTotal (int idx, int total) {
		if (idx == N) {
			return;
		}
		
		total += A[idx];
		
		if (total == K) {
			cnt++;
		}
		
		idx++;
		
		findTotal(idx, total);
		
		total -= A[--idx];
		idx++;
		
		findTotal(idx, total);
	}
	
}
