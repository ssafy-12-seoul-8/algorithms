import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());

            if (d >= 0) {
                K--;
                continue;
            }

            pq.add(-d);
        }

        if (K <= 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < K - 1; i++) {
            pq.poll();
        }

        System.out.println(pq.poll());
    }
}