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

        public int compareTo(Edge edge) {
            return this.w - edge.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] conn = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            conn[Integer.parseInt(st.nextToken())].add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int max = 0;
        PriorityQueue<Edge> pq;
        int[] cost;
        int a = 0;
        int b = 0;

        for (int i = 1; i <= N; i++) {
            pq = new PriorityQueue<>();
            pq.add(new Edge(i, 0));
            cost = new int[N + 1];
            Arrays.fill(cost, Integer.MAX_VALUE);
            a = 0;

            while (!pq.isEmpty()) {
                Edge curr = pq.poll();

                if (curr.v == X) {
                    a = curr.w;
                    break;
                }

                if (curr.w > cost[curr.v]) {
                    continue;
                }

                for (Edge next : conn[curr.v]) {
                    int newW = curr.w + next.w;

                    if (cost[next.v] > newW) {
                        cost[next.v] = newW;
                        pq.add(new Edge(next.v, newW));
                    }
                }
            }

            pq = new PriorityQueue<>();
            pq.add(new Edge(X, 0));
            Arrays.fill(cost, Integer.MAX_VALUE);
            b = 0;

            while (!pq.isEmpty()) {
                Edge curr = pq.poll();

                if (curr.v == i) {
                    b = curr.w;
                    break;
                }

                if (curr.w > cost[curr.v]) {
                    continue;
                }

                for (Edge next : conn[curr.v]) {
                    int newW = curr.w + next.w;

                    if (cost[next.v] > newW) {
                        cost[next.v] = newW;
                        pq.add(new Edge(next.v, newW));
                    }
                }
            }

            max = Math.max(max, a + b);
        }

        System.out.println(max);

    }
}