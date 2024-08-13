import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Map<Integer, List<Integer>> map;
	static int[] split;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int k = Integer.parseInt(br.readLine());

		for (int t = 0; t < k; t++) {
			st = new StringTokenizer(br.readLine());
			int vt = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			// v 가 20,000 이라 2차원 배열로 만들었을 때 메모리 제한 초과

			map = new HashMap<>();
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());


				if (!map.containsKey(u)) {
					map.put(u, new ArrayList<>());
				}
				map.get(u).add(v);

				if (!map.containsKey(v)) {
					map.put(v, new ArrayList<>());
				}
				map.get(v).add(u);
			}

			boolean bipartiteGraph = true;
			split = new int[vt + 1];
			for (int i = 1; i <= vt; i++) {
				if (split[i] == 0) {
					split[i] = 1;
					if (!splitGraph(i, 1)) {
						bipartiteGraph = false;
					}
				}
			}

			System.out.println(bipartiteGraph ? "YES" : "NO");
			
		}

	}

	public static boolean splitGraph(int start, int side) {
		if (!map.containsKey(start)) {
			return true;
		}

		List<Integer> list = map.get(start);
		for (int i : list) {
			if (split[i] == 0) {
				split[i] = side == 1 ? 2 : 1;
				if (!splitGraph(i, split[i])) {
					return false;
				}
			} else if (split[i] == side) {
				return false;
			}
		}

		return true;
	}
}
