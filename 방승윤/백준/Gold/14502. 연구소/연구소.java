import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static int N;
    public static int M;
    public static int[][] lab;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int max;
    public static int zeroCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];
        zeroCnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());

                if (lab[i][j] == 0) {
                    zeroCnt++;
                }
            }
        }

        wall(0, -1);
        System.out.println(max);
    }

    public static void wall(int level, int prev) {
        if (level == 3) {
            virus();
            return;
        }

        for (int i = prev + 1; i < N * M; i++) {
            int x = i / M;
            int y = i % M;

            if (lab[x][y] == 0) {
                lab[x][y] = 1;
                wall(level + 1, i);
                lab[x][y] = 0;
            }
        }
    }

    public static void virus() {
        int[][] labClone = new int[N][];

        for (int i = 0; i < N; i++) {
            labClone[i] = lab[i].clone();
        }

        int safe = zeroCnt - 3;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 2) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int x = curr[0];
                        int y = curr[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < M && labClone[nx][ny] == 0) {
                                queue.add(new int[]{nx, ny});
                                labClone[nx][ny] = 2;
                                safe--;
                            }
                        }
                    }
                }
            }
        }

        max = Math.max(max, safe);
    }
}