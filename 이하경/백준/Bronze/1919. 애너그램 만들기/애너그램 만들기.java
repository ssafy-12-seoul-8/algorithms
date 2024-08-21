import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();

		int[] freq = new int[26];

		for (int i = 0; i < a.length(); i++) {
			freq[a.charAt(i) - 'a']++;
		}

		for (int i = 0; i < b.length(); i++) {
			freq[b.charAt(i) - 'a']--;
		}

		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			cnt += Math.abs(freq[i]);
		}

		System.out.println(cnt);

	}
}
