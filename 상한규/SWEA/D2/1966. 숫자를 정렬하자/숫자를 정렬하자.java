import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] array = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			String result = "";
			
			for(int j = 0; j < N; j++) {
				array[j] = Integer.parseInt(st.nextToken());
			}

			sort(2, array);
			
			for(int j = 0; j < array.length; j++) {
				result += array[j] + " ";
			}
			
			System.out.printf("#%d %s\n", i + 1, result);
		}
	}
	static void sort(int sortIndex, int[] array) {
		// 0: bubble, 1: select, 2: count
		switch (sortIndex) {
			case 0: {
				for(int i = array.length - 1; i >= 0; i--) {
					for(int j = 0; j < i; j++) {
						if(array[j] >= array[j + 1]) {
							int temp = array[j];
							array[j] = array[j + 1];
							array[j + 1] = temp;
						}
					}
				}
				break;
			}
			case 1: {
				for(int i = 0; i < array.length - 1; i++) {
					for(int j = i; j < array.length; j++) {
						if(array[i] > array[j]) {
							int temp = array[i];
							array[i] = array[j];
							array[j] = temp;
						}
					}
				}
				break;
			}
			case 2: {
				int maxIndex = 0;
				for(int i = 0; i < array.length; i++) {
					maxIndex = Math.max(maxIndex, array[i]);
				}
			
				int[] tempArray = new int[maxIndex + 1];
				int[] result = new int[array.length];
				
				for(int i = 0; i < array.length; i++) {
					tempArray[array[i]]++;
				}
				
				for(int i = 1; i < tempArray.length; i++) {
					tempArray[i] += tempArray[i - 1];
				}
				
				for(int i = array.length - 1; i >= 0; i--) {
					result[--tempArray[array[i]]] = array[i];
				}
				
				for(int i = 0; i < array.length; i++) {
					array[i] = result[i];
				}
			}
			break;
		}
	}
}


/* 실행시간 비교
 * 0 bubble
 * 2100.0
 * 1799.0
 * 2799.0
 * 4800.0
 * 7699.0
 * 10701.0
 * 14699.0
 * 22700.0
 * 26400.0
 * 30201.0
 * 
 * 1 select
 * 1900.0
 * 1899.0
 * 3500.0
 * 5300.0
 * 6900.0
 * 10500.0
 * 13000.0
 * 17200.0
 * 20699.0
 * 23800.0
 *  
 *  2 count
 *  9400.0
 *  2100.0
 *  2200.0
 *  2300.0
 *  3100.0
 *  3300.0
 *  3900.0
 *  10801.0
 *  5299.0
 *  4500.0
 *  
 */
