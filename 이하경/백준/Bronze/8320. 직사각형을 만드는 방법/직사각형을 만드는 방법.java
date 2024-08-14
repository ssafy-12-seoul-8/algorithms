import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;

		// 가로 i
		for (int i = 1; i <= Math.sqrt(n); i++) {
			// 세로 j는 i 이상
			for (int j = i; j <= n; j++) {
				if (i * j > n) {
					break;
				}
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
