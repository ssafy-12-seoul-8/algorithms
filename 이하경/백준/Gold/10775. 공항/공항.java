import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        int[] parent = new int[g + 1]; // i보다 작거나같은 빈 곳
        for (int i = 1; i <= g; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < p; i++) {
            int plane = Integer.parseInt(br.readLine());
            int gate = find(parent, plane);
            if (gate == 0) {
                System.out.println(i);
                return;
            }
            union(parent, gate - 1, gate);
        }
        System.out.println(p);
    }

    static void union(int[] p, int x, int y) {
        int px = find(p, x);
        int py = find(p, y);

        p[py] = px;
    }

    static int find(int[] p, int x) {
        if (p[x] != x) {
            p[x] = find(p, p[x]);
        }
        return p[x];
    }
}
