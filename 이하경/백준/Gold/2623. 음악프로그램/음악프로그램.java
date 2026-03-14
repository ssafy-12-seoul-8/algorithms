import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Integer>[] next = new HashSet[n + 1];
        int[] prev = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            next[i] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            for (int j = 1; j < k; j++) {
                int p2 = Integer.parseInt(st.nextToken());
                if (!next[p1].contains(p2)) {
                    next[p1].add(p2);
                    prev[p2]++;
                }
                p1 = p2;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (prev[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            sb.append(curr).append("\n");
            for (int nxt:next[curr]) {
                prev[nxt]--;
                if (prev[nxt] == 0) {
                    q.add(nxt);
                }
            }
        }

        if (count != n) {
            System.out.println(0);
            return;
        }

        System.out.println(sb);
    }
}
