import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] room;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		room = new int[n][m]; // 0은 빈 칸 1은 벽

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		out:
		while (true) {
			if (room[r][c] == 0) {
				room[r][c] = -1;
				cnt++;
				continue;
			}
			for (int i = 0; i < 4; i++) {
				d = (d + 3) % 4;
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && room[nr][nc] == 0) {
					r = nr;
					c = nc;
					room[r][c] = -1;
					cnt++;
					continue out;
				}
			}
			int nr = r - dr[d];
			int nc = c - dc[d];
			if (nr >= 0 && nr < n && nc >= 0 && nc < m && room[nr][nc] <= 0) {
				r = nr;
				c = nc;
				continue;
			}
			break;
		}

		System.out.println(cnt);

	}
	
}
