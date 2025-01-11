import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Time>[] nodes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a].add(new Time(b, 0, i));
            nodes[b].add(new Time(a, 0, i));
        }

        PriorityQueue<Time> pq = new PriorityQueue<>();
        boolean[] check = new boolean[n + 1];
        pq.add(new Time(1, 0, 0));

        while (!pq.isEmpty()) {
            Time curr = pq.poll();

            if (curr.node == n) {
                System.out.println((long) m * curr.cycle + curr.second);
                return;
            }

            if (check[curr.node]) {
                continue;
            }
            check[curr.node] = true;

            for (Time next : nodes[curr.node]) {
                if (check[next.node]) {
                    continue;
                }

                if (next.second > curr.second) {
                    pq.add(new Time(next.node, curr.cycle, next.second));
                    continue;
                }
                pq.add(new Time(next.node, curr.cycle + 1, next.second));
            }
        }
    }

    static class Time implements Comparable<Time> {
        int node;
        int cycle;
        int second;

        public Time(int node, int cycle, int second) {
            this.node = node;
            this.cycle = cycle;
            this.second = second;
        }

        @Override
        public int compareTo(Time o) {
            if (this.cycle == o.cycle) {
                return this.second - o.second;
            }
            return this.cycle - o.cycle;
        }
    }
}
