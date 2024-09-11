import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			set.add(arr[i]);
		}

		Map<Integer, Integer> map = new HashMap<>();
		int idx = 0;
		for (int s : set) {
			map.put(s, idx++); // 숫자 s가 i번쨰이다
		}

		for (int i = 0; i < n; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}

		System.out.println(sb);
	}
}
