import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 500
        int m = Integer.parseInt(br.readLine()); // 10000

        ArrayList<Integer>[] friend = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            friend[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friend[a].add(b);
            friend[b].add(a);
        }

        boolean[] visit = new boolean[n + 1];
        int ans = friend[1].size();
        for (int fr : friend[1]) {
            visit[fr] = true;
        }
        visit[1] = true;

        for (int fr : friend[1]) {
            for (int f : friend[fr]) {
                if (!visit[f]) {
                    ans++;
                    visit[f] = true;
                }
            }
        }

        System.out.println(ans);

    }
}
