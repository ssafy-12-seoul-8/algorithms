import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] count = new int[10];
		
		while (n > 0) {
			count[n % 10]++;
			n /= 10;
		}
		
		count[6] = (count[6] + count[9] + 1) / 2;

		int max = 0;

		for (int i = 0; i < 9; i++) {
			max = Math.max(max, count[i]);
		}

		System.out.println(max);

	}
}
