import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			int[][] countArray = new int[N + 1][2];
			countArray[0] = new int[] {1, 0};
			
			if(N > 0) {				
				countArray[1] = new int[] {0, 1};
			}
			
			for(int i = 2; i <= N; i++) {
				countArray[i] = new int[] {countArray[i - 2][0] + countArray[i - 1][0], countArray[i - 2][1] + countArray[i - 1][1]};
			}
			
			
			System.out.println(sb.append(countArray[N][0]).append(" ").append(countArray[N][1]));
		}
	}
}