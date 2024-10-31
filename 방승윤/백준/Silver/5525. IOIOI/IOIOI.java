import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		int cnt = 0;
		int Pcnt = 0;
		
		for (int i = 0; i < M; i++) {
			if (Pcnt % 2 == 0 && S.charAt(i) == 'I') {
				Pcnt++;
			} else if (Pcnt % 2 == 1 && S.charAt(i) == 'O') {
				Pcnt++;
			} else if (S.charAt(i) == 'I') {
				Pcnt = 1;
			} else {
				Pcnt = 0;
			}
			
			if (Pcnt >= 2 * N + 1 && Pcnt % 2 == 1) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}