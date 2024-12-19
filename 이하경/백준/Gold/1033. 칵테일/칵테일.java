import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long[] mass = new long[n];
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            mass[i] = 1;
            parent[i] = i;
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            long g = gcd(p, q);
            p /= g;
            q /= g;

            int pa = find(parent, a);
            int pb = find(parent, b);

            long scaleA = mass[b] * p;
            long scaleB = mass[a] * q;

            long g2 = gcd(scaleA, scaleB);
            scaleA /= g2;
            scaleB /= g2;

            for (int j = 0; j < n; j++) {
                if (find(parent, j) == pa) {
                    mass[j] *= scaleA;
                } else if (find(parent, j) == pb) {
                    mass[j] *= scaleB;
                }
            }

            union(parent, pa, pb);
        }

        long g = mass[0];
        for (long m : mass) {
            g = gcd(g, m);
        }

        for (long m : mass) {
            sb.append(m / g).append(" ");
        }
        System.out.println(sb);
    }

    static void union(int[] parent, int a, int b) {
        parent[b] = a;
    }

    static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
