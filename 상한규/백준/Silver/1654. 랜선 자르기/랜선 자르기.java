import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] array = new int[K];
		int maxRight = 0;
		
		for(int i = 0; i < K; i++) {
			array[i] = Integer.parseInt(br.readLine());
			maxRight = Math.max(maxRight, array[i]);
		}
		
		long left = 0;
		long right = maxRight;
		
		while(left <= right) {
			long mid = (right + left) / 2;
			long count = 0;

			if(mid == 0) {
				left++;
				continue;
			}
			
			for(int i = 0; i < K; i++) {
				count += array[i] / mid;
			}

			if(count >= N) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(left - 1);
	}
}
