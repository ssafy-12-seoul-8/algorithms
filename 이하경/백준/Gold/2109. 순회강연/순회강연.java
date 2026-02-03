import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.add(new int[]{ p, d });
        }

        int[] next = new int[10_001];

        for (int i = 0; i < 10_001; i++) {
            next[i] = i;
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int day = findNext(next, curr[1]);

            if (day > 0) {
                sum += curr[0];
                next[day] -= 1;
            }
        }

        System.out.println(sum);
    }

    public static int findNext(int[] arr, int x) {
        if (arr[x] != x) {
            arr[x] = findNext(arr, arr[x]);
        }
        return arr[x];
    }
}
