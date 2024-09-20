import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 백트래킹으로 미로 다 구하고 거리 구하기
// 바닥도 돌리면 항상 입구는 (0,0,0) 출구는 (4,4,4)

public class Main {
    static int[][][][] maze;
    static int[][] pick;
    static int min;
    static int[][][] visit;
    static int[] dx = { 0, 0, 0, 0, 1, -1 };
    static int[] dy = { 0, 0, 1, -1, 0, 0 };
    static int[] dz = { 1, -1, 0, 0, 0, 0 };

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        maze = new int[4][5][5][5]; // (회전, 높이, 세로, 가로)

        for (int i = 0; i < 5; i++) { // 높이
            for (int j = 0; j < 5; j++) { // 세로
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) { // 가로
                    maze[0][i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    static void solve() {
        memoRotate();

        pick = new int[5][2];
        min = Integer.MAX_VALUE;

        bt(0, 0);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    static void memoRotate() {
        for (int i = 0; i < 5; i++) { // 높이
            for (int j = 0; j < 5; j++) { // 세로
                for (int k = 0; k < 5; k++) { // 가로
                    maze[1][i][k][4 - j] = maze[0][i][j][k];
                    maze[2][i][4 - j][4 - k] = maze[0][i][j][k];
                    maze[3][i][4 - k][j] = maze[0][i][j][k];
                }
            }
        }
    }

    static void bt(int depth, int visitBit) {
        if (depth == 5) {
            if (maze[pick[4][1]][pick[4][0]][4][4] == 0) {
                return;
            }
            min = Math.min(min, findMinMove());
            return;
        }

        for (int i = 0; i < 5; i++) { // 판 고르기
            if ((visitBit & (1 << i)) == 0) {
                pick[depth][0] = i;
                for (int j = 0; j < 4; j++) { // 방향 고르기
                    pick[depth][1] = j;
                    if (depth == 0 && maze[pick[0][1]][pick[0][0]][0][0] == 0) {
                        continue;
                    }
                    bt(depth + 1, visitBit | 1 << i);
                }
            }
        }
    }

    // 탈출이 불가능하다면 매우 큰 값 반환
    static int findMinMove() {
        Queue<int[]> q = new LinkedList<>();
        visit = new int[5][5][5];
        q.add(new int[]{ 0, 0, 0 });
        visit[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                int nz = curr[2] + dz[i];

                if (nx == 4 && ny == 4 && nz == 4) {
                    return visit[curr[0]][curr[1]][curr[2]];
                }

                if (isValid(nx, ny, nz)) {
                    visit[nx][ny][nz] = visit[curr[0]][curr[1]][curr[2]] + 1;
                    q.add(new int[]{ nx, ny, nz });
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    static boolean isValid(int x, int y, int z) {
        return x >= 0 && x < 5 && y >= 0 && y < 5 && z >= 0 && z < 5
                && visit[x][y][z] == 0 && maze[pick[x][1]][pick[x][0]][y][z] == 1;
    }
}
