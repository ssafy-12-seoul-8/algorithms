import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < N; i++) {
    		String str = br.readLine();
    		
    		if (!str.equals("Never gonna give you up") && !str.equals("Never gonna let you down") && !str.equals("Never gonna run around and desert you") && !str.equals("Never gonna make you cry") && !str.equals("Never gonna say goodbye") && !str.equals("Never gonna tell a lie and hurt you") && !str.equals("Never gonna stop")) {
    			System.out.print("Yes");
    			break;
    		} else if (i == N - 1) {
    			System.out.print("No");
    		}
    	}
    	
    }
    
}