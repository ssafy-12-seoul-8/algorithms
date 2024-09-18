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
        int[] arr = new int[N];
        int[] cnt = new int[N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i] = Integer.parseInt(st.nextToken()) * 1000 + Integer.parseInt(st.nextToken());
        	
        	for (int j = 0; j < i; j++) {
        		if (arr[i] / 1000 > arr[j] / 1000 && arr[i] % 1000 > arr[j] % 1000) {
        			cnt[j]++;
        		} else if (arr[j] / 1000 > arr[i] / 1000 && arr[j] % 1000 > arr[i] % 1000) {
        			cnt[i]++;
        		}
        	}
        }
        
        for (int i : cnt) {
        	bw.write(i + 1 + " ");
        }
        
        bw.flush();
        
    }
    
}