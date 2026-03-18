import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] nodes;
    static ArrayList<Integer>[] revNodes;
    static ArrayDeque<Integer> stack;
    static boolean[] visit;
    static int count;
    static ArrayList<Integer> ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            nodes = new ArrayList[n];
            revNodes = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new ArrayList<>();
                revNodes[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                nodes[a].add(b);
                revNodes[b].add(a);
            }

            stack = new ArrayDeque<>();
            visit = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    makeStack(i);
                }
            }

            visit = new boolean[n];
            int pop = stack.pop();
            ans = new ArrayList<>();
            count = 0;

            findScc(pop);

            visit = new boolean[n];
            dfs(pop);

            if (count == n) {
                Collections.sort(ans);
                for (int a:ans) {
                    sb.append(a).append("\n");
                }
            } else {
                sb.append("Confused").append("\n");
            }
            sb.append("\n");
            br.readLine();
        }

        System.out.println(sb);
    }

    public static void makeStack(int curr) {
        visit[curr] = true;

        for (int next : nodes[curr]) {
            if (!visit[next]) {
                makeStack(next);
            }
        }

        stack.push(curr);
    }

    public static void findScc(int curr) {
        visit[curr] = true;
        ans.add(curr);

        for (int next : revNodes[curr]) {
            if (!visit[next]) {
                findScc(next);
            }
        }
    }

    public static void dfs(int curr) {
        visit[curr] = true;
        count++;

        for (int next : nodes[curr]) {
            if (!visit[next]) {
                dfs(next);
            }
        }
    }
}
