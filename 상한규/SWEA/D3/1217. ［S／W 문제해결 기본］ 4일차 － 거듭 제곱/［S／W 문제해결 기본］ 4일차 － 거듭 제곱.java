import java.util.Scanner;

public class Solution {
	static int result, count;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			sc.nextInt();
			int number = sc.nextInt();
			count = sc.nextInt();
			result = 1;
			times(number, 0);
			
			System.out.printf("#%d %d\n", test_case, result);
		}
		
		sc.close();
	}
	
	static void times(int number, int current) {
		if(current >= count) {
			return;
		} else {
			result *= number;
			times(number, ++current);
		}
	}
}
