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

        Deque<Integer> dq = new ArrayDeque<>();

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;

            while (!dq.isEmpty() && dq.peekLast() > a) {
                dq.pollLast();
            }
            dq.offerLast(a);

            if (i - l >= 0 && dq.peekFirst() == arr[i - l]) {
                dq.pollFirst();
            }

            sb.append(dq.peekFirst()).append(" ");
        }

        System.out.println(sb);

    }
}
