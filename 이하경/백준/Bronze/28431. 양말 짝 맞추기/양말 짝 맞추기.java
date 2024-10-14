import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[] pair = new boolean[10];

		for (int i = 0; i < 5; i++) {
			int n = Integer.parseInt(br.readLine());
			pair[n] = !pair[n];
		}

		for (int i = 0; i < 10; i++) {
			if (pair[i]) {
				System.out.println(i);
				break;
			}
		}
	}
}
