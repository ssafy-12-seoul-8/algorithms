import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		int[] cnt = new int[2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int interval = N;
		
		while (interval != 0) {
			for (int i = 0; i < N; i += interval) {
				one: for (int j = 0; j < N; j += interval) {
					if (visited[i][j]) {
						continue;
					}
					
					for (int k = 0; k < interval; k++) {
						for (int l = 0; l < interval; l++) {
							if (paper[i + k][j + l] != paper[i][j]) {
								continue one;
							}
						}
					}
					
					for (int k = 0; k < interval; k++) {
						for (int l = 0; l < interval; l++) {
							visited[i + k][j + l] = true;
						}
					}
					
					if (paper[i][j] == 0) {
						cnt[0]++;
					} else {
						cnt[1]++;
					}
				}
			}
			
			interval /= 2;
		}
		
		sb.append(cnt[0]).append("\n").append(cnt[1]);
		
		System.out.println(sb);
		
	}

}