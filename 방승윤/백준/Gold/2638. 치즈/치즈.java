import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] field = new int[N][M];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		field[0][0] = -1;
		int ans = 0;

		while (!queue.isEmpty()) {
			while (!queue.isEmpty()) {
				int[] cur = queue.poll();
				field[cur[0]][cur[1]] = -1;

				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];

					if (nx < 0 || nx >= N || ny < 0 || ny >= M || field[nx][ny] != 0) {
						continue;
					}

					field[nx][ny] = -1;
					queue.add(new int[] {nx, ny});
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (field[i][j] != 1) {
						continue;
					}

					int edge = 0;

					for (int d = 0; d < 4; d++) {
						if (field[i + dx[d]][j + dy[d]] == -1) {
							edge++;
						}
					}

					if (edge >= 2) {
						field[i][j] = 0;
						queue.add(new int[] {i, j});
					}
				}
			}

			ans++;
		}

		System.out.println(ans - 1);
	}
}
