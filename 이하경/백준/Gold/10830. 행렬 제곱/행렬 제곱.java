import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] a = new int[n][n];
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ans[i][i] = 1;
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (b > 0) {
            if ((b & 1) == 1) {
                ans = matMul(n, ans, a);
            }
            b >>= 1;
            a = matMul(n, a, a);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int[][] matMul(int n, int[][] mat1, int[][] mat2) {
        int[][] ret = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) { // (i, j) 위치의 값
                for (int k = 0; k < n; k++) {
                    ret[i][j] += mat1[i][k] * mat2[k][j];
                }
                ret[i][j] %= 1000;
            }
        }
        return ret;
    }
}
