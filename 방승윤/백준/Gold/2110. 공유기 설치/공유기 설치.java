import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] x = new int[N];

        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(x);

        int l = Integer.MAX_VALUE;
        int r = x[N - 1] - x[0];
        int m = 0;

        for (int i = 1; i < N; i++) {
            l = Math.min(x[i] - x[i - 1], l);
        }

        int ans = 0;

        while (l <= r) {
            m = (l + r) / 2;
            int cnt = 1;
            int s = x[0];

            for (int i = 0; i < N; i++) {
                if (x[i] - s >= m) {
                    cnt++;
                    s = x[i];
                }
            }

            if (cnt >= C) {
                l = m + 1;
                ans = m;
                continue;
            }

            r = m - 1;
        }

        System.out.println(ans);
    }
}