import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] result = new int['z' - 'a' + 1];
		String text = br.readLine();
		int count = 0;
		StringBuilder sb = new StringBuilder();
		
		Arrays.fill(result, -1);
		
		for(int i = 0; i < text.length(); i++) {
			int index = text.charAt(i) - 'a';
			if(result[index] != -1) {
				count++;
			} else {				
				result[index] = count++;
			}
		}
		
		for(int value : result) {
			sb.append(value).append(" ");
		}
		System.out.println(sb);
	}
}