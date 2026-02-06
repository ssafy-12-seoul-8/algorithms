import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 마을 수
        int c = Integer.parseInt(st.nextToken()); // 트럭 용량
        int m = Integer.parseInt(br.readLine());

        int ans = 0;
        int[] space = new int[n + 1];
        Arrays.fill(space, c);
        Order[] orders = new Order[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            orders[i] = new Order(from, to, count);
        }

        Arrays.sort(orders);

        int end = 1;
        int start = 0;
        int MAX = 10000;
        int left = MAX;
        for (int i = 0; i < m; i++) {

            if (end != orders[i].to) {
                end = orders[i].to;
                start = orders[i].to - 1;
                left = MAX;
            }

            for (int j = start; j >= orders[i].from; j--) {
                left = Math.min(left, space[j]);
            }

            int go = Math.min(left, orders[i].count);
            ans += go;
            for (int j = orders[i].from; j < orders[i].to; j++) {
                    space[j] -= go;
                }
            left -= go;
        }

        System.out.println(ans);
    }

    private static class Order implements Comparable<Order> {
        int from;
        int to;
        int count;

        public Order(int from, int to, int count) {
            this.from = from;
            this.to = to;
            this.count = count;
        }

        @Override
        public int compareTo(Order o) {
            if (this.to == o.to) {
                return o.from - this.from;
            }
            return this.to - o.to;
        }
    }
}
