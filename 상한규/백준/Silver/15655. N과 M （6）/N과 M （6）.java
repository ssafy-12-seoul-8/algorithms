import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		recur(0, 0, M);
	}
	public static void recur(int index, int current, int count) {
		if(count == current) {
			for(int value : result) {
				System.out.print(value + " ");
			}
			System.out.println();
			
			return;
		} else {
			for(int i = index; i < arr.length; i++) {
				result[current] = arr[i];
				recur(i + 1, current + 1, count);
			}
		}
	}
}
