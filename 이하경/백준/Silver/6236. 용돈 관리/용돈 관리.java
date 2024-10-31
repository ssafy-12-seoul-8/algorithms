import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] budget;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		budget = new int[n];
		for (int i = 0; i < n; i++) {
			budget[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(binarySearch());
	}

	// m번 이내로 꺼내 쓸 수 있는 최소 금액
	public static int binarySearch() {
		int start = 1;
		int end = n * 10000;

		while (start < end) {
			int mid = (start + end) / 2;

			if (canUse(mid)) {
				end = mid;
				continue;
			}
			start = mid + 1;
		}

		return start;
	}

	public static boolean canUse(int mid) {
		int withDrawl = 0;
		int leftMoney = 0;

		for (int i = 0; i < n; i++) {
			if (mid < budget[i]) {
				return false;
			}

			if (leftMoney < budget[i]) {
				withDrawl++;
				leftMoney = mid - budget[i];
				continue;
			}

			leftMoney -= budget[i];
		}

		return withDrawl <= m;
	}
}
