import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] pick = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                pick[i] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;
            int[] p = new int[n + 1];
            int[] cnt = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if (p[i] == 0) { // 아직 정해지지 않은애들
                    p[i] = i;
                    cnt[i] = 1;
                    int curr = i;
                    int next = pick[i];
                    while (p[next] == 0) {
                        p[next] = i;
                        cnt[next] = cnt[curr] + 1;
                        curr = next;
                        next = pick[next];
                    }
                    // p[next]가 0이 아니래
                    if (p[next] != i) { // 다른 사이클에 도착하면
                        ans += cnt[curr];
                        continue;
                    }
                    ans += cnt[next] - 1;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
