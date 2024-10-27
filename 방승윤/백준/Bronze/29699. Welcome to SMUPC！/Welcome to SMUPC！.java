import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = "WelcomeToSMUPC";
        int N = (Integer.parseInt(br.readLine()) - 1) % str.length();

        System.out.print(str.charAt(N));
        
    }
}
