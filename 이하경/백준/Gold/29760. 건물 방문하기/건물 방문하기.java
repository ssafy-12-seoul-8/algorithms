import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] room = new int[h + 1][2]; // 맨 왼쪽과 오른쪽 방만 저장
        for (int i = 1; i <= h; i++) {
            room[i][0] = 101;
            room[i][1] = 0;
        }

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            room[x][0] = Math.min(room[x][0], y);
            room[x][1] = Math.max(room[x][1], y);
        }
        room[1][0] = 1;

        int[] dp = new int[2]; // 한 층을 다 돌고 왼쪽/오른쪽에서 끝날때 시간
        int[] nextDp = new int[2];
        int left = 1;
        int right = 1; // 0층 1호에서 시작한다고 가정, 시간은 0

        int maxHeight = 1;
        for (int i = 1; i <= h; i++) { // 한 층에서 움직임
            if (room[i][0] == 101) { // 이 층엔 가고싶은 방이 없어
                continue;
            }

            maxHeight = i;

            int gap = room[i][1] - room[i][0];
            // 왼쪽방은 왼->오->왼 또는 오->오->왼
            nextDp[0] = Math.min(dp[0] + Math.abs(left - room[i][1]), dp[1] + Math.abs(right - room[i][1])) + gap;
            nextDp[1] = Math.min(dp[0] + Math.abs(left - room[i][0]), dp[1] + Math.abs(right - room[i][0])) + gap;
            left = room[i][0];
            right = room[i][1];
            dp[0] = nextDp[0];
            dp[1] = nextDp[1];
        }

        System.out.println(Math.min(dp[0], dp[1]) + 100 * (maxHeight - 1));
    }
}
