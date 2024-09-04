import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] num;
	static int N, min, max;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			num = new int[N];
			st = new StringTokenizer(br.readLine());
			
			int plus = Integer.parseInt(st.nextToken());
			int minus = Integer.parseInt(st.nextToken());
			int multiply = Integer.parseInt(st.nextToken());
			int divide = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken()); 
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			findDiff(0, num[0], plus, minus, multiply, divide);
			
			sb.append("#").append(tc).append(" ").append(max - min).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	static void findDiff(int idx, int curr, int plus, int minus, int multiply, int divide) {
		
		if (idx == N - 1) {
			if (curr > max) {
				max = curr;
			}
			if (curr < min) {
				min = curr;
			}
			return;
		}
		
		if (plus != 0) {
			findDiff(idx + 1, curr + num[idx + 1], plus - 1, minus, multiply, divide);
		}
		
		if (minus != 0) {
			findDiff(idx + 1, curr - num[idx + 1], plus, minus - 1, multiply, divide);
		}
		
		if (multiply != 0) {
			findDiff(idx + 1, curr * num[idx + 1], plus, minus, multiply - 1, divide);
		}
		
		if (divide != 0) {
			findDiff(idx + 1, curr / num[idx + 1], plus, minus, multiply, divide - 1);
		}
		
	}
	
}