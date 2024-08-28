import java.util.Scanner;

public class Solution {
	static int[] arr;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println("#" + t + " " + pow(n, m));
		}

		sc.close();
	}

	static int pow(int n, int m) {
		int ans = 1;
		while (m > 0) {
			if (m % 2 == 1) {
				ans *= n;
			}
			m >>= 1;
			n *= n;
		}
		return ans;
	}

}

