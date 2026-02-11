import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int[] depth;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        depth = new int[n + 1];
        ArrayList<Node>[] nodes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            nodes[from].add(new Node(to, dist));
            nodes[to].add(new Node(from, dist));
        }

        Queue<Node> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        q.add(new Node(1, 0));
        visit[1] = true;
        int maxNum = 1;
        int maxDist = 0;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.dist > maxDist) {
                maxDist = curr.dist;
                maxNum = curr.num;
            }

            for (Node nd : nodes[curr.num]) {
                if (!visit[nd.num]) {
                    visit[nd.num] = true;
                    q.add(new Node(nd.num, curr.dist + nd.dist));
                }
            }
        }

        Arrays.fill(visit, false);
        visit[maxNum] = true;
        q.add(new Node(maxNum, 0));
        int maxNum2 = 1;
        maxDist = 0;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.dist > maxDist) {
                maxNum2 = curr.num;
                maxDist = curr.dist;
            }

            for (Node nd : nodes[curr.num]) {
                if (!visit[nd.num]) {
                    visit[nd.num] = true;
                    q.add(new Node(nd.num, curr.dist + nd.dist));
                }
            }
        }

        Arrays.fill(visit, false);
        visit[maxNum] = true;
        visit[maxNum2] = true;
        q.add(new Node(maxNum, 0));
        maxDist = 0;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.dist > maxDist) {
                maxDist = curr.dist;
            }

            for (Node nd : nodes[curr.num]) {
                if (!visit[nd.num]) {
                    visit[nd.num] = true;
                    q.add(new Node(nd.num, curr.dist + nd.dist));
                }
            }
        }

        Arrays.fill(visit, false);
        visit[maxNum] = true;
        visit[maxNum2] = true;
        q.add(new Node(maxNum2, 0));

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.dist > maxDist) {
                maxDist = curr.dist;
            }

            for (Node nd : nodes[curr.num]) {
                if (!visit[nd.num]) {
                    visit[nd.num] = true;
                    q.add(new Node(nd.num, curr.dist + nd.dist));
                }
            }
        }

        System.out.println(maxDist);
    }

    private static class Node {
        int num;
        int dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }
}
