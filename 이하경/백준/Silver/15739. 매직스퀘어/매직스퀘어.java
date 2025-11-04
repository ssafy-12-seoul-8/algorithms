import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];
        boolean[] used = new boolean[n * n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (used[matrix[i][j]]) {
                    System.out.println("FALSE");
                    return;
                }
                used[matrix[i][j]] = true;
            }
        }

        int sum = n * (n * n + 1) / 2;

        int digSum1 = 0;
        int digSum2 = 0;
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            if (rowSum != sum || colSum != sum) {
                System.out.println("FALSE");
                return;
            }
            digSum1 += matrix[i][i];
            digSum2 += matrix[i][n - 1 - i];
        }

        if (digSum1 != sum || digSum2 != sum) {
            System.out.println("FALSE");
            return;
        }

        System.out.println("TRUE");
    }
}
