import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int L = 1;
		int R = k;
		int ans = 0;

		while (L <= R) {
			int mid = (L + R) / 2;
			int cnt = 0;

			for (int i = 1; i <= N; i++) {
				if (i > mid) {
					break;
				} else if (mid >= (long) i * N) {
					cnt += N;
				} else {
					cnt += mid / i;
				}
			}

			if (cnt >= k) {
				R = mid - 1;
				ans = mid;
			} else if (cnt < k) {
				L = mid + 1;
			}
		}

		System.out.println(ans);

	}

}