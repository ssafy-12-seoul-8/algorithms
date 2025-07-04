import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int num;
        String com;

        public Node(int num, String com) {
            this.num = num;
            this.com = com;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[10000];

            Queue<Node> q = new LinkedList<>();

            q.add(new Node(A, ""));
            visited[A] = true;

            while (!q.isEmpty()) {
                Node n = q.poll();

                if (n.num == B) {
                    sb.append(n.com).append("\n");
                    break;
                }

                int d1 = n.num / 1000;
                int d2 = n.num / 100 % 10;
                int d3 = n.num / 10 % 10;
                int d4 = n.num % 10;

                int D = n.num * 2 % 10000;
                int S = n.num != 0 ? n.num - 1 : 9999;
                int L = d2 * 1000 + d3 * 100 + d4 * 10 + d1;
                int R = d4 * 1000 + d1 * 100 + d2 * 10 + d3;

                if (!visited[D]) {
                    q.add(new Node(D, n.com + "D"));
                    visited[D] = true;
                }

                if (!visited[S]) {
                    q.add(new Node(S, n.com + "S"));
                    visited[S] = true;
                }

                if (!visited[L]) {
                    q.add(new Node(L, n.com + "L"));
                    visited[L] = true;
                }

                if (!visited[R]) {
                    q.add(new Node(R, n.com + "R"));
                    visited[R] = true;
                }
            }
        }

        System.out.println(sb);
    }
}