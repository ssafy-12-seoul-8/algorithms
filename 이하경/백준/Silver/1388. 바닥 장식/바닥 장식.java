import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] floor = new char[n][m];

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			floor[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (floor[i][j] == '-') {
					if (j == 0 || floor[i][j - 1] != '-') {
						cnt++;
					}
					continue;
				}

				if (floor[i][j] == '|') {
					if (i == 0 || floor[i - 1][j] != '|') {
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);
	}
}
