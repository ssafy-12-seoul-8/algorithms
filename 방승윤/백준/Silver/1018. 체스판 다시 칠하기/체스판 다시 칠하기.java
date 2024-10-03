import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		String[] board = new String[N];
		
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int cnt = 0;
				
				if (i + 7 < N && j + 7 < M) {
					for (int k = 0; k < 8; k++) {
						for (int l = 0; l < 8; l++) {
							if ((k + l) % 2 == 0 && board[i + k].charAt(j + l) == 'W') {
								cnt++;
							} else if ((k + l) % 2 == 1 && board[i + k].charAt(j + l) == 'B') {
								cnt++;
							}
						}
					}
					
					min = Math.min(min, Math.min(cnt, 64 - cnt));
				}
			}
		}

		System.out.print(min);

	}

}