import java.io.*;
import java.util.*;

public class Solution {
	
	static final int cases = 10;
	static final int length = 100;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= cases; t++) {
			int dumps = Integer.parseInt(br.readLine());
			int[] boxes = new int[length];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < length; i++) {
				boxes[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			int min = 101;
			int maxIndex = 0;
			int minIndex = 100;
			
			for (int i = 0; i < dumps; i++) {
				for (int j = 0; j < boxes.length; j++) {
					if (max < boxes[j]) {
						max = boxes[j];
						maxIndex = j;
					}
					
					if (min > boxes[j]) {
						min = boxes[j];
						minIndex = j;
					}
				}
				
				boxes[maxIndex]--;
				boxes[minIndex]++;
				max = 0;
				min = 101;
				maxIndex = 0;
				minIndex = 100;
			}
			
			for (int i = 0; i < boxes.length; i++) {
				if (max < boxes[i]) {
					max = boxes[i];
					maxIndex = i;
				}
				
				if (min > boxes[i]) {
					min = boxes[i];
					minIndex = i;
				}
			}
			
			System.out.println("#" + t + " " + (boxes[maxIndex] - boxes[minIndex]));
		}
		
	}
	
}