import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int cw = 0;
        int ch = 0;
        char[][] map = new char[h][w];
        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'C') {
                    ch = i;
                    cw = j;
                }
            }
        }

        int[] dh = {1, 0, -1, 0};
        int[] dw = {0, 1, 0, -1};

        int[][][] visit = new int[h][w][4];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Arrays.fill(visit[i][j], w * h);
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[3]));
        for (int i = 0; i < 4; i++) {
            q.add(new int[]{ch, cw, i, 0});
            visit[ch][cw][i] = 0;
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (visit[curr[0]][curr[1]][curr[2]] < curr[3]) {
                continue;
            }

            if (map[curr[0]][curr[1]] == 'C' && (curr[0] != ch || curr[1] != cw)) {
                System.out.println(curr[3]);
                return;
            }

            for (int i = 3; i <= 5; i++) {
                int d = (curr[2] + i) % 4;
                int nh = curr[0] + dh[d];
                int nw = curr[1] + dw[d];

                int cnt = curr[3] + (i % 2);
                if (nh >= 0 && nh < h && nw >= 0 && nw < w && map[nh][nw] != '*' && visit[nh][nw][d] > cnt) {
                    q.add(new int[]{nh, nw, d, cnt});
                    visit[nh][nw][d] = cnt;
                }
            }
        }
    }
}
