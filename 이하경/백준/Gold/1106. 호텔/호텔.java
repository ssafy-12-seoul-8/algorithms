import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[c + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int add = Integer.parseInt(st.nextToken());

            for (int j = 0; j <= Math.min(add, c); j++) {
                dp[j] = Math.min(dp[j], cost);
            }

            for (int j = add + 1; j <= c; j++) {
                dp[j] = Math.min(dp[j], dp[j - add] + cost);
            }
        }

        System.out.println(dp[c]);
    }
}
