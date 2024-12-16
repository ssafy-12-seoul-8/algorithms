import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x= Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] good = new ArrayList[n + 1]; // i보다 잘한 사람 모음
        ArrayList<Integer>[] bad = new ArrayList[n + 1]; // i보다 못한 사람 모음

        for (int i = 0; i < n + 1; i++) {
            good[i] = new ArrayList<>();
            bad[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            good[b].add(a);
            bad[a].add(b);
        }

        boolean[] visit = new boolean[n + 1];
        sb.append(findNum(good, visit, x)).append(" ").append(n - findNum(bad, visit, x) + 1);
        System.out.println(sb);
    }

    static int findNum(ArrayList<Integer>[] list, boolean[] visit, int x) {
        int num = 1;
        visit[x] = true;
        for (int next : list[x]) {
            if (visit[next]) {
                continue;
            }
            num += findNum(list, visit, next);
        }

        return num;
    }
}
