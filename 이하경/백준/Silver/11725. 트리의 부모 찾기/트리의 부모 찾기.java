import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] connect = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            connect[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connect[a].add(b);
            connect[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] p = new int[n + 1];
        p[1] = 1;
        q.add(1);

        while (!q.isEmpty()) {
            int parent = q.poll();

            for (int child : connect[parent]) {
                if (p[child] == 0) {
                    p[child] = parent;
                    q.add(child);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            sb.append(p[i]).append("\n");
        }

        System.out.println(sb);
    }
}
