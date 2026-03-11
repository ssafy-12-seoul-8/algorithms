import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] isComposite = new boolean[N + 1];
		isComposite[0] = true;
		isComposite[1] = true;
		int cnt = N - 1;

		for (int i = 2; i * i <= N; i++) {
			if (isComposite[i]) {
				continue;
			}

			for (int j = i * i; j <= N; j += i) {
				if (!isComposite[j]) {
					isComposite[j] = true;
					cnt--;
				}
			}
		}

		int[] arr = new int[cnt];
		int idx = 0;

		for (int i = 0; i <= N; i++) {
			if (!isComposite[i]) {
				arr[idx++] = i;
			}
		}

		int L = 0;
		int R = 0;
		int sum = 2;
		int ans = 0;

		while (true) {
			if (sum == N) {
				ans++;
			}

			if (sum >= N) {
				if (L == cnt) {
					break;
				}
				
				sum -= arr[L++];
			} else {
				R++;

				if (R == cnt) {
					break;
				}

				sum += arr[R];
			}
		}

		System.out.println(ans);
	}
}
