import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int X = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] dishes = new int[N];
		int max = 0;
		int size = 0;

		for (int i = 0; i < N; i++) {
			dishes[i] = Integer.parseInt(br.readLine());
		}

		Queue<Integer> q = new LinkedList<>();
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int i = N - k; i < N; i++) {
			q.offer(dishes[i]);
			hashMap.put(dishes[i], hashMap.getOrDefault(dishes[i], 0) + 1);
		}

		for (int i = 0; i < N; i++) {
			max = Math.max(max, hashMap.size() + (hashMap.containsKey(c) ? 0 : 1));
			int out = q.poll();
			hashMap.put(out, hashMap.get(out) - 1);

			if (hashMap.get(out) == 0) {
				hashMap.remove(out);
			}

			q.offer(dishes[i]);
			hashMap.put(dishes[i], hashMap.getOrDefault(dishes[i], 0) + 1);
		}

		System.out.println(max);
	}
}
