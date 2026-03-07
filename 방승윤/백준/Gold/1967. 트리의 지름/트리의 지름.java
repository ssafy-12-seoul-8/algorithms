import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
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
		int n = Integer.parseInt(br.readLine());
		ArrayList<Node>[] tree = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			tree[parent].add(new Node(child, weight));
			tree[child].add(new Node(parent, weight));
		}

		boolean[] visited = new boolean[n + 1];
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(1, 0));
		visited[1] = true;
		int max = 0;
		int end = 1;

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
		visited = new boolean[n + 1];
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
