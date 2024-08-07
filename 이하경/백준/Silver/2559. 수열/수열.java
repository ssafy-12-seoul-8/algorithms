import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] temp = new int[n];
		
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
			sum += temp[i];
		}

		int max = sum;
		
		for (int i = k; i < n ; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
			sum += temp[i] - temp[i - k];
			max = Math.max(max, sum);
		}
		
		System.out.println(max);

	}

}