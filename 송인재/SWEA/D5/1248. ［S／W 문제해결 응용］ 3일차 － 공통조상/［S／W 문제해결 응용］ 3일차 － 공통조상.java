import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	
	static Map<Integer, List<Integer>> tree;
	static int v;
	static int e;
	static int first;
	static int second;
	static int count;
	static int mutual;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tree = new HashMap<>();
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
			mutual = 0;
			count = 0;
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < e; i++) {
				int parent = Integer.parseInt(st.nextToken());
				
				tree.putIfAbsent(parent, new ArrayList<>());
				tree.get(parent)
					.add(Integer.parseInt(st.nextToken()));
			}
			
			dfs(1);
			fullSearch(mutual);
			
			System.out.println("#" + t + " " + mutual + " " + count);
		}
	}
	
	static void fullSearch(int node) {
		count++;
		
		if (!tree.containsKey(node)) {
			return;
		}
		
		for (int child : tree.get(node)) {
			fullSearch(child);
		}
	}
	
	static boolean dfs(int node) {
		if (node == first || node == second) {
			return true;
		}
		
		boolean hasFirst = false;
		boolean hasSecond = false;
		
		if (!tree.containsKey(node)) {
			return false;
		}
		
		for (int child : tree.get(node)) {
			if (hasSecond) {
				break;
			}
			
			if (!hasFirst) {
				hasFirst =  dfs(child);
				
				continue;
			}
			
			hasSecond = dfs(child);
		}
		
		if (hasFirst && hasSecond) {
			mutual = node;
		}
		
		return hasFirst || hasSecond;
	}
	
}