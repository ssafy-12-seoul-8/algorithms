import java.io.*;
import java.util.*;

public class Solution {
	static public int SIZE = 100;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = 10;
		
		for(int i = 0; i < T; i++) {
			int result = 0;
			int testNumber = Integer.parseInt(br.readLine());
			String answerString = br.readLine();
			String testString = br.readLine();

			int temp = (int)answerString.charAt(0);
			testString = temp + testString + temp;
			
			String[] testArray = testString.split(answerString);

			result = testArray.length - 1;
			
			System.out.printf("#%d %d\n", testNumber, result);
		}
	}
}
