import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] paint = new int[N][N];
        int[][] paintRG = new int[N][N];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int cnt = 0;
        int cntRG = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                if (line.charAt(j) == 'R') {
                    paint[i][j] = 1;
                    paintRG[i][j] = 1;
                    continue;
                }

                if (line.charAt(j) == 'G') {
                    paint[i][j] = 2;
                    paintRG[i][j] = 1;
                    continue;
                }

                paint[i][j] = 3;
                paintRG[i][j] = 3;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> qRG = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (paint[i][j] == 0) {
                    continue;
                }

                q.add(new int[]{i, j});
                cnt++;

                while (!q.isEmpty()) {
                    int[] color = q.poll();

                    if (paint[color[0]][color[1]] != 0) {
                        for (int d = 0; d < 4; d++) {
                            int nr = color[0] + dr[d];
                            int nc = color[1] + dc[d];

                            if (nr >= 0 && nr < N && nc >= 0 && nc < N && paint[nr][nc] == paint[color[0]][color[1]]) {
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }

                    paint[color[0]][color[1]] = 0;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (paintRG[i][j] == 0) {
                    continue;
                }

                qRG.add(new int[]{i, j});
                cntRG++;

                while (!qRG.isEmpty()) {
                    int[] color = qRG.poll();

                    if (paintRG[color[0]][color[1]] != 0) {
                        for (int d = 0; d < 4; d++) {
                            int nr = color[0] + dr[d];
                            int nc = color[1] + dc[d];

                            if (nr >= 0 && nr < N && nc >= 0 && nc < N && paintRG[nr][nc] == paintRG[color[0]][color[1]]) {
                                qRG.add(new int[]{nr, nc});
                            }
                        }
                    }

                    paintRG[color[0]][color[1]] = 0;
                }
            }
        }

        sb.append(cnt).append(" ").append(cntRG);

        System.out.println(sb);
    }
}