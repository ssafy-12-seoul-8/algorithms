import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        boolean[] mobis = new boolean[5];
        
        for (int i = 0; i < str.length(); i++) {
        	switch (str.charAt(i)) {
        	case 'M':
        		mobis[0] = true;
        		break;
        	case 'O':
        		mobis[1] = true;
        		break;
        	case 'B':
        		mobis[2] = true;
        		break;
        	case 'I':
        		mobis[3] = true;
        		break;
        	case 'S':
        		mobis[4] = true;
        		break;
        	}
        }
        
        for (int i = 0; i < 5; i++) {
        	if (!mobis[i]) {
        		System.out.print("NO");
        		break;
        	} else if (i == 4) {
        		System.out.print("YES");
        	}
        }
    
    }

}