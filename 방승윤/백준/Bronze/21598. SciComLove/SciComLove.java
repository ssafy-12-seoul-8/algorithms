import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	if (Integer.parseInt(br.readLine()) == 1) {
    		System.out.println("SciComLove\n");
    	} else {
    		System.out.println("SciComLove\nSciComLove");
    	}
    	
    }
    
}
