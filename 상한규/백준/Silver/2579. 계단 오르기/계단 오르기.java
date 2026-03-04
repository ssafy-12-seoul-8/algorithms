import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int[] stair;
        int[] dp;
        
        n = Integer.parseInt(br.readLine());
        stair = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(stair[1]);
            return;
        }

        dp[1] = stair[1];
        if (n >= 2) {
            dp[2] = stair[1] + stair[2];
        }

        for (int i = 3; i <= n; i++) {
            int jumpTwo = dp[i - 2] + stair[i];
            int jumpOne = dp[i - 3] + stair[i - 1] + stair[i];
            
            if (jumpTwo > jumpOne) {
                dp[i] = jumpTwo;
            } else {
                dp[i] = jumpOne;
            }
        }

        System.out.println(dp[n]);
    }
}