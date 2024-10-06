import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] prime = new boolean[N + 1];
		
		prime[1] = true;
		
		for (int i = 2; i <= N; i++) {
			if (!prime[i]) {
				if (i >= M) {
					sb.append(i).append("\n");
				}
				
				for (int j = i + i; j <= N; j += i) {
					prime[j] = true;
				}
			}
		}
		
		System.out.println(sb);
			
	}
		
}