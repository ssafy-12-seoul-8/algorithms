import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[] move = new int[46341];

        int sum = 0;

        for (int i = 1; i < 46341; i++) {
            sum += i * 2;
            move[i] = sum;
        }

        one: for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int dist = -(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));

            int L = 0;
            int R = 46340;

            while (L <= R) {
                int mid = (L + R) / 2;

                if (move[mid] > dist) {
                    R = mid - 1;
                    continue;
                }

                if (move[mid] < dist) {
                    L = mid + 1;
                    continue;
                }

                sb.append(mid * 2).append("\n");
                continue one;
            }

            sb.append(dist - move[R] > L ? R * 2 + 2 : R * 2 + 1).append("\n");
        }

        System.out.println(sb);
    }
}