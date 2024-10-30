import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] nodes;
	static boolean[] visit;
	static long D, G;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		nodes = new ArrayList[n + 1];
		visit = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			nodes[a].add(b);
			nodes[b].add(a);
		}

		count(1);

		if (D > G * 3) {
			System.out.println("D");
			return;
		}

		if (D < G * 3) {
			System.out.println("G");
			return;
		}

		System.out.println("DUDUDUNGA");
	}

	static void count(int k) {
		visit[k] = true;
		if (nodes[k].size() >= 3) {
			long n = nodes[k].size();
			G += n * (n - 1) * (n - 2) / 6; // n이 30만이면 int를 넘음
		}

		for (int next : nodes[k]) {
			if (!visit[next]) {
				D += (nodes[k].size() - 1) * (nodes[next].size() - 1);
				count(next);
			}
		}
	}
}
