import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int as = Integer.parseInt(st.nextToken());
        int ae = Integer.parseInt(st.nextToken());
        int bs = Integer.parseInt(st.nextToken());
        int be = Integer.parseInt(st.nextToken());
        int cs = Integer.parseInt(st.nextToken());
        int ce = Integer.parseInt(st.nextToken());

        String ans = "YES";
        int time = 1440 + ae - k;
        while (n-- > 0) {
            if (time + k < 1440 + as) {
                ans = "NO";
                break;
            }
            time = Math.min(ae, (time + k) % 1440);

            if (time + k < bs) {
                ans = "NO";
                break;
            }
            time = Math.min(be, time + k);

            if (time + k < cs) {
                ans = "NO";
                break;
            }
            time = Math.min(ce, time + k);
        }

        System.out.println(ans);
    }
}
