import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][][] arr = new int[3][N + 1][3];
		int[] color = new int[3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			color[0] = Integer.parseInt(st.nextToken());
			color[1] = Integer.parseInt(st.nextToken());
			color[2] = Integer.parseInt(st.nextToken());

			for (int j = 0; j < 3; j++) {
				if (i == 1) {
					Arrays.fill(arr[j][1], 100_000_000);
					arr[j][1][j] = color[j];
					continue;
				}

				for (int k = 0; k < 3; k++) {
					if (i == N && j == k) {
						arr[k][i][j] = 100_000_000;
						continue;
					}

					arr[k][i][j] = Math.min(arr[k][i - 1][(j + 1) % 3], arr[k][i - 1][(j + 2) % 3]) + color[j];
				}
			}
		}

		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ans = Math.min(ans, arr[i][N][j]);
			}
		}

		System.out.println(ans);
	}
}
