import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] lan = new int[n][n];
        int totalLen = 0;

        for (int i = 0; i < n; i++) {
            String lans = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = lans.charAt(j);
                if (c >= 'a' && c <= 'z') {
                    lan[i][j] = c - 'a' + 1;
                    totalLen += lan[i][j];
                    continue;
                }
                if (c >= 'A' && c <= 'Z') {
                    lan[i][j] = c - 'A' + 27;
                    totalLen += lan[i][j];
                }
            }
        }

        int count = 0;
        boolean[] visit = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{ 0, 0 });

        while (count < n && !pq.isEmpty()) {
            int[] curr = pq.poll();

            if (visit[curr[0]]) {
                continue;
            }
            visit[curr[0]] = true;
            totalLen -= curr[1];
            count++;

            for (int i = 1; i < n; i++) {
                if (!visit[i] && i != curr[0]) {
                    if (lan[curr[0]][i] != 0) {
                        pq.add(new int[]{ i, lan[curr[0]][i] });
                    }
                    if (lan[i][curr[0]] != 0) {
                        pq.add(new int[]{ i, lan[i][curr[0]] });
                    }
                }
            }
        }

        System.out.println(count != n ? -1 : totalLen);
    }
}
