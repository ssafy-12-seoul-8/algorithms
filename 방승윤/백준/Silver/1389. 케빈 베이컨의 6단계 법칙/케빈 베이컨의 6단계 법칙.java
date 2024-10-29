import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] relation = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			Arrays.fill(relation[i], 10000);
		}
		
		for (int i = 1; i <= N; i++) {
			relation[i][i] = 0;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			relation[a][b] = 1;
			relation[b][a] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					relation[j][k] = Math.min(relation[j][i] + relation[i][k], relation[j][k]);
				}
			}
		}
		
		int minKB = Integer.MAX_VALUE;
		int ans = 0;
		
		for (int i = 1; i <= N; i++) {
			int tmp = 0;
			
			for (int level : relation[i]) {
				tmp += level;
			}
			
			if (tmp < minKB) {
				ans = i;
			}
			
			minKB = Math.min(tmp, minKB);
			
		}
		
		System.out.println(ans);
		
	}

}