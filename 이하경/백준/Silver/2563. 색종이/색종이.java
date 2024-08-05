import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		boolean[][] board = new boolean[100][100];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					board[j][k] = true;
				}
			}
			
		}
		
		int cnt = 0;
		
		for (int j = 0; j < 100; j++) {
			for (int k = 0; k < 100; k++) {
				if (board[j][k]) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);

	}
}
