import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, L, maxScore;
	static int[][] ingredient;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ingredient = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ingredient[i][0] = Integer.parseInt(st.nextToken());
				ingredient[i][1] = Integer.parseInt(st.nextToken());
			}
			
			findScore(0, 0, 0);
			
			sb.append("#").append(test_case).append(" ").append(maxScore).append("\n");
			maxScore = 0;
		}
		System.out.println(sb);
	}
	
	static void findScore(int idx, int score, int calorie) {
		if (idx == N) {
			return;
		}
		
		if (calorie > L) {
			return;
		}
		
		calorie += ingredient[idx][1];
		score += ingredient[idx][0];
		
		if (calorie <= L && score > maxScore) {
			maxScore = score;
		}
		
		findScore(idx + 1, score, calorie);
		
		calorie -= ingredient[idx][1];
		score -= ingredient[idx][0];
		
		findScore(idx + 1, score, calorie);
	}
	
}