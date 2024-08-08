import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		
		for (int i = 1; i <= n; i++) {
			String number = String.valueOf(i);
			int sum = i;
			
			for (int j = 0; j < number.length(); j++) {
				sum += (number.charAt(j) - '0');
			}
			
			if (sum == n) {
				result = i;
				
				break;
			}
		}
		
		System.out.println(result);
	}
	
}