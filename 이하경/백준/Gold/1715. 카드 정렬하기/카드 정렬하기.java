import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        long sum = 0;
        while (pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();

            int tmp = a + b;
            sum += tmp;
            pq.add(tmp);
        }

        System.out.println(sum);
    }
}
