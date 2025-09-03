import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static int[] p;
    public static boolean[] know;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        p = new int[N + 1];
        know = new boolean[N + 1];
        int[][] parties = new int[M][];
        int knowCnt = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        for (int i = 0; i < knowCnt; i++) {
            know[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());
            parties[i] = new int[people];

            for (int j = 0; j < people; j++) {
                parties[i][j] = Integer.parseInt(st.nextToken());
                int x = find(parties[i][0]);
                int y = find(parties[i][j]);

                if (x != y) {
                    union(x, y);
                }
            }
        }

        int cnt = 0;

        one: for (int[] party : parties) {
            for (int person : party) {
                if (know[find(person)]) {
                    continue one;
                }
            }

            cnt++;
        }

        System.out.println(cnt);
    }

    public static int find(int x) {
        if (x == p[x]) {
            return p[x];
        }

        return p[x] = find(p[x]);
    }

    public static void union(int x, int y) {
       if (!know[x] && know[y]) {
           p[x] = y;
           return;
       }

       p[y] = x;
    }
}