import java.util.*;
import java.io.*;

public class Main {
  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int target = Integer.parseInt(br.readLine());
    int result = 0;
    int[] dp = new int[50001];

    for(int i = 0; i < 50001; i++) {
      dp[i] = Integer.MAX_VALUE;
    }

    dp[0] = 0;
    dp[1] = 1;

    for(int i = 1; i <= target; i++) {
      for(int j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
      }
    }
    
    result = dp[target];

    System.out.println(result);
  }
}