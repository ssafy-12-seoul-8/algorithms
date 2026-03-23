import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long sum = 0;
        st = new StringTokenizer(br.readLine());

        if (b <= c) {
            for (int i = 0; i < n; i++) {
                long a = Integer.parseInt(st.nextToken());
                sum += b * a;
            }
            System.out.println(sum);
            return;
        }


        int a1 = Integer.parseInt(st.nextToken());
        int dp1 = a1;
        sum += b * a1;
        int dp2 = 0;

        for (int i = 2; i <= n; i++) {
            int ai = Integer.parseInt(st.nextToken());
            int buy2 = Math.min(dp1, ai);
            ai -= buy2;

            int buy3 = Math.min(dp2, ai);
            ai -= buy3;

            dp1 = ai;
            dp2 = buy2;
            sum += b * dp1 + c * (buy2 + buy3);
        }

        System.out.println(sum);
    }
}
