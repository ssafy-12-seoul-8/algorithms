import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int rMin = 0;
		int rMax = (int) Math.pow(2, N) - 1;
		int cMin = 0;
		int cMax = (int) Math.pow(2, N) - 1;
		int L = 0;
		int R = (int) Math.pow(2, 2 * N) - 1;
		int mid = 0;
		int rMid;
		int cMid;
		
		while (L < R) {
			mid = (L + R) / 2;
			rMid = (rMax + rMin) / 2;
			cMid = (cMax + cMin) / 2;
			
			if (r <= rMid) {
				rMax = rMid;
				R = mid;
			} else {
				rMin = rMid + 1;
				L = mid + 1;
			}
			
			mid = (L + R) / 2;
			
			if (c <= cMid) {
				cMax = cMid;
				R = mid;
			} else {
				cMin = cMid + 1;
				L = mid + 1;
			}
		}
		
		System.out.print(L);
		
	}
	
}