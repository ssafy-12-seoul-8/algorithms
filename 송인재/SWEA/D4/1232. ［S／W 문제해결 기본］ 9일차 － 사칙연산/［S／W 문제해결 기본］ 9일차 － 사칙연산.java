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
	
	static int n;
	static String[] data;
	static Map<Integer, List<Integer>> tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= cases; t++) {
			n = Integer.parseInt(br.readLine());
			data = new String[n + 1];
			tree = new HashMap<>();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				data[index] = st.nextToken();
				
				while (st.hasMoreTokens()) {
					tree.putIfAbsent(index, new ArrayList<>());
					tree.get(index)
						.add(Integer.parseInt(st.nextToken()));
				}
			}
			
			System.out.println("#" + t + " " + (int) calculate(1));
		}
	}
	
	static double calculate(int node) {
		if (!tree.containsKey(node)) {
			return Double.parseDouble(data[node]);
		}
		
		List<Integer> children = tree.get(node);
		
		double first = calculate(children.get(0));
		double second = calculate(children.get(1));
		
		switch (data[node]) {
			case "+":
				return first + second;
			case "-":
				return first - second;
			case "*":
				return first * second;
			case "/":
				return first / second;
			default:
				return 0;
		}
	}
	
}