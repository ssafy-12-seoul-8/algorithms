import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int h = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(st.nextToken());
            pq.add(card);
            sum += card;
        }

        while (sum - pq.peek() >= h) {
            sum -= pq.poll();
        }

        if (sum >= h) {
            sb.append(pq.size()).append("\n");
        } else {
            sb.append(-1).append("\n");
        }

        for (int i = 0; i < q; i++) {
            int card = Integer.parseInt(br.readLine());
            pq.add(card);
            sum += card;

            while (sum - pq.peek() >= h) {
                sum -= pq.poll();
            }

            if (sum >= h) {
                sb.append(pq.size()).append("\n");
            } else {
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
