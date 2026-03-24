import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] red = new int[M];
		p = new int[M + 1];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i <= M; i++) {
			p[i] = i;
		}

		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			red[i] = num;
		}

		Arrays.sort(red);

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < K; i++) {
			int blue = Integer.parseInt(st.nextToken());
			int L = 0;
			int R = M - 1;
			int mid = 0;
			int num = 0;

			while (L < R) {
				mid = (L + R) / 2;
				num = red[mid];

				if (num <= blue) {
					L = mid + 1;
				} else {
					R = mid;
				}
			}

			sb.append(red[find(L)]).append("\n");
			p[L] = find(p[L] + 1);
		}

		System.out.println(sb);
	}

	static int find(int x) {
		if (x == p[x]) {
			return x;
		}

		return p[x] = find(p[x]);
	}
}