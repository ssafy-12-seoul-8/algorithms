import java.io.BufferedReader;
import java.io.InputStreamReader;

// parametric search로 mid보다 작거나같은 개수가 k개 이상이 되는 최솟값 구하기

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		long start = 0, end = 10_000_000_000L; // 최댓값 n제곱으로 두기
		while (start < end) {
			long mid = (start + end) / 2;

			long cnt = 0; // k는 int 범위이지만 초기 end값 기준으로 개수가 넘을수도?
			for (int i = 1; i <= n; i++) {
				cnt += Math.min(n, mid / i);
			}

			if (cnt >= k) { // mid 에서 가능하면 큰쪽은 볼필요없음
				end = mid;
				continue;
			}

			start = mid + 1;
		}

		System.out.println(start);
	}
}
