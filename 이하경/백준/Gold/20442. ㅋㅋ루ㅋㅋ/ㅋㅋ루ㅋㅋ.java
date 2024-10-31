import java.io.BufferedReader;
import java.io.InputStreamReader;

// [left, right] 범위에 있는 R의 개수를 센다
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] str = br.readLine().toCharArray();

		int cntR = 0;
		for (char c : str) {
			if (c == 'R') {
				cntR++;
			}
		}

		int left = 0;
		int leftK = 0;
		int right = str.length - 1;
		int rightK = 0;
		int max = cntR;

		while (cntR > 0) {
			if (leftK < rightK) {
				if (str[left] == 'K') {
					leftK++;
				} else {
					cntR--;
				}
				max = Math.max(max, 2 * Math.min(leftK, rightK) + cntR);
				left++;
				continue;
			}

			if (str[right] == 'K') {
				rightK++;
			} else {
				cntR--;
			}
			max = Math.max(max, 2 * Math.min(leftK, rightK) + cntR);
			right--;
		}

		System.out.println(max);
	}
}
