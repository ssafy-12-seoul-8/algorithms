import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[][] board;
	static boolean[][] visited;
	static Queue<int[]> queue;
	static int[] dirR = {-1, 1, 0, 0};
	static int[] dirC = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];
		queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				if(value == 2) {
					queue.offer(new int[] {i, j, 0});
					visited[i][j] = true;
					board[i][j] = 2;
				} else if(value == 1) {
					board[i][j] = -1;
				} else {
					board[i][j] = value;
				}
			}
		}
		
		bfs();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M ; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			int[] currentRC = queue.poll();
			
			board[currentRC[0]][currentRC[1]] = currentRC[2];

			for(int dir = 0; dir < dirR.length; dir++) {
				int nextR = currentRC[0] + dirR[dir];
				int nextC = currentRC[1] + dirC[dir];
				
				if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && visited[nextR][nextC] != true && board[nextR][nextC] != 0) {
					int distance = board[nextR][nextC] == -1 ? currentRC[2] + 1 : Math.min(currentRC[2] + 1, board[nextR][nextC]);
					queue.offer(new int[] {nextR, nextC, distance});
					visited[nextR][nextC] = true;
				}
			}
		}
	}
}
