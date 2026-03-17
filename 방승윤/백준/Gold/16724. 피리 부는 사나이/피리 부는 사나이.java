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
		int[][] arr = new int[N][M];
		char[][] dir = new char[N][M];

		for (int i = 0; i < N; i++) {
			dir[i] = br.readLine().toCharArray();
		}

		int idx = 1;
		int ans = 0;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] != 0) {
					continue;
				}

				Queue<int[]> queue = new LinkedList<>();
				queue.add(new int[] {i, j});

				while (!queue.isEmpty()) {
					int[] cur = queue.poll();
					int x = cur[0];
					int y = cur[1];
					arr[x][y] = idx;
					int d = 0;

					switch (dir[x][y]) {
						case 'U':
							break;
						case 'R':
							d = 1;
							break;
						case 'D':
							d = 2;
							break;
						default:
							d = 3;
					}

					int nx = x + dx[d];
					int ny = y + dy[d];

					if (arr[nx][ny] == 0) {
						queue.add(new int[] {nx, ny});
						continue;
					}

					if (arr[nx][ny] == idx) {
						ans++;
					}

					idx++;
				}
			}
		}

		System.out.println(ans);
	}
}
