import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] elevator = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            elevator[i][0] = Integer.parseInt(st.nextToken());
            elevator[i][1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int[][] prev = new int[n + 1][2];
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[m];

        dp[b] = 0;
        q.add(b);

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == a) {
                break;
            }

            for (int i = 0; i < m; i++) {
                if (!visit[i] & curr >= elevator[i][0] && (curr - elevator[i][0]) % elevator[i][1] == 0) {
                    visit[i] = true;
                    for (int j = elevator[i][0]; j <= n; j += elevator[i][1]) {
                        if (dp[j] == Integer.MAX_VALUE) {
                            dp[j] = dp[curr] + 1;
                            prev[j][0] = curr;
                            prev[j][1] = i;
                            q.add(j);
                        }
                    }
                }
            }
        }

        if (dp[a] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        
        sb.append(dp[a]).append("\n");
        int tmp = a;
        while (prev[tmp][0] != 0) {
            sb.append(prev[tmp][1] + 1).append("\n");
            tmp = prev[tmp][0];
        }

        System.out.println(sb);
    }
}
