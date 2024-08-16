import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			int n = Integer.parseInt(br.readLine());
			Set<Integer> set = new HashSet<>();

			for (int i = 0; i <= 9; i++) {
				set.add(i);
			}

			int num = 0;
			while (set.size() > 0) {
				num += n;
				int tmp = num;
				while (tmp > 0) {
					int digit = tmp % 10;
					if (set.contains(digit)) {
						set.remove(digit);
					}
					tmp /= 10;
				}
			}

			sb.append(num).append("\n");
		}

		System.out.println(sb);
	}
}
