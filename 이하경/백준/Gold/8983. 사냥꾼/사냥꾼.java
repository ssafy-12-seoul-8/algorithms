import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] hunter = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            hunter[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(hunter);

        PriorityQueue<int[]> animals = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (y > l) {
                continue;
            }
            animals.add(new int[]{ x - l + y, x + l - y });
        }

        int count = 0;
        int hIdx = 0;
        while (!animals.isEmpty() && hIdx < m) {
            int[] curr = animals.poll();

            while (hIdx < m && hunter[hIdx] < curr[0]) {
                hIdx++;
            }

            if (hIdx < m && hunter[hIdx] >= curr[0] && hunter[hIdx] <= curr[1]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
