// 보상역순으로 정렬
// 늦게풀수록 앞에 다른걸 풀수있어서 이득이므로 데드라인 날짜에 푼다
// 문제를 풀고나면 데드라인 날짜를 그 앞날짜에 유니온파인드

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Homework> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o.cupramen));
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int deadline = Integer.parseInt(st.nextToken());
			int cupramen = Integer.parseInt(st.nextToken());
			pq.add(new Homework(deadline, cupramen));
		}

		int ans = 0;
		p = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}

		while (!pq.isEmpty()) {
			Homework curr = pq.poll();
			if (find(curr.deadline) != 0) { // 여기서 p[curr.deadline] 갱신
				ans += curr.cupramen;
				p[p[curr.deadline]] = p[curr.deadline] - 1;
			}
		}

		System.out.println(ans);
	}

	static int find(int x) {
		if (p[x] != x) {
			p[x] = find(p[x]);
		}
		return p[x];

	}

	static class Homework {
		int deadline, cupramen;

		public Homework(int deadline, int cupramen) {
			this.deadline = deadline;
			this.cupramen = cupramen;
		}
	}
}
