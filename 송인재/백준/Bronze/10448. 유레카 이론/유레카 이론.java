import java.io.*;

public class Main {
	
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(br.readLine());
			
			combination(number, 1, 3, 0);
			System.out.println(result);
			
			result = 0;
		}
	}
	
	static void combination(int n, int index, int left, int sum) {
		if (result == 1) {
			return;
		}
		
		if (left == 0) {
			if (sum == n) {
				result = 1;
			}
			
			return;
		}
		
		for (int i = 1; i < n; i++) {
			int t = i * (i + 1) / 2;
			
			if (t >= n) {
				return;
			}
			
			combination(n, i, left - 1, sum + t);
		}
	}
	
}