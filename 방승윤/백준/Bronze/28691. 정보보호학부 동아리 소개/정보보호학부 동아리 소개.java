import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	switch (br.readLine()) {
    	case "M":
    		System.out.println("MatKor");
    		break;
    	case "W":
    		System.out.println("WiCys");
    		break;
    	case "C":
    		System.out.println("CyKor");
    		break;
    	case "A":
    		System.out.println("AlKor");
    		break;
    	case "$":
    		System.out.println("$clear");
    		break;
		}
    	
    }
    
}