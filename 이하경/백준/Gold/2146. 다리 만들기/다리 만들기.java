import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 섬을 숫자로 구분하고
// 가장자리 부분을 어디에 저장한다
// 가장자리에서 bfs로 다리 길이 찾는다
public class Main {
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int n;
    static int[][] map;
    static Queue<int[]> sides = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int isLand = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = isLand++;
                    fillBfs(i, j);
                }
            }
        }

        int minLen = 200;
        while (!sides.isEmpty()) {
            int[] poll = sides.poll();
            minLen = findBfs(poll[0], poll[1], minLen);
        }

        System.out.println(minLen);
    }

    // 같은 섬을 표시
    static void fillBfs (int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{ x, y });
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            boolean side = false;
            for (int d = 0; d < 4; d++) {
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] == 1) {
                        map[nx][ny] = map[x][y];
                        q.add(new int[]{ nx, ny });
                    } else {
                        side = true;
                    }
                }
            }

            if (side) {
                sides.add(curr);
            }
        }
    }

    // 다른 섬 찾기
    static int findBfs(int x, int y, int max) {
        boolean[][] visit = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ x, y, 0 });
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[2] >= max) {
                return max;
            }

            for (int d = 0; d < 4; d++) {
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visit[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        visit[nx][ny] = true;
                        q.add(new int[]{ nx, ny, curr[2] + 1 });
                        continue;
                    }

                    if (map[nx][ny] == map[x][y]) {
                        visit[nx][ny] = true;
                        continue;
                    }

                    return curr[2];
                }
            }
        }
        return max;
    }
}
