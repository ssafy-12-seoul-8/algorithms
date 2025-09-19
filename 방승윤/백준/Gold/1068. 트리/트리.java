import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static int cnt;
    public static int bomb;
    public static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        int[] p = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
            p[i] = Integer.parseInt(st.nextToken());
        }

        int root = -1;

        for (int i = 0; i < N; i++) {
            if (p[i] == -1) {
                root = i;
                continue;
            }

            tree[p[i]].add(i);
        }

        bomb = Integer.parseInt(br.readLine());
        dfs(root);

        System.out.println(cnt);
    }

    public static void dfs(int node) {
        if (node == bomb) {
            return;
        }

        if (tree[node].isEmpty()) {
            cnt++;
            return;
        }
        
        boolean flag = false;

        for (int child : tree[node]) {
            if (child != bomb) {
                flag = true;
            }
            
            dfs(child);
        }
        
        if (!flag) {
            cnt++;
        }
    }
}