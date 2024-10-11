import java.io.BufferedReader;
import java.io.InputStreamReader;

// K&((~K)+1) = 가장 작은 자릿수의 1만 찍혀있음
// K-K&((~K)+1) = 가장 작은 자릿수의 1을 삭제한다 -> 1의 개수가 정답

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();

		char[] k = br.readLine().toCharArray();
		int cnt = 0;

		for (char c : k) {
			if (c == '1') {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
