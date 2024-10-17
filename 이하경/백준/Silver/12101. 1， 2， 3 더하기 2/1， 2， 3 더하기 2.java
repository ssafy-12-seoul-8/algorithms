import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[11];
        dpInit(dp, n);

        List<Integer> list = new ArrayList<>();
        find(n, k, dp, list);

        if (list.isEmpty()) {
            System.out.println(-1);
            return;
        }

        sb.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append("+").append(list.get(i));
        }

        System.out.println(sb);
    }

    public static void dpInit(int[] dp, int n) {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
    }

    // n을 만드는 k번째 방법 찾기
    public static void find(int n, int k, int[] dp, List<Integer> list) {
        if (k > dp[n]) {
            return;
        }

        if (k == 1) {
            while (n-- > 0) {
                list.add(1);
            }
            return;
        }

        if (n == 2 & k == 2) {
            list.add(2);
            return;
        }

        int acc = dp[n];
        for (int i = 3; i >= 1; i--) {
            acc -= dp[n - i];
            if (acc < k) {
                list.add(i);
                find(n - i, k - acc, dp, list);
                return;
            }
        }
    }
}
