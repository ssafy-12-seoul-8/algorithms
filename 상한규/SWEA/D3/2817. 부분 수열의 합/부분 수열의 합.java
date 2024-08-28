import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, K, cnt;
	static int[] nums;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			nums = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken()); 
			}
			
			recur(0, 0);
			
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
			
			cnt = 0;
			
		}
		System.out.println(sb);
	}
	
	static void recur(int idx, int total) {
		if (total == K) {
			cnt++;
		}
		
		if (idx == N || total >= K) {
			return;
		}
		
		for (int i = idx; i < N; i++) {
			total += nums[i];
			recur(i + 1, total);
			total -= nums[i];
		}
	}
	
}