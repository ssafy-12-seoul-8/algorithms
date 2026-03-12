import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Flower> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int bloomMonth = Integer.parseInt(st.nextToken());
            int bloomDay = Integer.parseInt(st.nextToken());
            int fallMonth = Integer.parseInt(st.nextToken());
            int fallDay = Integer.parseInt(st.nextToken());
            pq.add(new Flower(bloomMonth, bloomDay, fallMonth, fallDay));
        }

        int startMonth = 3;
        int startDay = 1;
        int count = 0;
        int endMonth = 0;
        int endDay = 0;

        while (!pq.isEmpty() && startMonth < 12) {
            Flower next = pq.peek();

            if (next.bloomMonth < startMonth || (next.bloomMonth == startMonth && next.bloomDay <= startDay)) {
                if (endMonth < next.fallMonth || (endMonth == next.fallMonth && endDay < next.fallDay)) {
                    endMonth = next.fallMonth;
                    endDay = next.fallDay;
                }
                pq.poll();
            } else {
                if (endMonth == 0) {
                    count = 0;
                    break;
                }
                count++;
                startMonth = endMonth;
                startDay = endDay;
                endMonth = 0;
                endDay = 0;
            }
        }

        if (endMonth != 0) {
            count++;
        }

        if (startMonth < 12 && endMonth < 12) {
            count = 0;
        }

        System.out.println(count);
    }

    private static class Flower implements Comparable<Flower> {
        int bloomMonth;
        int bloomDay;
        int fallMonth;
        int fallDay;

        public Flower(int bloomMonth, int bloomDay, int fallMonth, int fallDay) {
            this.bloomMonth = bloomMonth;
            this.bloomDay = bloomDay;
            this.fallMonth = fallMonth;
            this.fallDay = fallDay;
        }

        @Override
        public int compareTo(Flower o) {
            if (this.bloomMonth == o.bloomMonth) {
                return this.bloomDay - o.bloomDay;
            }
            return this.bloomMonth - o.bloomMonth;
        }
    }
}
