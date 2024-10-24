import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static BigInteger two = new BigInteger("2");
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 2의 100제곱을 어떻게 출력할까? long은 2의 60제곱정도
		// double은 매우 큰 숫자에 대해 얼마나 정밀한가?
		System.out.println(two.pow(n).subtract(new BigInteger("1")));

		if (n <= 20) {
			hanoi(n, 1, 3, 2);
			System.out.println(sb);
		}
	}

	public static void hanoi(int n, int from, int to, int tmp) {
		if (n == 1) {
			sb.append(from).append(" ").append(to).append("\n");
			return;
		}

		hanoi(n - 1, from, tmp, to);
		sb.append(from).append(" ").append(to).append("\n");
		hanoi(n - 1, tmp, to, from);
	}
}
