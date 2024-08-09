import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        
        int maxL = 0;
        for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			arr[l] = h;
			maxL = Math.max(maxL, l);
		}
        
        int max = 0;
        int maxIdxStart = 0;
        int maxIdxEnd = maxL;
        int cnt = 0;
        
        // 최댓값보다 앞부분의 넓이
        for (int i = 0; i <= maxL; i++) {
        	if (arr[i] > max) {
        		cnt += max * (i - maxIdxStart);
        		max = arr[i];
        		maxIdxStart = i;
        	}
        }

        // 최댓값보다 뒷부분의 넓이
        max = 0;
        for (int i = maxL; i >= maxIdxStart; i--) {
			if (arr[i] > max) {
				cnt += max * (maxIdxEnd - i);
				max = arr[i];
				maxIdxEnd = i;
			}
		}

        // 가장 큰 기둥의 넓이
        cnt += max * (maxIdxEnd - maxIdxStart + 1);
        
        System.out.println(cnt);
    }
   
}
