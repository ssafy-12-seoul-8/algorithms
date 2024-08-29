import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] seats;
	static boolean[][] picked;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		seats = new char[5][5];
		for (int i = 0; i < 5; i++) {
			seats[i] = br.readLine().toCharArray();
		}

		picked = new boolean[5][5];
		cnt = 0;

		pick(0, 0, 0);
		System.out.println(cnt);
	}

	// n번을 뽑을지말지 결정, k번째 뽑는중
	static void pick(int n, int k, int sCnt) {
		if (k == 7) {
			if (sCnt >= 4 && isNear()) {
				cnt++;
			}
			return;
		}

		if (n >= 25) {
			return;
		}

		// n번은 뽑지 않겠습니다
		pick(n + 1, k, sCnt);

		// n번을 뽑겠습니다
		picked[n / 5][n % 5] = true;
		pick(n + 1, k + 1, seats[n / 5][n % 5] == 'S' ? sCnt + 1 : sCnt);
		picked[n / 5][n % 5] = false;
	}

	static boolean isNear() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visit = new boolean[5][5];

		all: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (picked[i][j]) {
					q.add(new Point(i, j));
					visit[i][j] = true;
					break all;
				}
			}
		}

		int nCnt = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			nCnt++;

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && picked[nx][ny] && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
		}
		return nCnt == 7;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

