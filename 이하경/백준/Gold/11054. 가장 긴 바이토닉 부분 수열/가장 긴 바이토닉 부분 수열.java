import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        int[] lisLen = new int[n];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int idx = lowerBound(dp, maxLen, a[i]);
            if (idx >= maxLen) {
                maxLen++;
            }
            dp[idx] = a[i];
            lisLen[i] = idx + 1;
        }

        Arrays.fill(dp, 0);
        int max = 1;
        maxLen = 0;
        for (int i = n - 1; i >= 0; i--) {
            int idx = lowerBound(dp, maxLen, a[i]);
            if (idx >= maxLen) {
                maxLen++;
            }
            dp[idx] = a[i];
            max = Math.max(max, idx + lisLen[i]);
        }

        System.out.println(max);
    }

    static int lowerBound(int[] dp, int end, int target) {
        int start = 0;
        while (start < end) {
            int mid = (start + end) / 2;
            if (dp[mid] >= target) {
                end = mid;
                continue;
            }
            start = mid + 1;
        }
        return end;
    }
}
