import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static class Edge implements Comparable<Edge> {
        int v;
        int w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] conn = new ArrayList[100001];

        for (int i = 0; i <= 100000; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i <= 100000; i++) {
            if (i < 100000) {
                conn[i].add(new Edge(i + 1, 1));
            }

            if (i > 0) {
                conn[i].add(new Edge(i - 1, 1));
            }

            if (i == 0) {
                continue;
            }

            for (int j = i; j <= 100000; j *= 2) {
                conn[i].add(new Edge(j, 0));
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] time = new int[100001];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[N] = 0;
        pq.add(new Edge(N, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (curr.v == K) {
                break;
            }

            if (curr.w > time[curr.v]) {
                continue;
            }

            for (Edge next : conn[curr.v]) {
                int newTime = curr.w + next.w;

                if (newTime < time[next.v]) {
                    time[next.v] = newTime;
                    pq.add(new Edge(next.v, newTime));
                }
            }
        }

        System.out.println(time[K]);
    }
}