import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            parent = new int[n + 2];
            for (int i = 0; i < n + 2; i++) {
                parent[i] = i;
            }
            int count = 0;

            PriorityQueue<BookRange> pq = new PriorityQueue<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                pq.add(new BookRange(start, end));
            }

            while (!pq.isEmpty()) {
                BookRange pop = pq.poll();
                int p = find(pop.start);
                if (p <= pop.end) {
                    count++;
                    parent[p] = find(p + 1);
                }
            }

            System.out.println(count);
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);

    }

    private static class BookRange implements Comparable<BookRange> {
        int start;
        int end;

        public BookRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(BookRange o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}
