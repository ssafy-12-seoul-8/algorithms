import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static int N;
    public static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        A = recur(B);

        for (int[] line : A) {
            for (int num : line) {
                sb.append(num).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int[][] recur(long B) {
        if (B == 1) {
            return A;
        }

        int[][] half = recur(B / 2);
        int[][] matrix = multiply(half, half);

        if (B % 2 == 1) {
            matrix = multiply(matrix, A);
        }

        return matrix;
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[i][j] += A[i][k] * B[k][j];
                }

                matrix[i][j] %= 1000;
            }
        }

        return matrix;
    }
}