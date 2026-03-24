import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] lines = new int[n][2];
        int[] dp = new int[n];
        Arrays.fill(dp, 500);
        int maxIdx = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lines[i] = new int[]{ a, b };
        }

        Arrays.sort(lines, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            int idx = lowerBound(0, maxIdx, dp, lines[i][1]);
            dp[idx] = lines[i][1];

            if (maxIdx == idx + 1) {
                maxIdx++;
            }
        }

        System.out.println(n - maxIdx + 1);
    }

    static int lowerBound(int start, int end, int[] dp, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (dp[mid] < target) {
                start = mid + 1;
                continue;
            }
            end = mid - 1;
        }

        return start;
    }

}
