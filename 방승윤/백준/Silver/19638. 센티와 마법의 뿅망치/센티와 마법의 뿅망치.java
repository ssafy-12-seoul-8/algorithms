import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int centi = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int cnt = 0;
        boolean flag = false;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < T; i++) {
            int giant = pq.poll();

            if (giant < centi) {
                flag = true;
                break;
            }

            if (giant != 1) {
                cnt++;
                giant /= 2;
            }

            pq.add(giant);
        }

        if (!flag && pq.peek() < centi) {
            flag = true;
        }

        if (flag) {
            System.out.println("YES\n" + cnt);
            return;
        }

        System.out.println("NO\n" + pq.poll());
    }
}