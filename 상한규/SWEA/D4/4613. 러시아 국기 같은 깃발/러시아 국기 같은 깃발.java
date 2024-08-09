import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int result = 0;
			int middleSum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] colorCount = new int[N][3];

			for (int j = 0; j < N; j++) {
				char[] tempArray = br.readLine().toCharArray();
				for (int k = 0; k < M; k++) {
					if(tempArray[k] == 'W') {
						colorCount[j][0]++;
					} else if(tempArray[k] == 'B') {
						colorCount[j][1]++;
					} else {
						colorCount[j][2]++;
					}
				}
			}
			
			for (int j = 0; j < N; j++) {
				if(j == 0) {
					result += M - colorCount[j][0];
				} else if(j == N - 1) {
					result += M - colorCount[j][2];
				} else {
					
					for(int k = 0; k < N - 2 - j + 1; k++) {
						int whiteSum = 0;
						int blueSum = 0;
						int redSum = 0;
						
						for(int l = 1; l < j; l++) {
							whiteSum += colorCount[l][0];
						}
						
						for(int l = j; l <= j + k; l++) {
							blueSum += colorCount[l][1];
						}
						
						for(int l = j + k + 1; l < N - 1; l++) {
							redSum += colorCount[l][2];
						}
						middleSum = Math.max(middleSum, whiteSum + blueSum + redSum);
					}
				}
			}
			
			result += ((N - 2) * M - middleSum);
			
			System.out.printf("#%d %d\n", i + 1, result);
		}
	}
}