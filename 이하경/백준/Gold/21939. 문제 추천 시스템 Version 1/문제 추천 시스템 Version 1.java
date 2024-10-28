import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		TreeSet<Problem> problems = new TreeSet<>();
		HashMap<Integer, Problem> map = new HashMap<>();
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());

			Problem np = new Problem(num, level);
			problems.add(np);
			map.put(num, np);
		}

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			if (cmd.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				int level = Integer.parseInt(st.nextToken());

				Problem np = new Problem(num, level);
				problems.add(np);
				map.put(num, np);
				continue;
			}
			
			if (cmd.equals("solved")) {
				int num = Integer.parseInt(st.nextToken());
				
				Problem solved = map.get(num);
				problems.remove(solved);
			}

			if (cmd.equals("recommend")) {
				int dir = Integer.parseInt(st.nextToken());

				if (dir == 1) {
					Problem find = problems.last();
					sb.append(find.num).append("\n");
					continue;
				}

				Problem find = problems.first();
				sb.append(find.num).append("\n");
			}
		}

		System.out.println(sb);
	}

	static class Problem implements Comparable<Problem> {
		int num, level;

		public Problem(int num, int level) {
			this.num = num;
			this.level = level;
		}

		@Override
		public int compareTo(Main.Problem o) {
			if (this.level == o.level) {
				return this.num - o.num;
			}
			return this.level - o.level;
		}
	}
}
