import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());

        int[][] pos = new int[w][2];
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken()) - 1;
            pos[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        int[][] dp = new int[w + 1][w + 1];
        int[][] prev = new int[w + 1][w + 1];
        dp[1][0] = pos[0][0] + pos[0][1];
        dp[0][1] = (n - 1 - pos[0][0]) + (n - 1 - pos[0][1]);

        for (int i = 2; i <= w; i++) {
            for (int j = 0; j < i - 1; j++) {
                dp[j][i] = dp[j][i - 1] + dist(i - 2, i - 1, pos);
                dp[i][j] = dp[i - 1][j] + dist(i - 2, i - 1, pos);

                if (j == 0) {
                    dp[i - 1][i] = dp[i - 1][0] + (n - 1 - pos[i - 1][0]) + (n - 1 - pos[i - 1][1]);
                    dp[i][i - 1] = dp[0][i - 1] + pos[i - 1][0] + pos[i - 1][1];
                    continue;
                }

                int mx = dp[i - 1][j] + dist(j - 1, i - 1, pos);
                int my = dp[j][i - 1] + dist(j - 1, i - 1, pos);

                if (mx < dp[i - 1][i]) {
                    dp[i - 1][i] = mx;
                    prev[i - 1][i] = j;
                }

                if (my < dp[i][i - 1]) {
                    dp[i][i - 1] = my;
                    prev[i][i - 1] = j;
                }
            }
        }

        int min = 2_000_000;
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < w; i++) {
            if (dp[i][w] < min) {
                min = dp[i][w];
                c1 = i; c2 = w;
            }
            if (dp[w][i] < min) {
                min = dp[w][i];
                c1 = w; c2 = i;
            }
        }

        int[] list = new int[w];
        int idx = w - 1;
        while (idx >= 0) {
            if (c1 > c2) {
                list[idx--] = 1;
                if (c1 > c2 + 1) {
                    c1--;
                } else {
                    c1 = prev[c1][c2];
                }
            } else {
                list[idx--] = 2;
                if (c2 > c1 + 1) {
                    c2--;
                } else {
                    c2 = prev[c1][c2];
                }
            }
        }

        sb.append(min).append("\n");
        for (int i = 0; i < w; i++) {
            sb.append(list[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static int dist(int idx1, int idx2, int[][] pos) {
        return Math.abs(pos[idx1][0] - pos[idx2][0]) + Math.abs(pos[idx1][1] - pos[idx2][1]);
    }
}
