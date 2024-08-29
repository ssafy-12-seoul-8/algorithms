import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static String s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();

		int len = s.length();
		int start = 0, end = 0;
		boolean isWord = true;
		// 새로운 단어가 시작하는 경우: 공백 다음, > 다음
		// 다어가 끝나는 경우: 공백이 나올때, < 나올때
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c == '<') {
				end = i - 1;
				if (start <= end) {
					addReverse(start, end);
				}
				sb.append('<');
				isWord = false;
				continue;
			}
			if (c == '>') {
				sb.append('>');
				isWord = true;
				start = i + 1;
				continue;
			} 
			if (c == ' ') {
				if (isWord) {
					addReverse(start, i - 1);
					start = i + 1;
				}
				sb.append(' ');
				continue;
			}
			if (!isWord) {
				sb.append(c);
			}
		}
		if (start < len) {
			addReverse(start, len - 1);
		}

		System.out.println(sb);

	}

	static void addReverse(int start, int end) {
		for (int i = end; i >= start; i--) {
			sb.append(s.charAt(i));
		}
	}
}
