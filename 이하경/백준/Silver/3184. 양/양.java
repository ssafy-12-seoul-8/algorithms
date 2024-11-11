import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c, sheep, wolf, tmpSheep, tmpWolf;
	static char[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] != '#') {
					tmpSheep = 0;
					tmpWolf = 0;

					dfs(i, j);

					if (tmpSheep > tmpWolf) {
						sheep += tmpSheep;
					} else {
						wolf += tmpWolf;
					}
				}
			}
		}

		System.out.println(sheep + " " + wolf);
	}

	static void dfs(int i, int j) {
		if (map[i][j] == 'v') {
			tmpWolf++;
		} else if (map[i][j] == 'o') {
			tmpSheep++;
		}

		map[i][j] = '#';

		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];

			if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] != '#') {
				dfs(nx, ny);
			}
		}
	}
}
