import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, rad;
    static ArrayList<Integer>[] edge;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        edge = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weigh = Integer.parseInt(st.nextToken());

            edge[parent].add(child);
            edge[parent].add(weigh);
        }
    }

    static void solve() {
        rad = 0;
        rad = Math.max(findRad(1), rad);
        System.out.println(rad);
    }

    static int findRad(int parent) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < edge[parent].size() / 2; i++) {
            pq.add(findRad(edge[parent].get(2 * i)) + edge[parent].get(2 * i + 1));
        }

        if (pq.isEmpty()) {
            return 0;
        }

        if (pq.size() == 1) {
            return pq.poll();
        }

        int m1 = pq.poll();
        int m2 = pq.poll();
        rad = Math.max(rad, m1 + m2);

        return m1;
    }
}

