import java.io.*;

public class Solution {
	
	static final int cases = 10;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= cases; t++) {
			br.readLine();
			
			String str = br.readLine();
			String input = br.readLine();
			int count = 0;
			
			for (int i = 0; i < input.length() - str.length() + 1; i++) {
				if (input.substring(i, i + str.length()).equals(str)) {
					count++;
				}
			}
			
			System.out.println("#" + t + " " + count);
		}
	}

}