import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Operation {
		int l;
		int r;
		int c;

		Operation(int l, int r, int c) {
			this.l = l;
			this.r = r;
			this.c = c;
		}
	}

	static class State implements Comparable<State> {
		List<Integer> arr;
		int cost;

		State(List<Integer> arr, int cost) {
			this.arr = arr;
			this.cost = cost;
		}

		public int compareTo(State o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> A = new ArrayList<>();
		List<Integer> sorted = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			A.add(num);
			sorted.add(num);
		}

		Collections.sort(sorted);
		int M = Integer.parseInt(br.readLine());
		List<Operation> ops = new ArrayList<>();

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			ops.add(new Operation(l, r, c));
		}

		Map<List<Integer>, Integer> dist = new HashMap<>();
		PriorityQueue<State> pq = new PriorityQueue<>();
		dist.put(A, 0);
		pq.add(new State(A, 0));

		while (!pq.isEmpty()) {
			State curr = pq.poll();

			for (Operation op : ops) {
				List<Integer> nextArr = new ArrayList<>(curr.arr);
				int temp = nextArr.get(op.l);
				nextArr.set(op.l, nextArr.get(op.r));
				nextArr.set(op.r, temp);

				if (dist.getOrDefault(nextArr, Integer.MAX_VALUE) > curr.cost + op.c) {
					dist.put(nextArr, curr.cost + op.c);
					pq.add(new State(nextArr, curr.cost + op.c));
				}
			}
		}

		System.out.println(dist.getOrDefault(sorted, -1));
	}
}