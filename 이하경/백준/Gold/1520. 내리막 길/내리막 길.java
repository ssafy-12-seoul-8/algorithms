import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 작은 숫자를 방문하면, 그보다 큰 숫자로는 갈 일이 없다
// 연결된 숫자 중 큰 숫자부터 방문

public class Main {
	static int n, m;
	static int[][] map;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(search());
	}

	static int search() {
		// 큰거부터 나오게
		PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o.height));
		boolean[][] visit = new boolean[m][n];
		visit[0][0] = true;
		pq.add(new Point(0, 0, map[0][0]));

		int[][] cnt = new int[m][n]; // 이 점까지 오는 경로의 개수
		cnt[0][0] = 1;

		while (!pq.isEmpty()) {
			Point curr = pq.poll(); // curr은 갈 수 있는 곳중에 가장 높은곳

			for (int d = 0; d < 4; d++) {
				int nx = curr.x + dx[d];
				int ny = curr.y + dy[d];

				if (nx >= 0 && nx < m && ny >= 0 && ny < n && map[nx][ny] < curr.height) {
					cnt[nx][ny] += cnt[curr.x][curr.y]; // 다음이 더 작으면 경우의 수 더해줌

					if (!visit[nx][ny]) {
						visit[nx][ny] = true;
						pq.add(new Point(nx, ny, map[nx][ny])); // 한 번만 넣기위해 visit처리
					}
				}
			}
		}

		return cnt[m - 1][n - 1];
	}

	static class Point {
		int x, y, height;

		public Point(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}
	}
}
