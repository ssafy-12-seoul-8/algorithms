import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for (int i = 2; i <= N - 4; i += 2) {
			cnt += (N - i) / 2 - 1;
		}
		
		System.out.println(cnt);
		
	}
	
}