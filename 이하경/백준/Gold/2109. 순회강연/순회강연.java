import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return b[0] - a[0];
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.add(new int[]{ p, d });
        }

        boolean[] full = new boolean[10_001];

        int sum = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int day = curr[1];
            while (full[day]) {
                day--;
            }

            if (day == 0) {
                continue;
            }

            full[day] = true;
            sum += curr[0];
        }

        System.out.println(sum);
    }
}
