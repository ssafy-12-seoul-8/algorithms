import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Citizen implements Comparable<Citizen> {
		long l;
		long r;

		Citizen(long l, long r) {
			this.l = l;
			this.r = r;
		}

		public int compareTo(Citizen o) {
			return Long.compare(this.l, o.l);
		}
	}

	static class Mask implements Comparable<Mask> {
		long p;
		long x;

		Mask(long p, long x) {
			this.p = p; this.x = x;
		}

		public int compareTo(Mask o) {
			return Long.compare(this.p, o.p); // 가격(P) 기준 오름차순
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Citizen[] citizens = new Citizen[N];
		Mask[] masks = new Mask[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long l = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			citizens[i] = new Citizen(l, r);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			long p = Long.parseLong(st.nextToken());
			long x = Long.parseLong(st.nextToken());
			masks[i] = new Mask(p, x);
		}

		Arrays.sort(citizens);
		Arrays.sort(masks);
		PriorityQueue<Long> pq = new PriorityQueue<>();
		int ans = 0;
		int idx = 0;

		for (int i = 0; i < M; i++) {
			long price = masks[i].p;
			long cnt = masks[i].x;

			while (idx != N && citizens[idx].l <= price) {
				pq.add(citizens[idx++].r);
			}

			while (!pq.isEmpty() && pq.peek() < price) {
				pq.poll();
			}

			while (!pq.isEmpty() && cnt > 0) {
				pq.poll();
				ans++;
				cnt--;
			}
		}

		System.out.println(ans);
	}
}