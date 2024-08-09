import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			long result = 0;
			int N = Integer.parseInt(br.readLine());
			int[] price = new int[N];
			int[] max = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				price[j] = Integer.parseInt(st.nextToken());
			}
			
			max[N - 1] = price[N - 1];
			
			for(int j = N - 2; j >= 0; j--) {
				max[j] = Math.max(max[j + 1], price[j]);
			}
			
			for(int j = 0; j < N; j++) {
				result += max[j] - price[j];
			}
			
			System.out.printf("#%d %d\n", i + 1, result);
		}
	}
}