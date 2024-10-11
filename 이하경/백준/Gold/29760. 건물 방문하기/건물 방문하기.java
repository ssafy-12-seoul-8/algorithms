import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        boolean[][] visit = new boolean[h + 1][w + 1];
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            visit[x][y] = true;
        }

        int[][] dp = new int[h + 1][w + 1]; // dp[i][j] => i층을 다 돌고 j번방에서 끝날때 시간

        for (int i = 1; i < w; i++) {
            dp[0][i + 1] = i;
        }

        int maxHeight = 1;
        for (int i = 1; i <= h; i++) { // 한 층에서 움직임

            int left = 0;
            for (int j = 1; j <= w; j++) {
                if (visit[i][j]) {
                    left = j;
                    break;
                }
            }
            if (left == 0) { // 이 층엔 가고싶은 방이 없어
                for (int j = 1; j <= w; j++) {
                    dp[i][j] = dp[i - 1][j];
                }
                continue;
            }
            maxHeight = i;

            int right = 0;
            for (int j = w; j >= 1; j--) {
                if (visit[i][j]) {
                    right = j;
                    break;
                }
            }

            int gap = right - left;
            for (int j = 1; j <= w; j++) { // 호수
                int minTime = Integer.MAX_VALUE;
                for (int k = 1; k <= w; k++) { // 아랫층 호수
                    if (j > k) {
                        int tmp = dp[i - 1][k] + gap + Math.abs(k - left) + Math.abs(j - right);
                        minTime = Math.min(minTime, tmp);
                    } else {
                        int tmp = dp[i - 1][k] + gap + Math.abs(j - left) + Math.abs(k - right);
                        minTime = Math.min(minTime, tmp);
                    }
                }
                dp[i][j] = minTime;
            }
        }

        int minTime = Integer.MAX_VALUE;
        for (int i = 1; i <= w; i++) {
            if (visit[maxHeight][i]) {
                minTime = Math.min(minTime, dp[maxHeight][i]);
            }
        }

        System.out.println(minTime + 100 * (maxHeight - 1));
    }
}
