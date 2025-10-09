import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("Case #").append(t).append(": ");

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] prices = new int[n * 2];
            boolean[] used = new boolean[n * 2];

            for (int i = 0; i < n * 2; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n * 2; i++) {
                if (used[i]) {
                    continue;
                }

                sb.append(prices[i]).append(" ");
                int idx = lowerBound(prices, prices[i] / 3 * 4, i + 1, n * 2);

                while (used[idx]) {
                    idx++;
                }
                used[idx] = true;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int lowerBound(int[] p, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (p[mid] < target) {
                start = mid + 1; // mid는 구간에 포함 안되므로
                continue;
            }
            end = mid;
        }
        return start;
    }
}
