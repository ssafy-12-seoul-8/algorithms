import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] needDay = new int[n];
        int[] income = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            needDay[i] = Integer.parseInt(st.nextToken());
            income[i] = Integer.parseInt(st.nextToken());
        }

        // 모든 상담을 다 한다면 1000*1,500,000 < int
        int[] dp = new int[n + 1]; // i일 이후에 얻을 수 있는 최대수익
        for (int i = n - 1; i >= 0; i--) {
            if (i + needDay[i] > n) {
                dp[i] = dp[i + 1];
                continue;
            }
            dp[i] = Math.max(dp[i + 1], dp[i + needDay[i]] + income[i]);
        }

        System.out.println(dp[0]);
    }
}
