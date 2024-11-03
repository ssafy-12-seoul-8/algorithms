import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        double[][] stars = new double[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o.dist));
        boolean[] visit = new boolean[n];

        visit[0] = true;
        int pick = 1;
        double sum = 0;
        for (int i = 1; i < n; i++) {
            double dist = Math.sqrt(Math.pow(stars[0][0] - stars[i][0], 2) + Math.pow(stars[0][1] - stars[i][1], 2));
            pq.add(new Node(i, dist));
        }

        while (pick < n) {
            Node curr = pq.poll();

            if (visit[curr.num]) {
                continue;
            }

            visit[curr.num] = true;
            sum += curr.dist;
            pick++;

            for (int i = 1; i < n; i++) {
                if (visit[i]) {
                    continue;
                }
                double dist = Math.sqrt(Math.pow(stars[curr.num][0] - stars[i][0], 2) + Math.pow(stars[curr.num][1] - stars[i][1], 2));
                pq.add(new Node(i, dist));
            }
        }

        System.out.println(sum);
    }

    static class Node {
        int num;
        double dist;

        public Node(int num, double dist) {
            this.num = num;
            this.dist = dist;
        }
    }
}
