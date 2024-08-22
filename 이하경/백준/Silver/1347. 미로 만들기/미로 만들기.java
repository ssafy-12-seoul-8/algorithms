import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		boolean[][] map = new boolean[2 * n + 1][2 * n + 1]; // 한 방향으로만 n번 간다고 치면 상하좌우 n칸씩 여유 있어야함
		int[] dx = { 1, 0, -1, 0 }; // 하 좌 상 우 순서
		int[] dy = { 0, -1, 0, 1 };
		int x = n, y = n, minX = n, maxX = n, minY = n, maxY = n, dir = 0;

		map[x][y] = true;
		for (int i = 0; i < n; i++) {
			char c = input.charAt(i);
			if (c == 'F') {
				x += dx[dir];
				y += dy[dir];
				map[x][y] = true;
				if (dir == 0) {
					maxX = Math.max(maxX, x);
				} else if (dir == 1) {
					minY = Math.min(minY, y);
				} else if (dir == 2) {
					minX = Math.min(minX, x);
				} else {
					maxY = Math.max(maxY, y);
				}
			} else if (c == 'R') {
				dir = (dir + 1) % 4;
			} else {
				dir = (dir + 3) % 4;
			}
		}
		
		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				sb.append(map[i][j] ? '.' : '#');
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

}
