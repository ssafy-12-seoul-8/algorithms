import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = Integer.parseInt(br.readLine());
		int[] resultArray = new int[T];
		StringTokenizer st = new StringTokenizer(br.readLine());

		resultArray[0] = Integer.MAX_VALUE;
		for(int i = 0; i < T; i++) {
			int currentNumber = Integer.parseInt(st.nextToken());

			for(int j = 0; j < T; j++) {
				if(currentNumber <= resultArray[j]) {
					for(int k = T - 1; k > j; k--) {
						resultArray[k] = resultArray[k - 1];
					}
					resultArray[j] = currentNumber;
					break;
				}
			}
		}
		System.out.println(resultArray[(resultArray.length / 2)]);
	}
}
