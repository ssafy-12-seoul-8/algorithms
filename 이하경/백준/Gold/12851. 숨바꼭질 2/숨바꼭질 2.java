import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1. i가 n보다 작으면 -1로만 이동
// 2. i의 최댓값은 i-1에서 +1 이동
// 3. n이 짝수면 2배
// 4. n이 홀수면 2배 후 +-1
// 5. -1이동의 경우는 짝수는 절대 안생김, 홀수는 +1은 2에서 했으므로 -1만 고려해주자

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (k <= n) {
            sb.append(n - k).append("\n").append(1);
            System.out.println(sb);
            return;
        }

        int[] dist = new int[100_001];
        int[] count = new int[100_001];
        
        count[n] = 1;

        for (int i = 0; i < n; i++) {
            dist[i] = n - i;
            count[i] = 1;
        }

        for (int i = n + 1; i <= k; i++) {
            dist[i] = dist[i - 1] + 1;
            count[i] = count[i - 1];

            if (i % 2 == 0) {
                if (dist[i / 2] + 1 < dist[i]) {
                    dist[i] = dist[i / 2] + 1;
                    count[i] = count[i / 2];
                    continue;
                }
                if (dist[i / 2] + 1 == dist[i]) {
                    count[i] += count[i / 2];
                }
                continue;
            }

            if (dist[i / 2 + 1] + 2 < dist[i]) {
                dist[i] = dist[i / 2 + 1] + 2;
                count[i] = count[i / 2 + 1];
                continue;
            }
            if (dist[i / 2 + 1] + 2 == dist[i]) {
                count[i] += count[i / 2 + 1];
            }
        }

        sb.append(dist[k]).append("\n").append(count[k]);
        System.out.println(sb);
    }
}
