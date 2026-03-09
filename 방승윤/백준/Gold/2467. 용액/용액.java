import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int L = 0;
		int R = N - 1;
		int[] ans = new int[2];
		int min = Integer.MAX_VALUE;

		while (min != 0 && L < R) {
			int sum = arr[L] + arr[R];

			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				ans[0] = arr[L];
				ans[1] = arr[R];
			}

			if (sum < 0) {
				L++;
			} else {
				R--;
			}
		}

		System.out.println(ans[0] + " " + ans[1]);
	}
}
