import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 우선순위큐 사용해서 위상정렬
// 입력 m, 총 연산은 큐에 넣기 n번, 빼기 n번, inDegree 줄이기 m번
// nlogn와 m중 큰쪽 - nlogn = 15 * 32,000 = 1,600,000

public class Main {
    static int n, m;
    static ArrayList<Integer>[] edges;
    static int[] inDegree;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static void input() throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        inDegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a를 b보다 먼저 풀어야한다
            edges[a].add(b);
            inDegree[b]++;
        }
    }

    static void solve() {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            sb.append(curr).append(" ");

            for (int next : edges[curr]) {
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    pq.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
