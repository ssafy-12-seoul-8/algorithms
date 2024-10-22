import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] result;
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		recur(0, 0);
		System.out.println(sb);
	}
	
	public static void recur(int index, int count) {
		if(M == count) {
			
			for(int value : result) {
				sb.append(value).append(" ");
			}
			sb.append("\n");
			
			return;
		} else {
			for(int i = index; i < arr.length; i++) {
				result[count] = arr[i];
				recur(i, count + 1);
			}
		}
	}
}
