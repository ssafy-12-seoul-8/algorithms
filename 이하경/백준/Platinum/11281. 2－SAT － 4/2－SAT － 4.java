import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] nodes;
    static ArrayList<Integer>[] revNodes;
    static ArrayDeque<Integer> stack;
    static boolean[] visit;
    static Set<Integer> scc;
    static boolean possible = true;
    static int n;
    static boolean[] bools;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int NODE = 2 * n + 1;

        nodes = new ArrayList[NODE];
        revNodes = new ArrayList[NODE];
        for (int i = 0; i < NODE; i++) {
            nodes[i] = new ArrayList<>();
            revNodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[n - a].add(n + b);
            nodes[n - b].add(n + a);
            revNodes[n + a].add(n - b);
            revNodes[n + b].add(n - a);
        }

        stack = new ArrayDeque<>();
        visit = new boolean[NODE];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                makeStack(i);
            }
        }
        for (int i = n + 1; i < NODE; i++) {
            if (!visit[i]) {
                makeStack(i);
            }
        }

        visit = new boolean[NODE];
        bools = new boolean[n + 1];
        while (!stack.isEmpty() && possible) {
            int pop = stack.pop();

            if (!visit[pop]) {
                scc = new HashSet<>();
                findScc(pop);
            }
        }

        if (possible) {
            sb.append(1).append("\n");
            for (int i = 1; i <= n; i++) {
                sb.append(bools[i] ? 1 : 0).append(" ");
            }
        } else {
            sb.append(0);
        }

        System.out.println(sb);
    }

    public static void makeStack(int curr) {
        visit[curr] = true;

        for (int next:nodes[curr]) {
            if (!visit[next]) {
                makeStack(next);
            }
        }

        stack.push(curr);
    }

    public static void findScc(int curr) {
        visit[curr] = true;
        scc.add(curr);

        if (curr > n) {
            bools[curr - n] = true;
        } else {
            bools[n - curr] = false;
        }

        if (!possible) {
            return;
        }

        for (int next: revNodes[curr]) {
            if (!visit[next]) {
                if (scc.contains(2 * n - next)) {
                    possible = false;
                    return;
                }

                findScc(next);
            }
        }
    }
}
