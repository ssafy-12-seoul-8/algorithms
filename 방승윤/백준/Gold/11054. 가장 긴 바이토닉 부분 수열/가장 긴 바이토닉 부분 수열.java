import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] forwardCnt = new int[N];
        int[] reverseCnt = new int[N];
        Arrays.fill(forwardCnt, 1);
        Arrays.fill(reverseCnt, 1);

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    forwardCnt[i] = Math.max(forwardCnt[i], forwardCnt[j] + 1);
                }
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (A[j] < A[i]) {
                    reverseCnt[i] = Math.max(reverseCnt[i], reverseCnt[j] + 1);
                }
            }
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, forwardCnt[i] + reverseCnt[i] - 1);
        }

        System.out.println(max);
    }
}