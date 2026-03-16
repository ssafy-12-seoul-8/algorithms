import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        PriorityQueue<Point> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    q.add(new Point(i, j, map[i][j]));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int time = 0;
        while (time < s) {
            time++;
            PriorityQueue<Point> nq = new PriorityQueue<>();
            while (!q.isEmpty()) {
                Point curr = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = curr.x + dx[d];
                    int ny = curr.y + dy[d];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0) {
                        map[nx][ny] = curr.virus;
                        nq.add(new Point(nx, ny, curr.virus));
                    }
                }
            }
            q = nq;
        }

        System.out.println(map[x - 1][y - 1]);
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int virus;

        public Point(int x, int y, int virus) {
            this.x = x;
            this.y = y;
            this.virus = virus;
        }

        @Override
        public int compareTo(Point o) {
            return this.virus - o.virus;
        }
    }
}
