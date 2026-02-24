import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int m;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        int c = 1;
        while (c == 1) {
            year++;
            melt();
            c = count();
        }

        System.out.println(c == 0 ? 0 : year);
    }

    static void melt() {
        int[][] amount = new int[n][m];

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (map[nx][ny] == 0) {
                        amount[i][j]++;
                    }
                }
            }
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (map[i][j] > amount[i][j]) {
                    map[i][j] -= amount[i][j];
                    continue;
                }
                map[i][j] = 0;
            }
        }
    }

    static int count() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    if (map[i][j] > 0) {
                        count++;
                        q.add(new int[]{i, j});
                        while (!q.isEmpty()) {
                            int[] curr = q.poll();

                            for (int d = 0; d < 4; d++) {
                                int nx = curr[0] + dx[d];
                                int ny = curr[1] + dy[d];

                                if (visit[nx][ny]) {
                                    continue;
                                }

                                visit[nx][ny] = true;
                                if (map[nx][ny] > 0) {
                                    q.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }

                }
            }
        }

        return count;
    }
}
