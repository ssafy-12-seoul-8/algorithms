import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] array = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		int left = 0;
		int right = array[N - 1];
		
		while(left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;
			for(int i = 0; i < N; i++) {
				if(array[i] > mid) {
					sum += array[i] - mid;
				}
			}
			if(sum >= M) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(left - 1);
	}
}
