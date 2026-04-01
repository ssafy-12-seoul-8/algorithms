import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new int[]{ start, 1 });
            pq.add(new int[]{ end + 1, -1 });
        }

        int q = Integer.parseInt(br.readLine());
        int[][] queries = new int[q][3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            queries[i][0] = i;
            queries[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(queries, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        for (int i = 0; i < q; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= queries[i][1]) {
                count += pq.poll()[1];
            }

            queries[i][2] = count;
        }

        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < q; i++) {
            sb.append(queries[i][2]).append("\n");
        }

        System.out.println(sb);
    }
}
