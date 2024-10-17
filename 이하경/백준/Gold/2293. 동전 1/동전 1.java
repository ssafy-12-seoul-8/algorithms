import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];
        dp[0] = 1; // 0 을 만드는법은 안쓰기 하나

        while (n-- > 0) { // 이번에 받은 동전을 사용할거야
            int val = Integer.parseInt(br.readLine());

            for (int i = 1; i <= k; i++) { // 여태 받은 동전으로 k원 만드는 경우의 수 저장
                if (i >= val) {
                    dp[i] += dp[i - val];
                }
            }
        }

        System.out.println(dp[k]);

    }
}
