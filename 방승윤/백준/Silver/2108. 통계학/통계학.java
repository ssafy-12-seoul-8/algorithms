import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[8001];
        int[] arr = new int[N];
        int maxCnt = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double total = 0;
        
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	max = Math.max(max, arr[i]);
        	min = Math.min(min, arr[i]);
        	cnt[arr[i] + 4000]++;
        	maxCnt = Math.max(maxCnt, cnt[arr[i] + 4000]);
        	total += arr[i];
        }
        
        bw.write((int) Math.round(total / N) + "\n");
        
        Arrays.sort(arr);
        
        bw.write(arr[N / 2] + "\n");
        
        int modeCnt = 0;
        int mode = 0;
        
        for (int i = 0; i < 8001; i++) {
        	if (cnt[i] == maxCnt) {
        		mode = i - 4000;
        		modeCnt++;
        	}
        	
        	if (modeCnt == 2) {
        		break;
        	}
        }
        
        bw.write(mode + "\n");
        bw.write(max - min + "\n");
        bw.flush();
        
    }
    
}