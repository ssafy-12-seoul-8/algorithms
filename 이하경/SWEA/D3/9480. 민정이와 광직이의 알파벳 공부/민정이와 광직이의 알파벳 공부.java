import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static int n, cnt;
	public static String[] word;
	public static int[] alpCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());

			word = new String[n];
			for (int i = 0; i < n; i++) {
				word[i] = br.readLine();
			}

			alpCnt = new int[26];
			cnt = 0;

			findWord(0);

			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb);

	}

	// k번 단어를 넣을지 말지 결정
	public static void findWord(int k) {
		if (k == n) {
			for (int i = 0; i < 26; i++) {
				if (alpCnt[i] == 0) {
					return;
				}
			}
			cnt++;
			return;
		}

		findWord(k + 1); // k번째를 안넣은 경우
		int l = word[k].length();
		for (int i = 0; i < l; i++) {
			alpCnt[word[k].charAt(i) - 'a']++;
		}
		findWord(k + 1); // k번째를 넣은 경우
		for (int i = 0; i < l; i++) {
			alpCnt[word[k].charAt(i) - 'a']--;
		}
	}
}
