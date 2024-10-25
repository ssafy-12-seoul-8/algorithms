import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, friend;
	static String[][] campus;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		campus = new String[N][];
		visited = new boolean[N][M];
		
		
		for (int i = 0; i < N; i++) {
			campus[i] = br.readLine().split("");
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (campus[i][j].equals("I")) {
					find(i, j);
				}
			}
		}
		
		System.out.println(friend == 0 ? "TT" : friend);

	}

	private static void find(int x, int y) {
		visited[x][y] = true;
		
		if (campus[x][y].equals("P")) {
			friend++;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && !campus[nx][ny].equals("X")) {
				find(nx, ny);
			}
		}
		
	}

}