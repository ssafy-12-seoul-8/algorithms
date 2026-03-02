import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] data = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int home = Integer.parseInt(st.nextToken());
            int office = Integer.parseInt(st.nextToken());

            if (home < office) {
                data[i][0] = home;
                data[i][1] = office;
                continue;
            }
            data[i][0] = office;
            data[i][1] = home;
        }

        int l = Integer.parseInt(br.readLine());

        // 선분이 x위치일때 포함되거나 제외된다
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.x));
        for (int i = 0; i < n; i++) {
            if (data[i][1] - data[i][0] > l) {
                continue;
            }
            pq.add(new Point(data[i][1], 1));
            pq.add(new Point(data[i][0] + l + 1, -1));
        }

        int max = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            int currEnd = pq.peek().x;
            while (!pq.isEmpty() && pq.peek().x == currEnd) {
                cnt += pq.poll().v;
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    private static class Point {
        int x;
        int v;

        public Point(int x, int v) {
            this.x = x;
            this.v = v;
        }
    }
}
