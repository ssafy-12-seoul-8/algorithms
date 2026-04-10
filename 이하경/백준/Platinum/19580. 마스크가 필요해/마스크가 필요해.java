import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int n = fr.readInt();
        int m = fr.readInt();

        long[][] buy = new long[n][2];
        for (int i = 0; i < n; i++) {
            long l = fr.readLong();
            long r = fr.readLong();
            buy[i][0] = l;
            buy[i][1] = r;
        }
        Arrays.sort(buy, Comparator.comparingLong(a -> a[0]));

        long[][] sell = new long[m][2];
        for (int i = 0; i < m; i++) {
            long p = fr.readLong();
            long x = fr.readLong();
            sell[i][0] = p;
            sell[i][1] = x;
        }
        Arrays.sort(sell, Comparator.comparingLong(a -> a[0]));

        PriorityQueue<Long> pq = new PriorityQueue<>();
        int idx = 0;
        int count = 0;
        for (int i = 0; i < m; i++) {
            while (!pq.isEmpty() && pq.peek() < sell[i][0]) {
                pq.poll();
            }

            while (idx < n && buy[idx][0] <= sell[i][0]) {
                pq.add(buy[idx++][1]);
            }

            while (!pq.isEmpty() && pq.peek() < sell[i][0]) {
                pq.poll();
            }

            while (!pq.isEmpty() && sell[i][1] > 0) {
                pq.poll();
                sell[i][1]--;
                count++;
            }
        }

        System.out.println(count);
    }

    static class FastReader {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int readInt() throws IOException {
            int c;
            while ((c = read()) <= 32) {
                if (c == -1) return -1;
            }

            int n = c & 15;
            while ((c = read()) > 32) {
                n = (n << 3) + (n << 1) + (c & 15);
            }
            return n;
        }

        long readLong() throws IOException {
            int c;
            while ((c = read()) <= 32) {
                if (c == -1) return -1L;
            }

            long n = c & 15;
            while ((c = read()) > 32) {
                n = (n << 3) + (n << 1) + (c & 15);
            }
            return n;
        }
    }
}
