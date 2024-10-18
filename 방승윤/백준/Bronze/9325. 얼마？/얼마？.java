import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < T; tc++) {
        	
        	int s = Integer.parseInt(br.readLine());
        	int n = Integer.parseInt(br.readLine());
        	
        	for (int i = 0; i < n; i++) {
        		st = new StringTokenizer(br.readLine());
        		int q = Integer.parseInt(st.nextToken());
        		int p = Integer.parseInt(st.nextToken());
        		
        		s += q * p;
        	}
        	
        	sb.append(s).append("\n");
        	
        }
        
        System.out.println(sb);
        
    }

}