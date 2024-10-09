import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), ",");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < K; i++) {
			N--;
			
			for (int j = 0; j < N; j++) {
				arr[j] = arr[j + 1] - arr[j];
			}
		}
			
		
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]);
			
			if (i != N - 1) {
				sb.append(",");
			}
		}
		
		System.out.println(sb);
		
	}
	
}