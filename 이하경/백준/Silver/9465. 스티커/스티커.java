import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 모든 경우는 위, 아래, 안고름 중 한가지
// 점수 : 100,000*100 = 10,000,000 < int
// 시간 : 3n = 300,000
// 메모리 : 3*100,000*4 = 1,200,000 = 1.2MB

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[n][2];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    sticker[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] score = new int[n][3];
            score[0][0] = sticker[0][0];
            score[0][1] = sticker[0][1];

            for (int i = 1; i < n; i++) {
                score[i][0] = Math.max(score[i - 1][1], score[i - 1][2]) + sticker[i][0];
                score[i][1] = Math.max(score[i - 1][0], score[i - 1][2]) + sticker[i][1];
                score[i][2] = Math.max(score[i - 1][0], score[i - 1][1]);
            }

            sb.append(Math.max(score[n - 1][0], score[n - 1][1])).append("\n"); // 마지막을 안고른건 무조건 둘보다 작음
        }

        System.out.println(sb);
    }
}
