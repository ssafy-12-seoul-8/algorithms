import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] candy = new int[n + 1];
        ArrayList<Integer>[] friend = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            friend[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a].add(b);
            friend[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        ArrayList<int[]> kidCandy = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                int count = 0;
                int candyCount = 0;
                q.add(i);
                visit[i] = true;

                while (!q.isEmpty()) {
                    int curr = q.poll();
                    candyCount += candy[curr];
                    count++;

                    for (int next:friend[curr]) {
                        if (visit[next]) {
                            continue;
                        }

                        visit[next] = true;
                        q.add(next);
                    }
                }

                if (count < k) {
                    kidCandy.add(new int[]{ count, candyCount});
                }
            }
        }

        int[] dp = new int[k]; // dp[i] => i명한테 뺏을수있는 최댓값
        for (int i = 0; i < kidCandy.size(); i++) {
            int kid = kidCandy.get(i)[0];
            int can = kidCandy.get(i)[1];

            for (int j = k - 1; j >= kid; j--) {
                dp[j] = Math.max(dp[j], dp[j - kid] + can);
            }
        }

        System.out.println(dp[k - 1 ]);
    }
}
