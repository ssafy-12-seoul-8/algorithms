import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] field = new int[N][N];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int sum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean[][] visited = new boolean[N][N];
            boolean[][] selected = new boolean[N][N];
            int max = 0;
            int maxRainbow = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] || field[i][j] <= 0) {
                        continue;
                    }

                    boolean[][] last = new boolean[N][N];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                    last[i][j] = true;
                    int cnt = 1;
                    int rainbow = 0;

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = curr[0] + dx[d];
                            int ny = curr[1] + dy[d];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N || field[nx][ny] < 0 || visited[nx][ny]
                            || last[nx][ny]) {
                                continue;
                            }

                            if (field[nx][ny] != field[i][j] && field[nx][ny] != 0) {
                                continue;
                            }

                            if (field[nx][ny] != 0) {
                                visited[nx][ny] = true;
                            }

                            if (field[nx][ny] == 0) {
                                rainbow++;
                            }

                            queue.add(new int[] {nx, ny});

                            last[nx][ny] = true;
                            cnt++;
                        }
                    }

                    if (cnt < max || cnt < 2) {
                        continue;
                    }

                    if (cnt == max && rainbow < maxRainbow) {
                        continue;
                    }

                    maxRainbow = rainbow;
                    max = cnt;

                    for (int k = 0; k < N; k++) {
                        selected[k] = last[k].clone();
                    }
                }
            }

            if (max == 0) {
                break;
            }

            sum += max * max;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (selected[i][j]) {
                        field[i][j] = -2;
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                for (int i = N - 2; i >= 0; i--) {
                    if (field[i][j]  < 0) {
                        continue;
                    }

                    int k = i + 1;

                    while (k < N && field[k][j] == -2) {
                        k++;
                    }

                    if (i != k - 1) {
                        field[k - 1][j] = field[i][j];
                        field[i][j] = -2;
                    }
                }
            }

            int[][] og = new int[N][N];

            for (int i = 0; i < N; i++) {
                og[i] = field[i].clone();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    field[i][j] = og[j][N - 1 - i];
                }
            }

            for (int j = 0; j < N; j++) {
                for (int i = N - 2; i >= 0; i--) {
                    if (field[i][j]  < 0) {
                        continue;
                    }

                    int k = i + 1;

                    while (k < N && field[k][j] == -2) {
                        k++;
                    }

                    if (i != k - 1) {
                        field[k - 1][j] = field[i][j];
                        field[i][j] = -2;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}