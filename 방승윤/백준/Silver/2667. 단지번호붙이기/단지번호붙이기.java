import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	static int N, cnt;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int postNum = 0;
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt = 0;
					dfs(i, j);
					postNum++;
					pq.offer(cnt);
				}
			}
		}
		
		sb.append(postNum).append("\n");
		
		for (int i = 0; i < postNum; i++) {
			sb.append(pq.poll()).append("\n");
		}
		
		System.out.println(sb);
		
	}

	static void dfs(int r, int c) {
		
		cnt++;
		map[r][c] = 2;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
		
	}

}