import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Path> paths = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int d = Integer.parseInt(br.readLine());
            paths.add(new Path(0, i + 1, d));
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j++) {
                int d = Integer.parseInt(st.nextToken());
                paths.add(new Path(i + 1, j + 1, d));
            }
        }

        int[] p = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            p[i] = i;
        }

        int count = 0;
        int price = 0;
        while (count < n) {
            Path curr = paths.poll();
            if (union(curr.u, curr.v, p)) {
                count++;
                price += curr.d;
            }
        }

        System.out.println(price);
    }

    static int find(int x, int[] p) {
        if (p[x] == x) {
            return x;
        }
        return p[x] = find(p[x], p);
    }

    static boolean union(int x, int y, int[] p) {
        int px = find(x, p);
        int py = find(y, p);

        if (px == py) {
            return false;
        }

        if (px == 0) {
            p[py] = px;
            return true;
        }

        p[px] = py;
        return true;
    }

    private static class Path implements Comparable<Path> {
        int u;
        int v;
        int d;

        public Path(int u, int v, int d) {
            this.u = u;
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Path o) {
            return this.d - o.d;
        }
    }
}
