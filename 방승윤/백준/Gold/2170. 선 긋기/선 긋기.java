import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static class Line implements Comparable<Line> {
        int s;
        int e;

        Line(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int compareTo(Line line) {
            return this.s - line.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Line> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Line(x, y));
        }

        Line first = pq.poll();
        int s = first.s;
        int e = first.e;
        int l = e - s;

        while (!pq.isEmpty()) {
            Line curr = pq.poll();

            if (curr.e <= e) {
                continue;
            }

            if (curr.s <= e) {
                l += curr.e - e;
                e = curr.e;
                continue;
            }

            s = curr.s;
            e = curr.e;
            l += e - s;
        }

        System.out.println(l);
    }
}