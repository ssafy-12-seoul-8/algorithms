import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[][] board;
	static boolean[][] visited;
	static Queue<int[]> queue;
	static int[] dirR = {-1, 1, 0 ,0};
	static int[] dirC = {0, 0, -1, 1};
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		visited = new boolean[N][M];
		queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			
			for(int j = 0; j < M; j++) {
				board[i][j] = line[j] - '0';
			}
		}
		
		bfs();
		
		System.out.println(board[N - 1][M - 1]);
	}
	
	static void bfs() {
		queue.offer(new int[] {0, 0, 1});
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] currentRC = queue.poll();
			
			board[currentRC[0]][currentRC[1]] = board[currentRC[0]][currentRC[1]] == 1 ? currentRC[2] : Math.min(currentRC[2], board[currentRC[0]][currentRC[1]]);

			for(int dir = 0; dir < dirR.length; dir++) {
				int nextR = currentRC[0] + dirR[dir];
				int nextC = currentRC[1] + dirC[dir];
				
				if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && visited[nextR][nextC] != true && board[nextR][nextC] != 0) {
					queue.offer(new int[] {nextR, nextC, currentRC[2] + 1});
					visited[nextR][nextC] = true;
				}
			}
		}
	}
}
