import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] mat = new int[n][2];
        int[][] dp =  new int[n][n]; // i에서 j까지 필요한 곱셈 연산 최솟값

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            mat[i][0] = Integer.parseInt(st.nextToken());
            mat[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int seq = 1; seq < n; seq++) { // seq개 차이나는 애를 구하기
            for (int i = 0; i < n - seq; i++) {
                int j = i + seq;
                int min = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k + 1][j] + mat[i][0] * mat[k][1] * mat[j][1]);
                }

                dp[i][j] = min;
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}
