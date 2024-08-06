import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int result = 0;
			int testNumber = sc.nextInt();
			int value = sc.nextInt();
			int repeatIndex = sc.nextInt();
			
			result = repeatTimes(value, repeatIndex);
			
			System.out.printf("#%d %d\n", testNumber, result);
		}
		
		sc.close();
	}
	
	
	static int repeatTimes(int value, int repeatIndex) {
		if(repeatIndex == 1) {
			return value;
		}
		return value * repeatTimes(value, repeatIndex - 1);
	}
}