import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int testCaseCount = Integer.parseInt(br.readLine());

		for(int i = 0; i<testCaseCount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int [][]array = generateArray(br, N);

			int max = 0;
			for(int x=0;x<N;x++) {
				for(int y=0;y<N;y++) {
					int sumPlus = sumOfMByPlus(array, x, y, M-1);
					int sumX = sumOfMByX(array, x, y, M-1);
					int maxSum = sumPlus>sumX?sumPlus:sumX;
					max = maxSum>max?maxSum:max;
				}
			}
			
			System.out.println("#"+(i+1)+" "+max);
		}
	}
	

	public static int[][] generateArray(BufferedReader br, int size) throws IOException {

		int[][]array = new int[size][size];
		
		for(int j = 0; j<size; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int k = 0; k<size; k++) {					
				int value = Integer.parseInt(st.nextToken());
				array[j][k] = value; 
			}
		}
		return array;
	}
	
	public static int sumOfMByPlus(int[][]array, int x, int y, int M ) {
		int sum = 0;
		for(int j=x-M; j<=x+M; j++) {
			if(j>=0 && j<array.length) {
				sum+=array[j][y];
			}
		}
		for(int k=y-M;k<=y+M;k++) {
			if(k>=0 && k<array.length) {
				sum+=array[x][k];
			}
		}
		sum-=array[x][y];
		return sum;
	}
	
	public static int sumOfMByX(int[][]array, int x, int y, int M ) {
		int sum = 0;
		
		for(int i = -M; i<=M; i++) {
			if(x+i>=0 && x+i<array.length && y+i>=0 && y+i<array.length) {
				sum+=array[x+i][y+i];
			}
			if(x+i>=0 && x+i<array.length && y-i>=0 && y-i<array.length) {
			sum+=array[x+i][y-i];
			}
		}
		sum-=array[x][y];
		return sum;
	}
}