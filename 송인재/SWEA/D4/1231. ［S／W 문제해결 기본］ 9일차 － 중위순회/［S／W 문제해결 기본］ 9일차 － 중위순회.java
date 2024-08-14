import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	
	static final int cases = 10;
	
	static char[] data;
	static Map<Integer, List<Integer>> tree;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= cases; t++) {
			int n = Integer.parseInt(br.readLine());
			data = new char[n + 1];
			visited = new boolean[n + 1];
			tree = new HashMap<>();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int node = Integer.parseInt(st.nextToken());
				data[i + 1] = st.nextToken()
						.charAt(0);
				
				
				while (st.hasMoreTokens()) {
					tree.putIfAbsent(node, new ArrayList<>());
					tree.get(node)
						.add(Integer.parseInt(st.nextToken()));
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			dfs(1, sb);
			
			System.out.println("#" + t + " " + sb);
		}
	}
	
	static void dfs(int node, StringBuilder sb) {
		if (!tree.containsKey(node)) {
			sb.append(data[node]);
			visited[node] = true;
			
			return;
		}
		
		for (int child : tree.get(node)) {
			dfs(child, sb);
			
			if (!visited[node]) {
				sb.append(data[node]);
				visited[node] = true;
			}
		}
	}

}