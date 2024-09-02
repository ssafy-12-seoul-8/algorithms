import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> edge;
	static int[] population;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		population = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		edge = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			edge.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				int v = Integer.parseInt(st.nextToken()) - 1;
				edge.get(i).add(v);
			}
		}

		int ans = 10000;
		int partA, partB;
		// n-1번 비트는 항상 0구역이라고 생각
		for (int i = 1; i < (1 << (n - 1)); i++) {
			if (isConnected(i)) {
				partA = 0;
				partB = population[n - 1];

				for (int j = 0; j < n - 1; j++) {
					if ((i & 1 << j) != 0) {
						partA += population[j];
					} else {
						partB += population[j];
					}
				}

				ans = Math.min(ans, Math.abs(partA - partB));
			}
		}

		System.out.println(ans == 10000 ? -1 : ans);

	}

	static boolean isConnected(int visit) {
		int a = visit;
		int b = (1 << n) - visit - 1;

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			if ((a & (1 << i)) != 0) {
				a ^= (1 << i);
				q.add(i);
				break;
			}
		}
		

		while (!q.isEmpty() && a != 0) {
			int cur = q.poll();
			
			for (int next : edge.get(cur)) {
				if ((a & (1 << next)) != 0) {
					a ^= (1 << next);
					q.offer(next);
				}
			}
		}

		if (a != 0) {
			return false;
		}

		q = new LinkedList<>();

		q.add(n - 1);
		b ^= (1 << (n - 1));

		while (!q.isEmpty() && b != 0) {
			int cur = q.poll();

			for (int next : edge.get(cur)) {
				if ((b & (1 << next)) != 0) {
					b ^= (1 << next);
					q.offer(next);
				}
			}
		}

		if (b != 0) {
			return false;
		}

		return true;
	}

}
