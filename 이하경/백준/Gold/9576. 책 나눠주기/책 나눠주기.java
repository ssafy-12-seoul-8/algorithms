import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean[] used = new boolean[n + 1];
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
                for (int i = pop.start; i <= pop.end; i++) {
                    if (!used[i]) {
                        used[i] = true;
                        count++;
                        break;
                    }
                }
            }

            System.out.println(count);
        }
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
