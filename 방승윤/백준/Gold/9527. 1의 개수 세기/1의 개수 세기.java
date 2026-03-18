import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		System.out.println(solve(B) - solve(A - 1));
	}

	static long solve(long x) {
		if (x == 0 || x == 1) {
			return x;
		}

		long num = x;
		int n = -1;

		while (num != 0) {
			n++;
			num >>= 1;
		}

		long cnt = n * (long) Math.pow(2, (double) n - 1) + 1;
		x -= (long) Math.pow(2, n);

		return cnt + x + solve(x);
	}
}
