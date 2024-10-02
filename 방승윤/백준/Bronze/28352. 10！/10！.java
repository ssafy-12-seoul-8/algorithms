import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		for (int i = N - 1; i > 10; i--) {
			N *= i;
		}
		
		System.out.println(N == 10 ? 6 : N * 6);

	}

}