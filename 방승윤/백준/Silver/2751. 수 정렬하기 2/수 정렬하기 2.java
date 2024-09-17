import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2_000_001];
        
        for (int i = 0; i < N; i++) {
        	arr[Integer.parseInt(br.readLine()) + 1_000_000] = true;
        }

        for (int i = 0; i <= 2_000_000; i++) {
        	if (arr[i]) {
        		bw.write(i - 1_000_000 + "\n");        		
        	}
        }

        bw.flush();

    }

}