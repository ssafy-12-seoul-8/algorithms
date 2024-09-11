import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		cnt = 0;
		for (int i = 0; i < n / 2; i++) {
			nQueen(1, 1 << i << 1, 1 << i, 1 << i >> 1);
		}
		cnt *= 2;
		if (n % 2 == 1) {
			nQueen(1, 1 << n / 2 << 1, 1 << n / 2, 1 << n / 2 >> 1);
		}

		System.out.println(cnt);
	}

	// bit에는 이번에 못놓는 곳이 표시된다
	static void nQueen(int depth, int leftBit, int midBit, int rightBit) {
		if (depth == n) {
			cnt++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (isValid(i, leftBit, midBit, rightBit)) {
				nQueen(depth + 1, (leftBit | 1 << i) << 1, midBit | 1 << i, (rightBit | 1 << i) >> 1);
			}
		}
	}

	static boolean isValid(int shift, int leftBit, int midBit, int rightBit) {
		if (((1 << shift) & leftBit) != 0) {
			return false;
		}
		if (((1 << shift) & midBit) != 0) {
			return false;
		}
		if (((1 << shift) & rightBit) != 0) {
			return false;
		}
		return true;
	}
}
