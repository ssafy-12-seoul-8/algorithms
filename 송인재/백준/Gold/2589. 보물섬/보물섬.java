import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] map = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine()
					.toCharArray();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'L') {
					bfs(map, i, j);
				}
			}
		}
		
		System.out.println(max);
	}
	
	static void bfs(char[][] map, int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[map.length][map[0].length];
		
		queue.add(new int[] {row, col, 0});
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currRow = current[0];
			int currCol = current[1];
			
			if (visited[currRow][currCol]) {
				continue;
			}
			
			int distance = current[2];
			max = Math.max(distance, max);
			visited[currRow][currCol] = true;
			
			for (int i = 0; i < 4; i++) {
				int nextRow = currRow + dr[i];
				int nextCol = currCol + dc[i];
				
				if (!isLand(map, nextRow, nextCol) || visited[nextRow][nextCol]) {
					continue;
				}
				
				queue.add(new int[] {nextRow, nextCol, distance + 1});
			}
		}
	}
	
	static boolean isLand(char[][] map, int row, int col) {
		return row >= 0 && col >= 0
				&& row < map.length
				&& col < map[0].length
				&& map[row][col] == 'L';
	}
	
}