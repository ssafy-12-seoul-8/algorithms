import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> graph[] = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];
		
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[n].add(v);
			graph[v].add(n);
		}

		for(ArrayList<Integer> node : graph) {
			node.sort((o1, o2) -> o1 - o2);
		}
		
		// dfs with stack
//		stack.push(V);
//		
//		while(!stack.isEmpty()) {
//			int current = stack.pop();
//			
//			ArrayList<Integer> node = graph[current];
//
//			if(!visited[current]) {
//				visited[current] = true;
//				sb.append(current).append(" ");
//				
//				for(int i = node.size() - 1; i >= 0; i--){
//					if(!visited[node.get(i)]) {
//						
//						stack.push(node.get(i));
//					}
//				}
//			}
//		}
//		
//		System.out.println(sb);
		
		// dfs with recur
		sb = new StringBuilder();
		dfs(V, new boolean[N + 1], graph, sb);
		System.out.println(sb);
		
		
		
		visited = new boolean[N + 1];
		sb = new StringBuilder();
		
		// bfs
		queue.offer(V);
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			ArrayList<Integer> node = graph[current];
			
			sb.append(current).append(" ");
			
			for(int i = 0; i < node.size(); i++) {
				if(!visited[node.get(i)]) {
					queue.offer(node.get(i));
					visited[node.get(i)] = true;
				}
			}
		}

		System.out.println(sb);
	}
	
	public static void dfs(int V, boolean[] visited, ArrayList<Integer> graph[], StringBuilder sb) {
		visited[V] = true;
		sb.append(V).append(" ");

		ArrayList<Integer> node = graph[V];
		
		for(int i = 0; i < node.size(); i++) {
			if(!visited[node.get(i)]) {
				dfs(node.get(i), visited, graph, sb);
			}
		}
	}
}
