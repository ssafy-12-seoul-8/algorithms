import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static ArrayList<Integer>[] edges;
	static boolean[] visit;
	static List<Integer> branchStack;
	static int[] dist;
	static int cycleStart;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		edges = new ArrayList[n + 1];
		visit = new boolean[n + 1];
		dist = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edges[u].add(v);
			edges[v].add(u);
		}
		
		Arrays.fill(dist, n);
		branchStack = new ArrayList<>();
		visit[1] = true;
		findCycle(0, 1);

		for (int start : branchStack) {
			findBranch(start, 0);
		}

		for (int i = 1; i <= n; i++) {
			sb.append(dist[i]).append(" ");
		}

		System.out.println(sb);

	}
	
	static void findCycle(int prev, int curr) {
		for (int next : edges[curr]) {
			if (cycleStart != 0) {
				break;
			}
			if (!visit[next]) {
				visit[next] = true;
				findCycle(curr, next);
				continue;
			}
			if (visit[next] && next != prev) {
				cycleStart = next;
				break;
			}
		}

		if (cycleStart != 0 && edges[curr].size() >= 3) {
			branchStack.add(curr);
		}

		if (cycleStart != 0) {
			dist[curr] = 0;
			if (cycleStart == curr) {
				cycleStart = 0;
			}
		}
	}

	static void findBranch(int start, int d) {
		dist[start] = d;

		for (int next : edges[start]) {
			if (dist[next] == n) {
				findBranch(next, d + 1);
			}
		}
	}
}
