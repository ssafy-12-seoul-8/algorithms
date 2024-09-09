import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, fuel, currR, currC;
	static int[][] map, customer; // customer 에는 출발지와 도착지 저장
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		input();
		solution();
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());

		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		currR = Integer.parseInt(st.nextToken());
		currC = Integer.parseInt(st.nextToken());

		customer = new int[m + 2][4];
		for (int i = 2; i <= m + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				customer[i][j] = Integer.parseInt(st.nextToken());
			}
			map[customer[i][0]][customer[i][1]] = i;
		}

	}

	static void solution() {
		for (int i = 0; i < m; i++) {
			int cust = findCustomer();
			int tmp = taxiDist(cust);
			if (tmp == -1) {
				System.out.println(-1);
				return;
			}
			fuel += tmp; // 손님 태우고 이동하면서 연료 안깐셈치자
		}
		System.out.println(fuel);
	}

	// 최백준의 현재 위치로 가장 가까운 손님 찾아서 인덱스 넘기기. 불가능하면 -1
	// 손님은 찾으면 지도에서 지워드린다
	static int findCustomer() {
		if (map[currR][currC] >= 2) {
			return map[currR][currC];
		}

		boolean[][] visit = new boolean[n + 1][n + 1];
		visit[currR][currC] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { currR, currC, 0 });
		int[] cust = { -1, -1, 400 }; // r, c, dist, idx 순서
		boolean custFound = false;

		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if (curr[2] == fuel - 1) {
				break;
			}
			
			if (curr[2] == cust[2]) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				if (nr > 0 && nr <= n && nc > 0 && nc <= n && map[nr][nc] != 1 && !visit[nr][nc]) {
					visit[nr][nc] = true;
					
					if (custFound) {
						if (map[nr][nc] >= 2) {
							if (nr < cust[0] || (nr == cust[0] && nc < cust[1])) {
								cust = new int[] { nr, nc, curr[2] + 1 };
							}
						}
						continue;
					}
					
					if (map[nr][nc] >= 2) {
						cust = new int[] { nr, nc, curr[2] + 1 };
						custFound = true;
					}
					
					q.add(new int[] { nr, nc, curr[2] + 1 });

				}
			}
		}

		if (!custFound) {
			return -1;
		}

		fuel -= cust[2];
		return map[cust[0]][cust[1]];
	}

	// idx번 손님을 태우고 이동한 거리를 반환. 불가능하면 -1
	static int taxiDist(int idx) {
		if (idx == -1) {
			return -1;
		}

		int r = customer[idx][0];
		int c = customer[idx][1];
		int endR = customer[idx][2];
		int endC = customer[idx][3];
		boolean[][] visit = new boolean[n + 1][n + 1];
		visit[r][c] = true;
		map[r][c] = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c, 0 }); // 행, 열, 거리

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int dist = curr[2];
			
			if (dist == fuel) { // 도착점은 현재거리보다 멀리 있으므로
				return -1;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];

				if (nr > 0 && nr <= n && nc > 0 && nc <= n && map[nr][nc] != 1 && !visit[nr][nc]) {
					if (nr == endR && nc == endC) {
						currR = nr;
						currC = nc;
						return curr[2] + 1;
					}

					visit[nr][nc] = true;
					q.add(new int[] { nr, nc, curr[2] + 1 });
				}
			}
		}

		return -1; // 벽때문에 못움직이는 경우 도달할 수 없다
	}
}
