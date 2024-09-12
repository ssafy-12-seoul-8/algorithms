import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int resultValue = 0;
		
		for(int i = 0; i < 3; i ++) {
			String text = br.readLine();
			
			if(text.charAt(0) >= 'A' && text.charAt(0) <= 'z') {
				continue;
			} else {
				int value = Integer.parseInt(text);
				
				resultValue = value + (3 - i);
				break;
			}
		}		
		
		if(resultValue % 3 == 0 && resultValue % 5 == 0) {
			System.out.println("FizzBuzz");
		} else if(resultValue % 3 == 0) {
			System.out.println("Fizz");
		} else if(resultValue % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(resultValue);
		}
	}
}