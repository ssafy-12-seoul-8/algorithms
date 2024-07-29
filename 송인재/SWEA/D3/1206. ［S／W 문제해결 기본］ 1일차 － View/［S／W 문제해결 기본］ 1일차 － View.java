import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = 10;
		
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] buildings = new int[n];
			
			for (int i = 0; i < n; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;
			
			for (int i = 2; i < n - 2; i++) {
				int leftMax = Math.max(buildings[i - 2], buildings[i - 1]);
				int rightMax = Math.max(buildings[i + 2], buildings[i + 1]);
				
				if (buildings[i] - leftMax > 0 && buildings[i] > rightMax) {
					sum += buildings[i] - Math.max(leftMax, rightMax);
				}
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
	
}