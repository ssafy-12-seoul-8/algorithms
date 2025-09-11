import java.util.*;
import java.io.*;

public class Main {
  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int target = Integer.parseInt(br.readLine());
    int[] dp = new int[1001];
    
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;

    for(int i = 3; i <= target; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
    }

    System.out.println(dp[target] % 10007);
  }
}