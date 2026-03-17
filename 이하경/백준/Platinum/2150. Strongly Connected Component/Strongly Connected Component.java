import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visit;
    static ArrayList<Integer>[] nodes;
    static ArrayList<Integer>[] revNodes;
    static ArrayDeque<Integer> stack;
    static ArrayList<ArrayList<Integer>> scc;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[v + 1];
        revNodes = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            nodes[i] = new ArrayList<>();
            revNodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a].add(b);
            revNodes[b].add(a);
        }

        visit = new boolean[v + 1];
        stack = new ArrayDeque<>();
        for (int i = 1; i <= v; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i);
            }
        }

        visit = new boolean[v + 1];
        scc = new ArrayList<>();
        while (!stack.isEmpty()) {
            int curr = stack.pollFirst();
            if (!visit[curr]) {
                visit[curr] = true;
                ArrayList<Integer> currScc = new ArrayList<>();
                scc.add(currScc);
                findScc(curr, currScc);
            }
        }

        sb.append(scc.size()).append("\n");
        for (ArrayList<Integer> sc : scc) {
            Collections.sort(sc);
        }

        Collections.sort(scc, Comparator.comparingInt(a -> a.get(0)));
        for (ArrayList<Integer> sc : scc) {
            for (int s:sc) {
                sb.append(s).append(" ");
            }
            sb.append(-1).append("\n");
        }

        System.out.println(sb);

    }

    static void dfs(int curr) {
        for (int next : nodes[curr]) {
            if (!visit[next]) {
                visit[next] = true;
                dfs(next);
            }
        }
        stack.addFirst(curr);
    }

    static void findScc(int curr, ArrayList<Integer> scc) {
        scc.add(curr);
        for (int next : revNodes[curr]) {
            if (!visit[next]) {
                visit[next] = true;
                findScc(next, scc);
            }
        }
    }
}
