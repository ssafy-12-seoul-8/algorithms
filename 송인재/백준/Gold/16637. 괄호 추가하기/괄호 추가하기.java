import java.io.*;

public class Main {
	
	static int n;
	static char[] eq;
	static int[] nums;
	static char[] ops;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		eq = br.readLine()
				.toCharArray();
		nums = new int[n / 2 + 1];
		ops = new char[n / 2];
		int numIndex = 0;
		int opIndex = 0;
		
		for (int i = 0; i < n; i++) {
			if (eq[i] >= '0' && eq[i] <= '9') {
				nums[numIndex++] = eq[i] - '0';
				
				continue;
			}
			
			ops[opIndex++] = eq[i];
		}
		
		combination(new boolean[n / 2], 0, 0);
		
		System.out.println(max);
	}
	
	static void combination(boolean[] in, int index, int count) {
		if (count > n / 2) {
			return;
		}
		
		max = Math.max(max, calculateEq(in));
		
		for (int i = index; i < ops.length; i++) {
			in[i] = true;
			
			combination(in, i + 2, count + 1);
			
			in[i] = false;
		}
	}
	
	static int calculateEq(boolean[] in) {
		int sum = nums[0];
		
		for (int i = 0; i < in.length; i++) {
			if (i < in.length - 1 && in[i + 1]) {
				int second = calculate(nums[i + 1], nums[i + 2], ops[i + 1]);
				sum = calculate(sum, second, ops[i]);
				i++;
				
				continue;
			}
			
			sum = calculate(sum, nums[i + 1], ops[i]);
		}
		
		return sum;
	}
	
	static int calculate(int a, int b, char op) {
		switch (op) {
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
		}
		
		return 0;
	}
	
}