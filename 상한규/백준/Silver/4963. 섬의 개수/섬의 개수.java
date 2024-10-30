import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[][] board;
	static boolean[][] visited;
	static Queue<int[]> queue;
	static int[] dirR = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dirC = {-1, 0, 1, -1, 1, -1, 0, 1};
	static StringBuilder sb;
	static StringTokenizer st;
	static int result;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			result = 0;
			
			if(N == 0 && M == 0) {
				break;
			}
			
			board = new int[N][M];
			visited = new boolean[N][M];
			queue = new LinkedList<>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < M; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					queue.clear();
					if(board[i][j] == 1 && visited[i][j] == false) {
						result++;
						
						bfs(i, j);
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int startR, int startC) {
		queue.offer(new int[] {startR, startC});
		
		while(!queue.isEmpty()) {
			int[] currentRC = queue.poll();

			for(int dir = 0; dir < dirR.length; dir++) {
				int nextR = currentRC[0] + dirR[dir];
				int nextC = currentRC[1] + dirC[dir];
				
				if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && visited[nextR][nextC] != true && board[nextR][nextC] != 0) {
					queue.offer(new int[] {nextR, nextC});
					visited[nextR][nextC] = true;
				}
			}
		}
	}
}
