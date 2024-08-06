import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		
		solve(r, c, k);
	}
	
	public static void solve (int c, int r, int k) {
		if (k > c * r) {
			System.out.println(0);
			return;
		}
		
		int[][] seats = new int[r][c];
		
		// c가 열, r이 행, 좌상이 (0, 0)이라고 사면 우 하 좌 상 순서
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		
		int cr = 0, cc = 0, d = 0;
		
		for (int i = 1; i < k; i++) {
			seats[cr][cc] = i;
			
			int nr = cr + dr[d];
			int nc = cc + dc[d];
			
			if (nr < 0 || nr >= r || nc < 0 || nc >= c || seats[nr][nc] != 0) {
				d = (d + 1) % 4;
			}
			
			cr += dr[d];
			cc += dc[d];
		}
		
		System.out.println(cr + 1 + " " + (cc + 1));
		return;
	}

}
