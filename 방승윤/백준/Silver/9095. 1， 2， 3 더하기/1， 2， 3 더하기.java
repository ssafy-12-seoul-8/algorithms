import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[11];
		
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = arr[0] + arr[1];
		
		for (int i = 3; i < 11; i++) {
			arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
		}
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(arr[N]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}