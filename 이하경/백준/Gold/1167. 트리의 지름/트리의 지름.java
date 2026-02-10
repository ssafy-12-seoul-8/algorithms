import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Node>[] nodes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            while (next != -1) {
                int num = next;
                int dist = Integer.parseInt(st.nextToken());
                next = Integer.parseInt(st.nextToken());
                nodes[node].add(new Node(num, dist));
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        boolean[] visit = new boolean[n + 1];
        visit[1] = true;
        int maxDist = 0;
        int maxNode = 1;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.dist > maxDist) {
                maxNode = curr.num;
                maxDist = curr.dist;
            }

            for (Node nd : nodes[curr.num]) {
                if (!visit[nd.num]) {
                    visit[curr.num] = true;
                    q.add(new Node(nd.num, curr.dist + nd.dist));
                }
            }
        }

        q.add(new Node(maxNode, 0));
        Arrays.fill(visit, false);
        visit[maxNode] = true;
        maxDist = 0;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.dist > maxDist) {
                maxDist = curr.dist;
            }

            for (Node nd : nodes[curr.num]) {
                if (!visit[nd.num]) {
                    visit[curr.num] = true;
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
