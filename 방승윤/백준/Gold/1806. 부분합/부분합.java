import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int l = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            q.add(num);
            sum += num;

            if (sum < S) {
                continue;
            }

            while (sum >= S && S != 0) {
                sum -= q.poll();
            }

            l = Math.min(l, q.size() + 1);
        }

        System.out.println(S == 0 ? 0 : l == Integer.MAX_VALUE ? 0 : l);
    }
}