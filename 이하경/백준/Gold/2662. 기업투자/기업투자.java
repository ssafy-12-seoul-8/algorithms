import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] profit = new int[m][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for (int j = 0; j < m; j++) {
                profit[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dp = new int[n + 1];
        ArrayList<Integer>[] track = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            track[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            for (int j = n; j >= 0; j--) {
                boolean pick = false;
                for (int k = 1; k <= n; k++) {
                    if (j < k) {
                        break;
                    }
                    if (dp[j] < dp[j - k] + profit[i][k]) {
                        dp[j] = dp[j - k] + profit[i][k];
                        track[j] = new ArrayList<>();
                        track[j].addAll(track[j - k]);
                        track[j].add(k);
                        pick = true;
                    }
                }
                if (!pick) {
                    track[j].add(0);
                }
            }
        }

        sb.append(dp[n]).append("\n");
        for (int i : track[n]) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
