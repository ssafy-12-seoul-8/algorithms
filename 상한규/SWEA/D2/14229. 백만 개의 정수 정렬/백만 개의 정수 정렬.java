import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = 1;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] stringArray = br.readLine().split(" ");
			
			int[] array = new int[stringArray.length];

			for(int i = 0; i < stringArray.length; i++) {
				array[i] = Integer.parseInt(stringArray[i]);
			}
			
			Arrays.sort(array);
			
			System.out.println(array[500000]);
		}
	}
}
