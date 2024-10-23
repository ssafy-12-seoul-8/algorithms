import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int maxH = 0;
		int minH = Integer.MAX_VALUE;
		
		int[][] field = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				minH = Math.min(minH, field[i][j]);
				maxH = Math.max(maxH, field[i][j]);
			}
		}
		
		int minT = Integer.MAX_VALUE;
		int targetH = 0;
		
		for (int h = minH; h <= maxH; h++) {
			int time = 0;
			int usedB = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (field[i][j] > h) {
						time += (field[i][j] - h) * 2;
					} else {
						time += h - field[i][j];
					}
					
					usedB += h - field[i][j];
				}
			}
			
			if (usedB <= B && time <= minT) {
				minT = time;
				targetH = h;
			}
		}
		
		sb.append(minT).append(" ").append(targetH);
		
		System.out.println(sb);
		
	}
	
}