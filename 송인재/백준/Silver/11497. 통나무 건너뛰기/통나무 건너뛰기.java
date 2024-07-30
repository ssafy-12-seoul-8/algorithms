import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] nums = new int[n];
			int[] optimized = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			int front = 0;
			int rear = n - 1;
			
			for (int j = 0; j < n; j++) {
				if (j % 2 == 0) {
					optimized[front++] = nums[j];
				}
				
				if (j % 2 == 1) {
					optimized[rear--] = nums[j];
				}
			}
			
			int max = 0;
			
			for (int j = 1; j < n - 1; j++) {
				int temp = Math.max(Math.abs(optimized[j - 1] - optimized[j]), Math.abs(optimized[j + 1] - optimized[j]));
				max = Math.max(max, temp);
			}
			
			System.out.println(max);
		}
	}
	
}
