import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Pool[] pools = new Pool[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pools[i] = new Pool(start, end);
        }

        Arrays.sort(pools);

        int count = 0;
        int pos = 0; // 다음 시작 지점
        for (int i = 0; i < n; i++) {
            if (pos >= pools[i].end) {
                continue;
            }
            if (pos < pools[i].start) {
                pos = pools[i].start;
            }
            int add = (int) Math.ceil(((double) pools[i].end - pos) / l);
            count += add;
            pos += l * add;
        }

        System.out.println(count);
    }

    private static class Pool implements Comparable<Pool> {
        int start;
        int end;

        public Pool(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pool o) {
            return this.start - o.start;
        }
    }
}
