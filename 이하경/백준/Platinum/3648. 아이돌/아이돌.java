import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visit;
    static int n, m;
    static ArrayList<Integer>[] graph, revGraph;
    static ArrayDeque<Integer> stack;
    static int[] scc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String line;
        tc:
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n * 2 + 1];
            revGraph = new ArrayList[n * 2 + 1];
            for (int i = 0; i < n * 2 + 1; i++) {
                graph[i] = new ArrayList<>();
                revGraph[i] = new ArrayList<>();
            }

            graph[n - 1].add(n + 1);
            revGraph[n + 1].add(n - 1);

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[n - a].add(n + b);
                graph[n - b].add(n + a);
                revGraph[n + a].add(n - b);
                revGraph[n + b].add(n - a);
            }

            visit = new boolean[n * 2 + 1];
            stack = new ArrayDeque<>();

            for (int i = 1; i <= n; i++) {
                if (!visit[n + i]) {
                    visit[n + i] = true;
                    makeStack(n + i);
                }
                if (!visit[n - i]) {
                    visit[n - i] = true;
                    makeStack(n - i);
                }
            }

            scc = new int[n * 2 + 1];

            while (!stack.isEmpty()) {
                int curr = stack.pollFirst();

                if (visit[curr]) {
                    visit[curr] = false;
                    if (!findScc(curr, curr)) {
                        sb.append("no").append("\n");
                        continue tc;
                    }
                }
            }

            sb.append("yes").append("\n");
        }

        System.out.println(sb);
    }

    public static void makeStack(int curr) {
        for (int next : graph[curr]) {
            if (!visit[next]) {
                visit[next] = true;
                makeStack(next);
            }
        }

        stack.addFirst(curr);
    }

    public static boolean findScc(int curr, int start) {
        scc[curr] = start;

        for (int next : revGraph[curr]) {
            if (!visit[next]) {
                continue;
            }

            if (!visit[2 * n - next] && scc[2 * n - next] == start) {
                return false;
            }

            visit[next] = false;
            if (!findScc(next, start)) {
                return false;
            }
        }

        return true;
    }
}
