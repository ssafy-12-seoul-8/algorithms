import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int[] p1;
	static int[] p2;
	static int[] p3;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		p1 = new int[N + 1];
		p2 = new int[N + 1];
		p3 = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			p1[i] = i;
			p2[i] = i;
			p3[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int M1 = Integer.parseInt(st.nextToken());
		int M2 = Integer.parseInt(st.nextToken());
		int M3 = Integer.parseInt(st.nextToken());
		study(M1, p1);
		study(M2, p2);
		study(M3, p3);
		HashMap<Long, ArrayList<Integer>> map = new HashMap<>();
		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			long group = find(i, p1) * 100_000_000_000L + find(i, p2) * 1_000_000L + find(i, p3);
			map.putIfAbsent(group, new ArrayList<>());
			map.get(group).add(i);

			if (map.get(group).size() == 2) {
				cnt++;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		for (ArrayList<Integer> list : map.values()) {
			if (list.size() == 1) {
				continue;
			}

			result.add(list);
		}

		Collections.sort(result, Comparator.comparingInt(o -> o.get(0)));

		for (ArrayList<Integer> list : result) {
			for (int person : list) {
				sb.append(person).append(" ");
			}

			sb.append("\n");
		}
		
		System.out.print(sb);
	}

	static void study(int M, int[] p) throws Exception {
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}

			if (find(a, p) != find(b, p)) {
				p[find(b, p)] = find(a, p);
			}
		}
	}

	static int find(int x, int[] p) {
		if (x == p[x]) {
			return x;
		}

		return p[x] = find(p[x], p);
	}
}