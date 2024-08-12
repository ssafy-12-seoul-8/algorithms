import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int w = 0;
	static int b = 0;
	static char[][] field;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		field = new char[m][n];
		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				field[i][j] = input.charAt(j);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (field[i][j] != '0') {
					bfs(new int[] { i, j }, field[i][j]);
				}
			}
		}
		System.out.println(w + " " + b);
	}

	public static void bfs(int[] start, char color) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		int cnt = 1;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			field[cur[0]][cur[1]] = '0';
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx >= 0 && nx < m && ny >= 0 && ny < n && field[nx][ny] == color) {
					field[nx][ny] = '0';
					q.offer(new int[] { nx, ny });
					cnt++;
				}
			}
		}

		if (color == 'W') {
			w += cnt * cnt;
		} else {
			b += cnt * cnt;
		}
	}
}
