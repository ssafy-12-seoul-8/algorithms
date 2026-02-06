import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] minNum = new int[n];
        int maxIdx = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            int idx = lowerBound(minNum, 0, maxIdx, k);
            if (idx == maxIdx) {
                maxIdx++;
            }
            minNum[idx] = k;
        }

        System.out.println(n - maxIdx);
    }

    // target보다 크거나같은 최소 index 구하기
    public static int lowerBound(int[] arr, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                end = mid;
                continue;
            }
            start = mid + 1;
        }

        return start;
    }
}
