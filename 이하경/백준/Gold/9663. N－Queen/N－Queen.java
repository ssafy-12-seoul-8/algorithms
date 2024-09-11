import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n, cnt;
	static int[] queen;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		cnt = 0;
		queen = new int[n];
		for (int i = 0; i < n / 2; i++) {
			queen[0] = i;
			nQueen(1);
		}
		cnt *= 2;
		if (n % 2 == 1) {
			queen[0] = n / 2;
			nQueen(1);
		}

		System.out.println(cnt);
	}

	static void nQueen(int depth) {
		if (depth == n) {
			cnt++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isValid(depth, i)) {
				queen[depth] = i;
				nQueen(depth + 1);
			}
		}
	}

	static boolean isValid(int d, int c) {
		for (int i = 0; i < d; i++) {
			if (queen[i] == c) {
				return false;
			}
			if (Math.abs(c - queen[i]) == d - i) {
				return false;
			}
		}
		return true;
	}
}
