import java.util.*;
import java.io.*;

public class Solution {
	static int[][] items;
	static boolean[] sel;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			result = 0;
			items = new int[N][2];
			sel = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int flavor = Integer.parseInt(st.nextToken());
				int calories = Integer.parseInt(st.nextToken());
				
				items[i][0] = flavor;
				items[i][1] = calories;
			}
			
			powerset(N, 0, L);
			
			System.out.printf("#%d %s\n", test_case, result);
		}
	}
	
	static void powerset(int n, int k, int l) {
		if(n == k) {
			int totalFlavor = 0;
			int totalCalories = 0;
			
			for(int i = 0; i < n; i++) {
				if(sel[i] == true) {
					totalFlavor += items[i][0];
					totalCalories += items[i][1];
				}
			}
			
			if(totalCalories <= l) {
				result = Math.max(totalFlavor, result);
			}
			return;
		}
		
		sel[k] = false;
		powerset(n, k + 1, l);
		
		sel[k] = true;
		powerset(n, k + 1, l);
	}
}
