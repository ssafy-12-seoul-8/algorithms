import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int MOD = 1_000_000_000;

        long[][] dp = new long[k + 1][n + 1]; // i개를 사용해서 j를 만드는 경우의 수
        Arrays.fill(dp[1], 1); // 1개를 써서 i원을 만드는 법은 1가지

        for (int i = 2; i <= k; i++) { // i개를 사용한 경우 만들거야
            dp[i][0] = 1; // 0을 만드는 방법은 한가지뿐
            for (int j = 1; j <= n; j++) { // j를 만들거야
                // j를 만드는 방법은 k-1개를 사용해서 0~j를 만드는 방법에 숫자 하나 더하기
                dp[i][j] = (dp[i][j - 1] + dp[i -1][j]) % MOD;
            }
        }

        System.out.println(dp[k][n]);
    }
}
