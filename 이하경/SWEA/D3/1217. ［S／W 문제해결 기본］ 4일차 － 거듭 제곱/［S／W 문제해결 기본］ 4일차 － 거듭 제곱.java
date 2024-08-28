import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println("#" + t + " " + pow(n, m));
		}
	}

	static int pow(int n, int m) {
		if (m == 0) {
			return 1;
		}
		if (m == 1) {
			return n;
		}
		if (m % 2 == 0) {
			int tmp = pow(n, m / 2);
			return tmp * tmp;
		}
		int tmp = pow(n, m / 2);
		return tmp * tmp * n;
	}
}

