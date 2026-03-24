import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] in;
	static int[] post;
	static int[] position;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		in = new int[n];
		post = new int[n];
		position = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			in[i] = Integer.parseInt(st.nextToken());
			position[in[i]] = i;
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}

		pre(0, n - 1, 0, n - 1);
		System.out.println(sb);
	}

	static void pre(int inL, int inR, int postL, int postR) {
		if (inL > inR || postL > postR) {
			return;
		}

		int root = post[postR];
		sb.append(root).append(" ");
		int idx = position[root];
		int left = idx - inL;
		pre(inL, idx - 1, postL, postL + left - 1);
		pre(idx + 1, inR, postL + left, postR - 1);
	}
}