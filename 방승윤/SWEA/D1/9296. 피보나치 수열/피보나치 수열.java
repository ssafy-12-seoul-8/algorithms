import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static int[] memo;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 0; tc < 5; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			memo = new int[N + 1];
			
			System.out.println(fibo(N));
			
		}
		
	}

	static int fibo(int num) {
	
		if (num <= 1) {
			memo[num] = num;
		} else if (memo[num] == 0){
			memo[num] = fibo(num - 1) + fibo(num - 2);
		}
		return memo[num];
		
	}
	
}
