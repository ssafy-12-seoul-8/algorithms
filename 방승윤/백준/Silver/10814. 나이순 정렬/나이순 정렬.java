import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        StringBuilder[] sb = new StringBuilder[201];

        for (int i = 0; i < sb.length; i++) {
        	sb[i] = new StringBuilder();
        }
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int age = Integer.parseInt(st.nextToken());
        	sb[age].append(age).append(" ").append(st.nextToken()).append("\n");
        }
        
        for (int i = 1; i <= 200; i++) {
        	bw.write(sb[i].toString());
        }
        
        bw.flush();
        
    }
    
}