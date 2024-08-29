import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int tmp = 0;
            while (q.peek() != target) {
                q.offer(q.poll());
                tmp++;
            }
            if (tmp > q.size() / 2) {
                cnt += q.size() - tmp;
            } else {
                cnt += tmp;
            }
            q.poll();
        }

        System.out.println(cnt);
    }
}
