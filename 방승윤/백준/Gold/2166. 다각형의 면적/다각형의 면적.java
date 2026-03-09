import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] X = new long[N + 1];
		long[] Y = new long[N + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(st.nextToken());
			Y[i] = Integer.parseInt(st.nextToken());
		}

		X[N] = X[0];
		Y[N] = Y[0];
		double area = 0;

		for (int i = 0; i < N; i++) {
			area += X[i] * Y[i + 1];
			area -= Y[i] * X[i + 1];
		}

		System.out.printf("%.1f", Math.abs(area / 2));
	}
}
