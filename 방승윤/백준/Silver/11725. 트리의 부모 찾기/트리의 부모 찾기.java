import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] p = new int[N + 1];
        List<Integer>[] tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        p[1] = 1;

        while (!q.isEmpty()) {
            int num = q.poll();

            for (int i : tree[num]) {
                if (p[i] == 0) {
                    p[i] = num;
                    q.add(i);
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            sb.append(p[i]).append("\n");
        }

        System.out.println(sb);
    }
}