import java.util.*;
import java.io.*;

public class Solution {
	static int[] nums;
	static int N, K, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			nums = new int[N];
			result = 0;
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			
			System.out.printf("#%d %d\n", test_case, result);
		}
	}
	static void combination(int index, int sum) {
		if(sum > K) {
			return;
		}
		if(sum == K) {
			result++;
			return;
		} 	
		for(int i = index; i < N; i++) {
			combination(i + 1, sum + nums[i]);
		}
	}
}
