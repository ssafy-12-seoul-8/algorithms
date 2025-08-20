import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int L = 1;
        int R = k;

        while (L <= R) {
            int mid = (L + R) / 2;
            int cnt = 0;

            for (int i = 1; i <= N; i++) {
                if (i > mid) {
                    break;
                }

                cnt += Math.min(N, mid / i);
            }

            if (cnt >= k) {
                R = mid - 1;
            }

            if (cnt < k) {
                L = mid + 1;
            }
        }

        System.out.println(L);
    }
}