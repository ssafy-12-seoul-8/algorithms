import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] nodes;
    static ArrayDeque<Integer> stack;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            nodes = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                nodes[x].add(y);
            }

            stack = new ArrayDeque<>();
            visit = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                if (visit[i]) {
                    continue;
                }
                dfs(i);
            }

            visit = new boolean[n + 1];
            int count = 0;
            while (!stack.isEmpty()) {
                int poll = stack.poll();

                if (!visit[poll]) {
                    count++;
                    dfs2(poll);
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int n) {
        visit[n] = true;

        for (int next: nodes[n]) {
            if (!visit[next]) {
                dfs(next);
            }
        }

        stack.push(n);
    }

    public static void dfs2(int n) {
        visit[n] = true;

        for (int next: nodes[n]) {
            if (!visit[next]) {
                dfs2(next);
            }
        }
    }
}
