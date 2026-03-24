import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int h;
	static int w;
	static char[][] building;
	static boolean[] key;
	static Queue<int[]> queue;
	static ArrayList<int[]> entrance;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static boolean[][] visited;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			building = new char[h][];
			entrance = new ArrayList<>();
			visited = new boolean[h][w];
			int cnt = 0;

			for (int i = 0; i < h; i++) {
				building[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (building[i][j] != '*') {
						entrance.add(new int[] {i, j});
					}

					if (i != 0 && i != h - 1 && j != w - 1) {
						j = w - 2;
					}
				}
			}

			String keys = br.readLine();
			key = new boolean[26];

			if (!keys.equals("0")) {
				for (int i = 0; i < keys.length(); i++) {
					key[keys.charAt(i) - 'a'] = true;
				}
			}

			queue = new LinkedList<>();
			enter();

			while (!queue.isEmpty()) {
				int[] location = queue.poll();
				int x = location[0];
				int y = location[1];
				char cur = building[x][y];

				if (cur == '$') {
					cnt++;
					building[x][y] = '.';
				}

				if (cur >= 'a' && cur <= 'z') {
					key[cur - 'a'] = true;
					building[x][y] = '.';
					queue.clear();
					enter();

					for (int i = 0; i < h; i++) {
						Arrays.fill(visited[i], false);
					}
				}

				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx < 0 || nx >= h || ny < 0 || ny >= w || visited[nx][ny]) {
						continue;
					}

					char word = building[nx][ny];

					if (word == '*' || (word >= 'A' && word <= 'Z' && !key[word - 'A'])) {
						continue;
					}

					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}

	static void enter() {
		for (int[] location : entrance) {
			int x = location[0];
			int y = location[1];
			char word = building[x][y];

			if (word >= 'A' && word <= 'Z' && !key[word - 'A']) {
				continue;
			}

			queue.add(location);
			visited[x][y] = true;
		}
	}
}