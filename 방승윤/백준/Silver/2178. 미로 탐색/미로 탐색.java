import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[][] maze = new String[N][];
		
		for (int i = 0; i < N; i++) {
			maze[i] = br.readLine().split("");
		}
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		Queue<int[]> queue = new LinkedList<>();
		int[] curr = new int[2];
		int d = 1;
		
		queue.offer(curr);
		
		while (true) {
			int repeat = queue.size();
			
			for (int i = 0; i < repeat; i++) {
				curr = queue.poll();
				
				if (curr[0] == N - 1 && curr[1] == M - 1) {
					System.out.println(d);
					return;
				}
				
				for (int j = 0; j < 4; j++) {
					int nr = curr[0] + dr[j];
					int nc = curr[1] + dc[j];
					
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && maze[nr][nc].equals("1")) {
						int[] next = {nr, nc};
						maze[nr][nc] = "0";
						queue.offer(next);
					}
				}
			}
			
			d++;
		}
		
		
	}

}