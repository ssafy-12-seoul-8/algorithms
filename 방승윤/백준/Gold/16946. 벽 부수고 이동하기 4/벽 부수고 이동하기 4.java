import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] field = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();

			for (int j = 0; j < M; j++) {
				field[i][j] = line.charAt(j) - '0';
			}
		}

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int[] block = new int[N * M + 2];

		Queue<int[]> queue = new LinkedList<>();
		int idx = 2;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (field[i][j] != 0) {
					continue;
				}

				queue.add(new int[] {i, j});
				field[i][j] = idx;
				block[idx]++;

				while (!queue.isEmpty()) {
					int[] cur = queue.poll();

					for (int d = 0; d < 4; d++) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];

						if (nx >= 0 && nx < N && ny >= 0 && ny < M && field[nx][ny] == 0) {
							field[nx][ny] = idx;
							block[idx]++;
							queue.add(new int[] {nx, ny});
						}
					}
				}

				idx++;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (field[i][j] != 1) {
					sb.append(0);
					continue;
				}

				HashSet<Integer> hashSet = new HashSet<>();

				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];

					if (nx >= 0 && nx < N && ny >= 0 && ny < M && field[nx][ny] != 0) {
						hashSet.add(field[nx][ny]);
					}
				}

				int cnt = 0;

				for (int num : hashSet) {
					cnt += block[num];
				}

				sb.append((cnt + 1) % 10);
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}
}
