import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    static class Edge implements Comparable<Edge> {
        int v;
        int t;

        Edge(int v, int t) {
            this.v = v;
            this.t = t;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.t - edge.t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] conn = new ArrayList[N + 1];
        ArrayList<Edge>[] connRe = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            conn[i] = new ArrayList<>();
            connRe[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            conn[s].add(new Edge(v, w));
            connRe[v].add(new Edge(s, w));
        }

        int ans = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(X, 0));
        int[] time = new int[N + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[X] = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (curr.t > time[curr.v]) {
                continue;
            }

            for (Edge next : conn[curr.v]) {
                int nt = curr.t + next.t;

                if (time[next.v] <= nt) {
                    continue;
                }

                pq.add(new Edge(next.v, nt));
                time[next.v] = nt;
            }
        }

        pq = new PriorityQueue<>();
        pq.add(new Edge(X, 0));
        int[] timeRe = new int[N + 1];
        Arrays.fill(timeRe, Integer.MAX_VALUE);
        timeRe[X] = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (curr.t > timeRe[curr.v]) {
                continue;
            }

            for (Edge next : connRe[curr.v]) {
                int nt = curr.t + next.t;

                if (timeRe[next.v] <= nt) {
                    continue;
                }

                pq.add(new Edge(next.v, nt));
                timeRe[next.v] = nt;
            }
        }

        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, time[i] + timeRe[i]);
        }

        System.out.println(ans);
    }
}