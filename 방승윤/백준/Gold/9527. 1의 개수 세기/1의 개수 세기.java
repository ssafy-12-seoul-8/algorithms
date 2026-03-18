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
		int n = 0;
		long cnt = 1;

		while (num > 1) {
			n++;
			num >>= 1;
			cnt *= 2;
		}

		cnt = n * cnt / 2 + 1;

		while (n != 0) {
			num *= 2;
			n--;
		}
		
		x -= num;

		return cnt + x + solve(x);
	}
}
