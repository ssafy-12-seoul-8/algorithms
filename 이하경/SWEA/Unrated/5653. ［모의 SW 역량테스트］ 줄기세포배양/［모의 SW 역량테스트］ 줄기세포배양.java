import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			boolean[][] visit = new boolean[n + 2 * k][m + 2 * k];
			PriorityQueue<Cell> q = new PriorityQueue<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					int life = Integer.parseInt(st.nextToken());
					if (life > 0) {
						visit[k + i][k + j] = true;
						q.offer(new Cell(k + i, k + j, life, life));
					}
				}
			}

			int cnt = 0;
			while (!q.isEmpty()) {

				Cell next = q.poll();

				if (next.activeOn >= k) {
					cnt++;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nx = next.x + dx[i];
					int ny = next.y + dy[i];
					if (!visit[nx][ny]) {
						visit[nx][ny] = true;
						// Cell은 next.activeOn 시간에 태어나고
						// next.life시간동안 비활성
						q.offer(new Cell(nx, ny, next.life, next.activeOn + next.life + 1));
					}
				}

				if (next.activeOn + next.life > k) {
					cnt++;
				}
			}

			cnt += q.size();

			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb);

	}

}

class Cell implements Comparable<Cell> {
	int x;
	int y;
	int life;
	int activeOn;

	public Cell(int x, int y, int life, int activeOn) {
		this.x = x;
		this.y = y;
		this.life = life;
		this.activeOn = activeOn;
	}

	@Override
	public int compareTo(Cell o) {
		if (o.activeOn == this.activeOn) {
			return o.life - this.life;
		}
		return this.activeOn - o.activeOn;
	}

	@Override
	public String toString() {
		return x + " " + y + " " + life + "  " + activeOn;
	}
}
