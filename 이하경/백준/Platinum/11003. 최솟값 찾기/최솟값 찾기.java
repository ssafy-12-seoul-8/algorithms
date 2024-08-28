import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<int[]> dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.peekLast()[0] > a) {
                dq.pollLast();
            }
            if (!dq.isEmpty() && dq.peekFirst()[1] <= i - l){
                dq.pollFirst();
            }
            dq.offerLast(new int[]{ a, i });

            sb.append(dq.peekFirst()[0]).append(" ");
        }

        System.out.println(sb);

    }
}
