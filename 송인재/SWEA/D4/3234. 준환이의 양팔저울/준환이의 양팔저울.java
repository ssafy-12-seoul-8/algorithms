import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, count;
	static int[] weights;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			n = Integer.parseInt(br.readLine());
			weights = new int[n];
			visited = new boolean[n];
			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}
			
			permutation(new int[n], 0);
			System.out.println("#" + t + " " + count);
		}
	}
	
	static void permutation(int[] selected, int current) {
		if (current == n) {
			measureWeights(selected, 0, 0, current);
		}
		
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				continue;
			}
			
			visited[i] = true;
			selected[current] = weights[i];
			
			permutation(selected, current + 1);
			
			selected[current] = 0;
			visited[i] = false;
		}
	}
	
	static void measureWeights(int[] selected, int leftSize, int rightSize, int left) {
		if (leftSize < rightSize) {
			return;
		}
		
		if (left == 0) {
			count++;
			
			return;
		}
		
		measureWeights(selected, selected[n - left] + leftSize, rightSize, left - 1);
		measureWeights(selected, leftSize, rightSize + selected[n - left], left - 1);
	}
	
}
