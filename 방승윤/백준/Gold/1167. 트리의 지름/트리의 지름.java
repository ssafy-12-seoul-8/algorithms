import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int to;
		int w;

		Node(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		ArrayList<Node>[] tree = new ArrayList[V + 1];

		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			tree[from] = new ArrayList<>();

			while (true) {
				int to = Integer.parseInt(st.nextToken());

				if (to == -1) {
					break;
				}

				int w = Integer.parseInt(st.nextToken());
				tree[from].add(new Node(to, w));
			}
		}

		boolean[] visited = new boolean[V + 1];
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(1, 0));
		visited[1] = true;
		int max = 0;
		int end = 0;

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			for (Node next : tree[curr.to]) {
				if (visited[next.to]) {
					continue;
				}

				if (curr.w + next.w > max) {
					max = curr.w + next.w;
					end = next.to;
				}

				queue.add(new Node(next.to, curr.w + next.w));
				visited[next.to] = true;
			}
		}

		queue.add(new Node(end, 0));
		visited = new boolean[V + 1];
		visited[end] = true;
		max = 0;

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			for (Node next : tree[curr.to]) {
				if (visited[next.to]) {
					continue;
				}

				max = Math.max(max, next.w + curr.w);
				queue.add(new Node(next.to, curr.w + next.w));
				visited[next.to] = true;
			}
		}

		System.out.println(max);
	}
}
