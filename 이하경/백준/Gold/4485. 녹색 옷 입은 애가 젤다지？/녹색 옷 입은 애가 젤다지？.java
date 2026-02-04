import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 최댓값ㅇㄴ 125 * 125 * 9
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        int n = Integer.parseInt(br.readLine());
        int tc = 1;

        while (n != 0) {
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            Queue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0, 0, map[0][0]));

            while (!pq.isEmpty() && dist[n - 1][n - 1] == Integer.MAX_VALUE) {
                Node curr = pq.poll();
                if (curr.w == Integer.MAX_VALUE) {
                    continue;
                }

                dist[curr.x][curr.y] = curr.w;

                for (int d = 0; d < 4; d++) {
                    int nx = curr.x + dx[d];
                    int ny = curr.y + dy[d];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && dist[nx][ny] == Integer.MAX_VALUE) {
                        pq.add(new Node(nx, ny, curr.w + map[nx][ny]));
                    }
                }
            }

            sb.append("Problem").append(" ").append(tc).append(": ").append(dist[n - 1][n - 1]).append("\n");

            n = Integer.parseInt(br.readLine());
            tc++;
        }

        System.out.println(sb);
    }

    private static class Node implements Comparable<Node> {
        int x;
        int y;
        int w;

        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
