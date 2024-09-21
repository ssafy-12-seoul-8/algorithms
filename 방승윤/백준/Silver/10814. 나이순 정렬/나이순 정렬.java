import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        String[][] guest = new String[N][2];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	guest[i][0] = st.nextToken();
        	guest[i][1] = st.nextToken();
        }
        
        Arrays.sort(guest, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});
        
        for (int i = 0; i < N; i++) {
        	bw.write(guest[i][0] + " " + guest[i][1] + "\n");
        }
        
        bw.flush();
        
    }
    
}