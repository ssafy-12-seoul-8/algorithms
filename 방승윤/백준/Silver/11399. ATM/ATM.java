import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(P);
		
		int sum = P[0];
		
		for (int i = 1; i < N; i++) {
			P[i] += P[i - 1];
			sum += P[i];
		}
		
		System.out.println(sum);
		
	}
	
}