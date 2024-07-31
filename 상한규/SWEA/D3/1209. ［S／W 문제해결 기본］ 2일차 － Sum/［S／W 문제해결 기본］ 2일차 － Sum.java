import java.io.*;
import java.util.*;

public class Solution {
	static int SIZE = 100;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		String line = br.readLine();
		
		while(line != null) {
			int T = Integer.parseInt(line);
			int result = 0;
			int[] colSumArray = new int[SIZE];
			int[] rowSumArray = new int[SIZE];
			int rightDownSumMax = 0;
			int leftDownSumMax = 0;
			int colSumMax = 0;
			int rowSumMax = 0;

			for(int j = 0; j < SIZE; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = 0; k < SIZE; k++) {
					int value = Integer.parseInt(st.nextToken());
					colSumArray[k] += value;
					rowSumArray[j] += value;
					if(j == k) {
						rightDownSumMax += value;
					}
					if(SIZE - 1 - j == k) {
						leftDownSumMax += value;
					}
				}
			}
			
			for(int i = 0; i < SIZE; i++) {
				colSumMax = Math.max(colSumMax, colSumArray[i]);
				rowSumMax = Math.max(rowSumMax, rowSumArray[i]);
			}

			int colRowMax =  Math.max(rowSumMax, colSumMax);
			int diagonalMax = Math.max(leftDownSumMax, rightDownSumMax);
			
			result = Math.max(colRowMax, diagonalMax);
			
			
			System.out.printf("#%d %d\n", T, result);
			line = br.readLine();
		}
	}
}
