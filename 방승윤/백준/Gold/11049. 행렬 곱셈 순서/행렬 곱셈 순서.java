import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] matrix = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			matrix[i][0] = r;
			matrix[i][1] = c;
		}

		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
			arr[i][i] = 0;
		}

		int ans = Integer.MAX_VALUE;

		for (int l = 1; l < N; l++) {
			for (int i = 0; i < N - l; i++) {
				int j = i + l;

				for (int k = i; k < j; k++) {
					arr[i][j] = Math.min(arr[i][k] + arr[k + 1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1],
						arr[i][j]);
				}

				if (l == N - 1) {
					ans = Math.min(ans, arr[i][j]);
				}
			}
		}

		System.out.println(ans);
	}
}
