import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Main {
    static int[][] mat;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        mat = new int[n][2];
        dp =  new int[n][n]; // i에서 j까지 필요한 곱셈 연산 최솟값

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            mat[i][0] = Integer.parseInt(st.nextToken());
            mat[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getMin(0, n - 1));
    }

    static int getMin(int from, int to) {
        if (from == to) {
            return 0;
        }
        if (from + 1 == to) {
            return mat[from][0] * mat[from][1] * mat[to][1];
        }

        if (dp[from][to] != 0) {
            return dp[from][to];
        }

        int min = Integer.MAX_VALUE;
        for (int i = from; i < to; i++) {
            min = Math.min(min, getMin(from, i) + getMin(i + 1, to) + mat[from][0] * mat[i][1] * mat[to][1]);
        }

        return dp[from][to] = min;
    }
}
