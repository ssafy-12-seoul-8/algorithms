import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] array;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		array = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			int lowerIndex = lowerBound(target);
			int upperIndex = upperBound(target);
			
			if(lowerIndex == -1 && upperIndex == -1) {
				sb.append(0).append(" ");
			} else {
				sb.append(upperIndex - lowerIndex  + 1).append(" ");
			}
		}
		
		System.out.println(sb);
	}
	
	public static int lowerBound(int target) {
		int left = 0;
		int right = N - 1;
		int lowerIndex = -1;
		
		while(left <= right) {
			int mid = (right + left) / 2;
			
			if(array[mid] == target) {
				lowerIndex = mid;
			}
			
			if(array[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return lowerIndex;
	}
	
	public static int upperBound(int target) {
		int left = 0;
		int right = N - 1;
		int upperIndex = -1;
		
		while(left <= right) {
			int mid = (right + left) / 2;
			
			if(array[mid] == target) {
				upperIndex = mid;
			}
			
			if(array[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return upperIndex;
	}
}
