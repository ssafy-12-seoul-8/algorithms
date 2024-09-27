import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        memo = new int[n + 1][k + 1];

        System.out.println(comb(n, k));
    }

    static int comb(int n, int k) {
        if (memo[n][k] != 0) {
            return memo[n][k];
        }
        if (n == k) {
            return memo[n][k] = 1;
        }
        if (k == 0) {
            return memo[n][k] = 1;
        }
        return memo[n][k] = (comb(n - 1, k - 1) + comb(n - 1, k)) % 10007;
    }
}

