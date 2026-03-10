import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int count = 0;
    static ArrayList<int[]> virus;
    static int min = Integer.MAX_VALUE;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        virus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    continue;
                }
                count++;
                if (map[i][j] == 2) {
                    virus.add(new int[]{ i, j });
                }
            }
        }

        bt(0, 0, 0);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void bt (int sIdx, int visitBit, int pick) {
        if (pick == m) {
            int cnt = count(visitBit);
            if (cnt >= 0) {
                min = Math.min(min, cnt);
            }
            return;
        }

        if (sIdx >= virus.size()) {
            return;
        }

        for (int i = sIdx; i < virus.size(); i++) {
            bt(i + 1, visitBit | 1 << i, pick + 1);
        }
    }

    public static int count(int visitBit) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];
        for (int i = 0; i < 10; i++) {
            if ((visitBit & (1 << i)) != 0) {
                int[] v = virus.get(i);
                q.add(new int[]{ v[0], v[1], 0 });
                visit[v[0]][v[1]] = true;
            }
        }

        int cnt = 0;
        int max = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (map[curr[0]][curr[1]] != 2) {
                max = Math.max(max, curr[2]);
            }

            for (int d = 0; d < 4; d++) {
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                if (valid(nx, ny, visit)) {
                    if (map[nx][ny] == 1) {
                        continue;
                    }
                    visit[nx][ny] = true;
                    q.add(new int[]{ nx, ny, curr[2] + 1 });
                    if (map[nx][ny] == 0) {
                        cnt++;
                    }
                }
            }
        }

        if (cnt + virus.size() == count) {
            return max;
        }

        return -1;
    }

    public static boolean valid(int x, int y, boolean[][] visit) {
        return x >= 0 && x < n && y >= 0 && y < n && !visit[x][y];
    }
}
