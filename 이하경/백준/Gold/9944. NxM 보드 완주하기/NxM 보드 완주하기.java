import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int min, space, n, m;
	static int INF = 1_000_001;
	static char[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int tc = 1;
		String input = br.readLine();

		while (input != null && !input.isEmpty()) {
			st = new StringTokenizer(input);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			board = new char[n][m];
			space = 0;
			for (int i = 0; i < n; i++) {
				board[i] = br.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					if (board[i][j] == '.') { // 빈칸의 개수를 센다
						space++;
					}
				}
			}

			min = INF;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (board[i][j] == '.') { // 시작점 정하기
						board[i][j] = '*';
						move(i, j, 0, 1);
						board[i][j] = '.';
					}
				}
			}


			if (min == INF) {
				min = -1;
			}

			sb.append("Case ").append(tc++).append(": ").append(min).append("\n");
			input = br.readLine();
		}

		System.out.println(sb);
	}

	static void move(int x, int y, int move, int cnt) {
		if (move >= min) {
			return;
		}
		
		if (cnt == space) {
			min = move;
			return;
		}
		
		// 사방으로 이동해서 다시 move
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (isValid(nx, ny) && board[nx][ny] == '.') { // 이 방향으로 갈 수 있을때
				int tmpCnt = 0;
				while (isValid(nx, ny) && board[nx][ny] == '.') {
					board[nx][ny] = '*';
					tmpCnt++;
					nx += dx[d];
					ny += dy[d];
				}

				nx -= dx[d];
				ny -= dy[d];

				move(nx, ny, move + 1, cnt + tmpCnt); // 다음 방향으로 가보자!

				while (nx != x || ny != y) {
					board[nx][ny] = '.';
					nx -= dx[d];
					ny -= dy[d];
				}
			}


		}

	}

	static boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}
