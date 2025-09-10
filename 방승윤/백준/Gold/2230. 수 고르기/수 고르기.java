import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        int L = 0;
        int R = 0;

        while (L != N - 1) {
            if (A[R] - A[L] >= M) {
                min = Math.min(min, A[R] - A[L]);

                if (min == M) {
                    break;
                }

                L++;
                continue;
            }

            if (R < N - 1) {
                R++;
                continue;
            }

            break;
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}