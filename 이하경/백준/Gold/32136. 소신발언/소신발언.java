import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] ice;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        ice = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ice[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch(1, 75_000_000_000L));
    }

    // canHeat한 최소 시간 구하기
    public static long binarySearch(long start, long end) {
        while (start < end) {
            long mid = (start + end) / 2;
            if (canHeat(mid)) { // mid시간에 다 녹일 수 있으면 큰쪽은 볼필요없다
                end = mid;
                continue;
            }
            start = mid + 1;
        }
        return start;
    }

    public static boolean canHeat(long mid) {
        // 시간 내에 녹이려면 범위가 어디여야하는지 저장할건데
        long leftMax = 0;
        long rightMin = n - 1;

        for (int i = 0; i < n; i++) {
            long gap = mid / ice[i];
            leftMax = Math.max(leftMax, i - gap);
            rightMin = Math.min(rightMin, i + gap);
        }
        return leftMax <= rightMin;
    }
}
