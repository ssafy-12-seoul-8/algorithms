import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int D, W, K;
	static int[][] film;
	static int[] A, B;
	static int minCnt;
 
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			A = new int[W];
			B = new int[W];
			Arrays.fill(B, 1);
			minCnt = K;
			
			makeFilm(0, 0);
			
			sb.append("#").append(tc).append(" ").append(minCnt).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	static void makeFilm(int idx, int cnt) {
		
		if (ok()) {
			minCnt = Math.min(minCnt, cnt);
			return;
		}
		
		if (minCnt < cnt) {
			return;
		}
		
		if (idx == D) {
			return;
		}
		
		makeFilm(idx + 1, cnt);
		
		int[] temp = film[idx];
		
		film[idx] = A;
		makeFilm(idx + 1, cnt + 1);
		
		film[idx] = B;
		makeFilm(idx + 1, cnt + 1);
		
		film[idx] = temp;
		
	}
	
	static boolean ok() {
		
		for (int c = 0; c < W; c++) {
			boolean flag = false;
			int cnt = 1;
			
			for (int r = 1; r < D; r++) {
				if (film[r][c] == film[r - 1][c]) {
					cnt++;
				} else {
					cnt = 1;
				}
				
				if (cnt == K) {
					flag = true;
					break;
				}
			}
			
			if (!flag) {
				return false;
			}
			
		}
		
		return true;
		
	}

}