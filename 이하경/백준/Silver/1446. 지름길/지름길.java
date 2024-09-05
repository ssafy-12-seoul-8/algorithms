import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int n, d;
	static Path[] paths;
	static TreeMap<Integer, Integer> dp; // key번 위치까지 최대로 아낄 수 있는 값 저장

	public static void main(String[] args) throws Exception {
		input();
		solution();
	}

	static void solution() {
		Arrays.sort(paths, Comparator.comparingInt(o -> o.end));

		dp = new TreeMap<>(Collections.reverseOrder());
		dp.put(0, 0);

		for (int i = 0; i < n; i++) {
			int saved = paths[i].saved();
			if (saved == 0) {
				continue;
			}

			int max = dp.firstEntry().getValue(); // 현재까지의 최대값과
			for (int k : dp.keySet()) {
				if (k <= paths[i].start) {
					if (max <= dp.get(k) + saved) { // 현재를 선택할 수 있을때의 최대값 비교
						dp.put(paths[i].end, dp.get(k) + saved); // 갱신한 값이 더 클때만 넣을 가치가 있다
					}
					break;
				}
			}
		}

		System.out.println(d - dp.firstEntry().getValue());
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		paths = new Path[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			paths[i] = new Path(start, end, dist);
		}
	}

	static class Path {
		int start, end, dist;

		public Path(int start, int end, int dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}

		public int saved() {
			if (end > d) {
				return 0;
			}

			if (end - start < dist) {
				return 0;
			}
			return end - start - dist;
		}
	}
}
