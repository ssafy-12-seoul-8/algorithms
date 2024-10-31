import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] array = new int[N];
		int maxValue = 0;
		
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			maxValue = Math.max(maxValue, array[i]);
		}
		
		long left = 0;
		long right = maxValue;
		int budget = Integer.parseInt(br.readLine());
		
		while(left <= right) {
			long mid = (right + left) / 2;
			long sum = 0;
			
			for(int i = 0; i < N; i++) {
				sum += Math.min(mid, array[i]);
			}
			
			if(budget >= sum) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(left - 1);
	}
}
