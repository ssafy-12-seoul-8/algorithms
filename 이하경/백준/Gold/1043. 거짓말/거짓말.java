import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] p; // 유니온파인드에 사용할 부모배열
    static boolean[] know;
    static int[][] party;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        know = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());
            know[num] = true;
        }

        party = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            party[i] = new int[l];

            for (int j = 0; j < l; j++) {
                party[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        unionParty();
        cntParty();
    }

    static void unionParty() {
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        for (int i = 0; i < m; i++) { // i번 파티에 온 사람을 모두 union
            int head = party[i][0];
            for (int j = 1; j < party[i].length; j++) {
                union(head, party[i][j]);
            }
        }
    }

    static void cntParty() {
        int cnt = 0;
        for (int i = 0; i < m; i++) { // i번째 파티의 맨 앞사람이 아는지 확인
            if (!know[find(party[i][0])]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void union(int x, int y) {
        int parX = find(x);
        int parY = find(y);

        if (know[parX]) { // 둘 중 진실을 아는 사람이 부모로
            p[parY] = find(parX);
            return;
        }
        p[parX] = parY; // y가 진실을 안거나, 둘다 모른다면
    }

    static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
