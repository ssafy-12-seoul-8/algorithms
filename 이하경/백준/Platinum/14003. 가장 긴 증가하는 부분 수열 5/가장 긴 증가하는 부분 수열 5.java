import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[n];
        int[] originalIdx = new int[n]; // lis 배열의 요소의 원래 인덱스
        int[] prevIdx = new int[n]; // 현재
        int nextIdx = 0;

        for (int i = 0; i < n; i++) {
            int idx = lowerBound(lis, 0, nextIdx, arr[i]);
            if (idx == nextIdx) {
                nextIdx++;
            }

            lis[idx] = arr[i];
            originalIdx[idx] = i;
            prevIdx[i] = idx == 0 ? -1 : originalIdx[idx - 1];
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int idx = originalIdx[nextIdx - 1];

        while (idx >= 0) {
            ans.add(arr[idx]);
            idx = prevIdx[idx];
        }

        sb.append(nextIdx).append("\n");
        for (int i = ans.size() - 1; i >= 0; i--) {
            sb.append(ans.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    // target 이상이 처음 나오는 위치
    static int lowerBound(int[] arr, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                end = mid;
                continue;
            }
            start = mid + 1;
        }
        return end;
    }
}
