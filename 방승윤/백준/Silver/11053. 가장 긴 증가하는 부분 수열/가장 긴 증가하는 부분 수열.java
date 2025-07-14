import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        int[] len = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        len[0] = 1;

        for (int i = 1; i < N; i++) {
            int max = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (A[i] > A[j]) {
                    max = Math.max(max, len[j] + 1);
                }
            }

            len[i] = max;
        }

        int max = 0;

        for (int i : len) {
            max = Math.max(max, i);
        }

        System.out.println(max);
    }
}