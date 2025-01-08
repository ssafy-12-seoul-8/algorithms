import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[7];
        long total = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String type = Character.toString(s.charAt(0));
            int q = s.length();
            s = s.replace(type, "");
            int check = s.length();

            if (check != 0) {
                cnt[0] += q;
                continue;
            }

            switch (type) {
            case "O":
                cnt[0] += q;
                break;
            case "P":
                cnt[1] += q;
                break;
            case "C":
                cnt[2] += q;
                break;
            case "V":
                cnt[3] += q;
                break;
            case "S":
                cnt[4] += q;
                break;
            case "G":
                cnt[5] += q;
                break;
            case "F":
                cnt[6] += q;
                break;
            }
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] cost = new int[7];
        
        for (int i = 1; i <= 6; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        cost[0] = Integer.parseInt(br.readLine());
        
        for (int i = 0; i <= 6; i++) {
            if (cost[i] > cost[0]) {
                total += cost[0] * cnt[i];
                continue;
            }
            
            total += (long) cost[i] * cnt[i];
        }
        
        System.out.println(total);
        
    }
}