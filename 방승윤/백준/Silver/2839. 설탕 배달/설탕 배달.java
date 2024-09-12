import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int answer = -1;
		
		for (int i = N / 5; i >= 0; i--) {
			if (i == 0) {
				if (N % 3 == 0) {
					answer = N / 3;
				}
			} else if ((N - (5 * i)) % 3 == 0) {
				answer = i + (N - (5 * i)) / 3;
				break;
			}
		}
		
		System.out.println(answer);
		
	}
	
}