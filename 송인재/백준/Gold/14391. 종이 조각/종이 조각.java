import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		dfs(0, 0);
		
		System.out.println(max);
	}
	
	static void dfs(int depth, int sum) {
		if (depth == n * m) {
			max = Math.max(max, sum);
			
			return;
		}
		
		int row = depth / m;
		int col = depth % m;
		
		if (visited[row][col]) {
			dfs(depth + 1, sum);
			
			return;
		}
		
		visited[row][col] = true;
		int current = map[row][col];
		
		dfs(depth + 1, sum + current);
		
		int last = row + 1;
		
		for (int i = last; i < n; i++) {
			if (visited[i][col]) {
				break;
			}
			
			visited[i][col] = true;
			current = current * 10 + map[i][col];
			
			dfs(depth + 1, sum + current);
			
			last = i + 1;
		}
		
		for (int j = row + 1; j < last; j++) {
			visited[j][col] = false;
		}
		
		current = map[row][col];
		last = col + 1;
		
		for (int i = last; i < m; i++) {
			if (visited[row][i]) {
				break;
			}
			
			visited[row][i] = true;
			current = current * 10 + map[row][i];
			
			dfs(depth + i - col + 1, sum + current);
			
			last = i + 1;
		}
		
		for (int j = col + 1; j < last; j++) {
			visited[row][j] = false;
		}
		
		visited[row][col] = false;
	}
	
}