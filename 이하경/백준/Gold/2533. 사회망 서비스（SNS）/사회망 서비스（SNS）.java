import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] dp1, dp2;
    static boolean[] visit;
    static ArrayList<Integer>[] friend;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dp1 = new int[n + 1]; // i번째가 얼리어댑터인 경우 필요한 얼리어댑터 수
        dp2 = new int[n + 1]; // i번째가 얼리어댑터가 아닌 경우 필요한 얼리어댑터 수
        visit = new boolean[n + 1];

        friend = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            friend[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friend[a].add(b);
            friend[b].add(a);
        }

        dfs(1);

        System.out.println(Math.min(dp1[1], dp2[1]));
    }

    // k가 루트인 트리의 최소 얼리어댑터 수 구하기
    static void dfs(int k) {
        visit[k] = true;
        dp1[k] = 1;

        for(int next : friend[k]) {
            if (!visit[next]) {
                dfs(next);
                dp1[k] += Math.min(dp1[next], dp2[next]); // k번째가 얼리어댑터라면 작은값 선택
                dp2[k] += dp1[next]; // k번째가 얼리어댑터가 아니라면 다음은 무조건 얼리어댑터여야지
            }
        }
    }
}
