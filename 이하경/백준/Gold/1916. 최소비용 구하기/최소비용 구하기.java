import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
	int idx;
	int dist;
	
	public Node(int idx, int dist) {
		this.idx = idx;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.dist, o.dist);
	}
}

public class Main {
	static int n, m;
	static List<List<Node>> city = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		
		for (int i = 0; i < n + 1; i++) {
			city.add(new ArrayList<Node>());
		}

		for (int i = 0; i < m; i++) {
			String[] inp = br.readLine().split(" ");
			int u = Integer.parseInt(inp[0]);
			int v = Integer.parseInt(inp[1]);
			int w = Integer.parseInt(inp[2]);
			city.get(u).add(new Node(v, w));
		}
		
		String[] inp = br.readLine().split(" ");
		int startIdx = Integer.parseInt(inp[0]);
		int endIdx = Integer.parseInt(inp[1]);
		
		System.out.println(dijkstra(startIdx, endIdx));
	}
	
	public static int dijkstra(int startIdx, int endIdx) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		dist[startIdx] = 0;
		pq.add(new Node(startIdx, 0));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int curDist = node.dist;
			int u = node.idx;
			
			if (u == endIdx) {
				return curDist;
			}
			
			if (curDist > dist[u]) {
				continue;
			}
			
			for (Node nextNode : city.get(u)) {
				int v = nextNode.idx;
				int w = nextNode.dist;
				if (dist[v] > dist[u] + w) {
					dist[v] = dist[u] + w;
					pq.add(new Node(v, dist[v]));
				}
			}
		}
		
		return dist[endIdx];
	}
}
