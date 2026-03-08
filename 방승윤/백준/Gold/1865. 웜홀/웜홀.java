import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int to;
		int w;

		Node(int to, int w) {
			this.to = to;
			this.w = w;
		}

		public int compareTo(Node node) {
			return this.w - node.w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		one: for (int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			ArrayList<Node>[] paths = new ArrayList[N + 1];

			for (int i = 1; i < N + 1; i++) {
				paths[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				paths[S].add(new Node(E, T));
				paths[E].add(new Node(S, T));
			}

			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				paths[S].add(new Node(E, -T));
			}

			int[] time = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				boolean flag = false;

				for (int j = 1; j <= N; j++) {
					for (Node path : paths[j]) {
						if (time[path.to] <= time[j] + path.w) {
							continue;
						}

						time[path.to] = time[j] + path.w;
						flag = true;

						if (i == N) {
							sb.append("YES\n");
							continue one;
						}
					}
				}

				if (!flag) {
					break;
				}
			}

			sb.append("NO\n");
		}

		System.out.println(sb);
	}
}
