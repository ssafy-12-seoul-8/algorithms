import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		for (int t = 0; t < n; t++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			boolean possible = true;

			int[] freq = new int[26];
			if (a.length() != b.length()) {
				possible = false;
			} else {
				for (int i = 0; i < a.length(); i++) {
					freq[a.charAt(i) - 'a']++;
				}
				for (int i = 0; i < b.length(); i++) {
					if (--freq[b.charAt(i) - 'a'] < 0) {
						possible = false;
						break;
					}
				}
			}
			System.out.println(possible ? "Possible" : "Impossible");

		}

	}
}
