import java.util.Scanner;

class Solution {
	
	static final int cases = 10;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= cases; t++) {
			int tc = sc.nextInt();
			int base = sc.nextInt();
			int exp = sc.nextInt();
			int powered = pow(base, exp, 1);
			
			System.out.println("#" + tc + " " + powered);
		}
	}
	
	static int pow(int base, int exp, int count) {
		if (count == exp + 1) {
			return 1;
		}
		
		return base * pow(base, exp, count + 1);
	}
	
}