import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] dw = new int[]{0, 0, 1, -1};
        int[] dh = new int[]{1, -1, 0, 0};

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] map = new char[h][w];
                        Queue<int[]> hq = new LinkedList<>();
            Queue<int[]> fq = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '*') {
                        fq.add(new int[]{i, j});
                        continue;
                    }
                    if (map[i][j] == '@') {
                        hq.add(new int[]{i, j, 0});
                    }
                }
            }

            int ans = 0;
            loop:
            while (!hq.isEmpty()) { // 사람 갈데가 없으면 못감
                int fsize = fq.size();
                for (int i = 0; i < fsize; i++) {
                    int[] curr = fq.poll();

                    for (int d = 0; d < 4; d++) {
                        int nh = curr[0] + dh[d];
                        int nw = curr[1] + dw[d];

                        if (nh >= 0 && nh < h && nw >= 0 && nw < w && map[nh][nw] == '.') {
                            map[nh][nw] = '*';
                            fq.add(new int[]{nh, nw});
                        }
                    }
                }

                int hsize = hq.size();
                for (int i = 0; i < hsize; i++) {
                    int[] curr = hq.poll();

                    for (int d = 0; d < 4; d++) {
                        int nh = curr[0] + dh[d];
                        int nw = curr[1] + dw[d];

                        if (nh >= 0 && nh < h && nw >= 0 && nw < w) {
                            if (map[nh][nw] == '.') {
                                map[nh][nw] = '@';
                                hq.add(new int[]{nh, nw, curr[2] + 1});
                            }
                            continue;
                        }
                        ans = curr[2] + 1;
                        break loop;
                    }
                }
            }
            sb.append(ans == 0 ? "IMPOSSIBLE" : ans).append("\n");
        }
        System.out.println(sb);
    }
}
