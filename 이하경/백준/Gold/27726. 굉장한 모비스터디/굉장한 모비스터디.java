import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int m3 = Integer.parseInt(st.nextToken());

        int[] p1 = new int[n + 1];
        for (int i = 1; i < n; i++) {
            p1[i] = i;
        }

        for (int i = 0; i < m1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a - 1, b - 1, p1);
        }

        int[] p2 = new int[n];
        for (int i = 1; i < n; i++) {
            p2[i] = i;
        }

        for (int i = 0; i < m2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a - 1, b - 1, p2);
        }

        int[] p3 = new int[n];
        for (int i = 1; i < n; i++) {
            p3[i] = i;
        }

        for (int i = 0; i < m3; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a - 1, b - 1, p3);
        }

        Map<Long, ArrayList<Integer>> group = new HashMap<>();
        long NUM = 100_000;
        long[] key = new long[n];
        for (int i = 0; i < n; i++) {
            long hash = NUM * NUM * find(i, p1) + NUM * find(i, p2) + find(i, p3);
            if (!group.containsKey(hash)) {
                group.put(hash, new ArrayList<>());
            }
            group.get(hash).add(i);
            key[i] = hash;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!group.containsKey(key[i])) {
                continue;
            }
            if (group.get(key[i]).size() <= 1) {
                group.remove(key[i]);
                continue;
            }
            count++;
            for (int num:group.get(key[i])) {
                sb.append(num + 1).append(" ");
            }
            sb.append("\n");
            group.remove(key[i]);
        }

        sb.insert(0, count + "\n");

        System.out.println(sb);
    }

    static int find(int x, int[] p) {
        if (p[x] == x) {
            return x;
        }
        return p[x] = find(p[x], p);
    }

    static void union(int x, int y, int[] p) {
        int px = find(x, p);
        int py = find(y, p);

        if (px == py) {
            return;
        }

        p[px] = py;
    }
}
