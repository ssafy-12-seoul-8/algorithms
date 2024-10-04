import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        Queue<Point> q = new LinkedList<>();
        boolean[][][] visit = new boolean[n][m][k + 1]; // 벽을 k개 부쉈을때 방문여부
        q.add(new Point(0, 0, 1, 0));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (nx == n - 1 && ny == m - 1) {
                        System.out.println(curr.dist + 1);
                        return;
                    }

                    if (map[nx][ny] == 0) { // 현재 부순개수에서 간적 없는곳
                        if (!visit[nx][ny][curr.destroy]) {
                            visit[nx][ny][curr.destroy] = true;
                            q.add(new Point(nx, ny, curr.dist + 1, curr.destroy));
                        }
                    }
                    else if(curr.destroy>=k)continue;
                    else if (!visit[nx][ny][curr.destroy+1]) {
                        visit[nx][ny][curr.destroy + 1] = true;
                        q.add(new Point(nx, ny, curr.dist + 1, curr.destroy + 1));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static class Point {
        int x, y, dist, destroy;

        public Point(int x, int y, int dist, int destroy) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.destroy = destroy;
        }
    }
}
