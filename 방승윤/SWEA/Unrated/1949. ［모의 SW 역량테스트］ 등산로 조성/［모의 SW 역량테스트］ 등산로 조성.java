import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N, K, maxH, maxD;
	static int[][] mountain;
	static boolean[][] visited;
 
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			maxH = 0;
			maxD = 0;
			mountain = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					mountain[i][j] = Integer.parseInt(st.nextToken());
					maxH = Math.max(mountain[i][j], maxH);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mountain[i][j] == maxH) {
						path(i, j, 1, true);
					}
				}
			}
			
			
			sb.append("#").append(tc).append(" ").append(maxD).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	static void path (int r, int c, int dist, boolean active) {
		
		if (dist > maxD) {
			maxD = dist;
		}
		
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];			
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
				if (mountain[r][c] > mountain[nr][nc]) {
					path(nr, nc, dist + 1, active);
				} else if (active && mountain[r][c] > mountain[nr][nc] - K) {
					int temp = mountain[nr][nc];
					mountain[nr][nc] = mountain[r][c] - 1;
					path(nr, nc, dist + 1, false);
					mountain[nr][nc] = temp;
				}
			}
		}
		
		visited[r][c] = false;
		
	}

}