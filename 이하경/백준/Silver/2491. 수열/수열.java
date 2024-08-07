import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int prev = Integer.parseInt(st.nextToken());
		boolean isIncreasing = true;
		int s = 0;
		int max = 1;
		int sameFrom = 0;
		
		for (int i = 1; i < n; i++) {
			int next = Integer.parseInt(st.nextToken());
			if (isIncreasing) {
				if (next < prev) {
					max = Math.max(max, i - s);
					s = sameFrom;
					isIncreasing = false;
				}
			} else {
				if (next > prev) {
					max = Math.max(max, i - s);
					s = sameFrom;
					isIncreasing = true;
				}
			}
			
			if (prev != next) {
				sameFrom = i;
			}
			
			prev = next;
			
		}
		max = Math.max(max, n - s);

		System.out.println(max);

	}

}