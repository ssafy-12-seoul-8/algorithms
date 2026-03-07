import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =  Integer.parseInt(st.nextToken());
		int m =  Integer.parseInt(st.nextToken());
		int r =  Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] t = new int[n + 1];
		ArrayList<Node>[] nodes = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			t[i] = Integer.parseInt(st.nextToken());
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			nodes[a].add(new Node(b, l));
			nodes[b].add(new Node(a, l));
		}

		int max = 0;

		for (int i = 1; i <= n; i++) {
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(i, 0));
			int item = 0;
			boolean[] visited = new boolean[n + 1];

			while (!pq.isEmpty()) {
				Node curr = pq.poll();

				if (visited[curr.to]) {
					continue;
				}

				item += t[curr.to];
				visited[curr.to] = true;

				for (Node next : nodes[curr.to]) {
					if (visited[next.to] || curr.w + next.w > m) {
						continue;
					}
					
					pq.add(new Node(next.to, curr.w + next.w));
				}
			}

			max = Math.max(max, item);
		}

		System.out.println(max);
	}
}
