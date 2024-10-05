import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); 
		int[] cntLevel = new int[31];
		int level = 0;
		
		for (int i = 0; i < N; i++) {
			cntLevel[Integer.parseInt(br.readLine())]++;
		}
		
		int lower = (int) Math.round(N * 0.15);
		int upper = N - 2 * lower;
		int cnt = 0;
		int idx = 1;
		
		while (true && N != 0) {
			if (cntLevel[idx] <= lower) {
				lower -= cntLevel[idx++];
			} else {
				cnt += cntLevel[idx] - lower;
				level += idx * (cntLevel[idx] - lower);
				lower = 0;
				
				if (cnt >= upper) {
					level -= idx * (cnt - upper);
					break;
				}
				
				idx++;
			}
			
			
		}
		
		System.out.println(Math.round((double) level / upper));

	}

}