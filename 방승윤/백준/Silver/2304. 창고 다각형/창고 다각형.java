import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static class Column implements Comparable<Column> {

        int L;
        int H;

        Column(int L, int H) {
            this.L = L;
            this.H = H;
        }

        public int compareTo(Column column) {
            return this.L - column.L;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int maxH = 0;
        int maxL = 0;
        int lastL = 0;
        PriorityQueue<Column> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            pq.add(new Column(L, H));

            if (H >= maxH) {
                maxH = H;
                maxL = L;
            }

            lastL = Math.max(lastL, L);
        }

        int area = 0;
        int curH = 0;
        int curL = 0;
        Deque<Column> deque = new ArrayDeque<>();

        while (!pq.isEmpty() && pq.peek().L <= maxL) {
            Column c = pq.poll();

            if (c.H >= curH) {
                area += (c.L - curL) * curH;
                curL = c.L;
                curH = c.H;
            }
        }

        area += curH;
        curH = 0;
        Stack<Column> stack = new Stack<>();
        stack.push(new Column(maxL, maxH));

        while (!pq.isEmpty()) {
            stack.push(pq.poll());
        }

        while (!stack.isEmpty()) {
            Column c = stack.pop();

            if (c.H >= curH) {
                area += (curL - c.L) * curH;
                curL = c.L;
                curH = c.H;
            }
        }

        System.out.println(area);
    }
}