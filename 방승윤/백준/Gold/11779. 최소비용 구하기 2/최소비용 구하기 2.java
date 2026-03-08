import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int v;
		int w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		public int compareTo(Node node) {
			return this.w - node.w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Node>[] buses = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			buses[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			buses[s].add(new Node(e, w));
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		int[] prev = new int[n + 1];
		int[] costs = new int[n + 1];
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[s] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.v == e) {
				sb.append(cur.w).append("\n");
				break;
			}

			for (Node next : buses[cur.v]) {
				if (cur.w + next.w >= costs[next.v]) {
					continue;
				}

				costs[next.v] = cur.w + next.w;
				pq.add(new Node(next.v, cur.w + next.w));
				prev[next.v] = cur.v;
			}
		}

		int city = e;
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		deque.push(city);
		int cnt = 1;

		while (city != s) {
			city = prev[city];
			deque.push(city);
			cnt++;
		}

		sb.append(cnt).append("\n");

		for (Integer num : deque) {
			sb.append(num).append(" ");
		}

		System.out.println(sb);
	}
}
