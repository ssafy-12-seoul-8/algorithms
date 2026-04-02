import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	// 판단 데이터의 수 B 최대 500
	// 판단 데이터의 총 개수 = B x 2 = 1000
	// 판단 데이터의 비트 3 이상 50 이하
	// 실시간 데이터의 수 N 최대 1000
	// 데이터의 비트의 최대 250
	// 1000 * 1000 * 250 = 2.5억
	// 판단 데이터를 hashSet으로 저장하면? -> 1000 * 250
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int B = Integer.parseInt(br.readLine());
		HashSet<String> lowSet = new HashSet<>();
		HashSet<String> highSet = new HashSet<>();
		int longest = 0;

		for (int i = 0; i < B; i++) {
			String data = br.readLine();
			lowSet.add(data);
			longest = Math.max(longest, data.length());
		}

		for (int i = 0; i < B; i++) {
			String data = br.readLine();
			highSet.add(data);
			longest = Math.max(longest, data.length());
		}

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			int cnt = 0;

			for (int j = 1; j <= longest; j++) {
				StringBuilder sb = new StringBuilder();

				for (int k = 0; k < data.length(); k++) {
					if (sb.length() == j) {
						sb.deleteCharAt(0);
					}

					sb.append(data.charAt(k));

					if (sb.length() == j) {
						if (lowSet.contains(sb.toString())) {
							cnt--;
						}

						if (highSet.contains(sb.toString())) {
							cnt++;
						}
					}
				}
			}

			if (cnt == 0) {
				System.out.println("GOOD");
			} else {
				System.out.println(cnt > 0 ? "LOW " + cnt : "HIGH " + Math.abs(cnt));
			}
		}
	}
}