import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, l;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (canGo(i, 0)) {
				cnt++;
			}
			if (canGo(i, 1)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	// i는 i번째, d는 0이 행, 1이 열
	static boolean canGo(int idx, int d) {
		if (d == 0) {
			int prev = map[idx][0];
			int cnt = 1;
			for (int i = 1; i < n; i++) {
				if (prev == map[idx][i]) {
					cnt++;
				} else if (prev + 1 == map[idx][i]) {
					if (cnt < l) {
						return false;
					}
					prev = prev + 1;
					cnt = 1;
				} else if (prev - 1 == map[idx][i]) {
					prev = prev - 1;
					cnt = 0;
					for (int k = i + 1; k < i + l; k++) {
						if (k > n - 1 || map[idx][k] != prev) {
							return false;
						}
					}
					i = i + l - 1;
				} else {
					return false;
				}
			}
			return true;
		}
		int prev = map[0][idx];
		int cnt = 1;
		for (int i = 1; i < n; i++) {
			if (prev == map[i][idx]) {
				cnt++;
			} else if (prev + 1 == map[i][idx]) {
				if (cnt < l) {
					return false;
				}
				prev = prev + 1;
				cnt = 1;
			} else if (prev - 1 == map[i][idx]) {
				prev = prev - 1;
				cnt = 0;
				for (int k = i + 1; k < i + l; k++) {
					if (k > n - 1 || map[k][idx] != prev) {
						return false;
					}
				}
				i = i + l - 1;
			} else {
				return false;
			}
		}
		return true;
	}
}
