import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		boolean[][] palindrome = new boolean[N + 1][N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = N; i >= 1; i--) {
			for (int j = i; j <= N; j++) {
				if (arr[i] != arr[j]) {
					continue;
				}

				if (i == j) {
					palindrome[i][j] = true;
					continue;
				}

				if (i + 1 == j) {
					palindrome[i][j] = true;
					continue;
				}

				if (palindrome[i + 1][j - 1]) {
					palindrome[i][j] = true;
				}
			}
		}

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			sb.append(palindrome[S][E] ? 1 : 0).append("\n");
		}

		System.out.println(sb);
	}
}