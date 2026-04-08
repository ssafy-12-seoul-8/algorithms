import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dp;
    static int[][] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        price = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[1 << n]; // n 이후로 비트 만드는 최소비용
        System.out.println(find(0));
    }

    public static int find(int visit) {
        int now = Integer.bitCount(visit);
        
        if (now == n) {
            return 0;
        }

        if (dp[visit] != 0) {
            return dp[visit];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if ((visit & (1 << i)) != 0) {
                continue;
            }

            min = Math.min(min, find(visit | (1 << i)) + price[now][i]);
        }

        return dp[visit] = min;
    }
}
