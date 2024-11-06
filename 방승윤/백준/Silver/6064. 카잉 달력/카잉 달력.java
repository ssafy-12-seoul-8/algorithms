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
            st = new StringTokenizer(br.readLine());
            
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            int k = x;
            int tmp = x - 1;
            while(tmp != 0) {
            	if (y > tmp) {
            		y -= tmp;
            		tmp = 0;
            	} else {
            		tmp -= y;
            		y = N;
            	}
            }
            x = 1;
            
            if (y == 1) {
                sb.append(k).append("\n");
                continue;
            }
            
            while (y != 1 && k <= M * N) {
            	tmp = M;
            	
                while (tmp != 0) {
                	if (y > tmp) {
                		y -= tmp;
                		tmp = 0;
                	} else {
                		tmp -= y;
                		y = N;
                	}
                }
                
                k += M;
            }
            
            if (k <= M * N) {
                sb.append(k).append("\n");
            } else {
                sb.append("-1\n");
            }
            
        }
        
        System.out.println(sb);
        
    }
    
}