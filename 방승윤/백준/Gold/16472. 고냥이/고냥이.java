import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int[] cnt = new int[26];
		cnt[str.charAt(0) - 'a']++;
		int type = 1;
		int length = 1;
		int l = 0;
		int r = 0;
		int ans = 0;

		while (r < str.length() - 1) {
			if (type <= N) {
				int s = str.charAt(++r) - 'a';
				length++;

				if (cnt[s]++ == 0) {
					type++;
				}
			} else {
				int s = str.charAt(l++) - 'a';
				length--;

				if (--cnt[s] == 0) {
					type--;
				}
			}

			if (type <= N) {
				ans = Math.max(ans, length);
			}
		}

		System.out.println(ans);
	}
}