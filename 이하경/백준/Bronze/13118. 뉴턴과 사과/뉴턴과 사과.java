import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        int p3 = Integer.parseInt(st.nextToken());
        int p4 = Integer.parseInt(st.nextToken());

        int[] p = { p1, p2, p3, p4 };

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 0; i < 4; i++) {
            if (x == p[i]) {
                ans = i + 1;
                break;
            }
        }

        System.out.println(ans);
    }
}
