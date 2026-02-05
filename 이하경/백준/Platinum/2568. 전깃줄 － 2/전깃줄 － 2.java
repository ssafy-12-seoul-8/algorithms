import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] line = new int[n][];
        int[] conn = new int[100_001]; // conn[i] 이하는 i개 연결
        int[] connIdx = new int[100_001];
        int[] prevIdx = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            line[i] = new int[]{ a, b };
        }

        Arrays.sort(line, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            int idx = binarySearch(conn, 0, max + 1, line[i][1]);
            if (idx > max) {
                max++;
            }
            conn[idx] = line[i][1];
            connIdx[idx] = i;
            prevIdx[i] = connIdx[idx - 1];
        }

        sb.append(n - max).append("\n");

        int tmp = connIdx[max];
        for (int i = 0; i < max; i++) {
            line[tmp][0] = -1;
            tmp = prevIdx[tmp];
        }

        for (int i = 0; i < n; i++) {
            if (line[i][0] > 0) {
                sb.append(line[i][0]).append("\n");
            }
        }

        System.out.println(sb);
    }

    // target보다 큰 값이 처음 나오는 위치
    public static int binarySearch(int[] arr, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
                continue;
            }
            end = mid;
        }
        return start;
    }
}
