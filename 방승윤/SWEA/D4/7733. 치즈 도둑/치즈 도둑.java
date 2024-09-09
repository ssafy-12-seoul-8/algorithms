import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	static int piece, N, day;
	static int[][] cheeze;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); 
			cheeze = new int[N][N];
			piece = 1;
			int maxDay = 1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheeze[i][j] = Integer.parseInt(st.nextToken());
					maxDay = Math.max(maxDay, cheeze[i][j]);
				}
			}
			
			for (day = 1; day < maxDay; day++) {
				visited = new boolean[N][N];
				int temp = 0;
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!visited[i][j] && cheeze[i][j] > day) {
							dfs(i, j);
							temp++;
						}
					}
				}
				
				piece = Math.max(piece, temp);
				
			}
			
			sb.append("#").append(tc).append(" ").append(piece).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	static void dfs(int r, int c) {
		
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && cheeze[nr][nc] > day) {
				dfs(nr, nc);
			}
		}
		
		
	}
	
}