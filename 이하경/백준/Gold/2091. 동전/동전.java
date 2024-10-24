import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int[] values = { 1, 5, 10, 25 };
        int[] number = new int[4];
        number[0] = Integer.parseInt(st.nextToken());
        number[1] = Integer.parseInt(st.nextToken());
        number[2] = Integer.parseInt(st.nextToken());
        number[3] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[5][x + 1];

        for (int coinIdx = 0; coinIdx < 4; coinIdx++) {
            if (number[coinIdx] > 0 && values[coinIdx] <= x) {
                dp[coinIdx][values[coinIdx]] = 1; // 0개 필요와 만들 수 없음 구분하기 위해 미리 넣어줌
                dp[4][values[coinIdx]] = 1;
            }
        }

        for (int val = 2; val <= x; val++) { // val원을 만들건데
            for (int coinIdx = 0; coinIdx < 4; coinIdx++) { // val원보다 values[coinIdx] 전을 보겠다
                // values만큼 전이 있고, 그 숫자를 만들 수 있으며, 현재 coin을 사용할 수 있으면서 개수가 커지면
                if (val > values[coinIdx] && dp[4][val - values[coinIdx]] != 0 && number[coinIdx] > dp[coinIdx][val - values[coinIdx]] && dp[4][val] <= dp[4][val-values[coinIdx]]) {
                    for (int idx = 0; idx < 5; idx++) {
                        dp[idx][val] = dp[idx][val - values[coinIdx]];
                    }
                    dp[coinIdx][val]++;
                    dp[4][val]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[0][x]).append(" ").append(dp[1][x]).append(" ").append(dp[2][x]).append(" ").append(dp[3][x]);

        System.out.println(sb);
    }
}
