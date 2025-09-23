import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static class Node implements Comparable<Node> {
        int x;
        int y;
        int d;

        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Node node) {
            return this.d - node.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[][] dist = new int[N][M];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            Arrays.fill(dist[i], Integer.MAX_VALUE / 10);

            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            Node curr = deque.pollFirst();
            int x = curr.x;
            int y = curr.y;
            int d = curr.d;

            if (d > dist[x][y]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny <0 || ny >= M) {
                    continue;
                }

                int nd = d + arr[nx][ny];

                if (nx == N - 1 && ny == M - 1) {
                    System.out.println(nd);
                    return;
                }

                if (nd < dist[nx][ny]) {
                    dist[nx][ny] = nd;

                    if (nd == d) {
                        deque.addFirst(new Node(nx, ny, nd));
                        continue;
                    }

                    deque.addLast(new Node(nx, ny, nd));
                }
            }
        }

        System.out.println(dist[N - 1][M - 1]);
    }
}