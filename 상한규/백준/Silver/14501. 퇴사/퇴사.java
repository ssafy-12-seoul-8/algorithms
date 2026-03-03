import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      int N = Integer.parseInt(br.readLine());
      int[] TArray = new int[N];
      int[] PArray = new int[N];
      int[] dp = new int[N+1];

      for(int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        TArray[i] = Integer.parseInt(st.nextToken());
        PArray[i] = Integer.parseInt(st.nextToken());
      }

      for(int i = 0; i < N; i++) {
        if (i + TArray[i] <= N) {
                dp[i + TArray[i]] = Math.max(dp[i + TArray[i]], dp[i] + PArray[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
      }

      System.out.println(dp[N]);
    }
}