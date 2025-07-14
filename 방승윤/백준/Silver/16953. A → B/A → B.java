import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{B, 1});
        int len = -1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int num = curr[0];
            int cnt = curr[1];

            if (num == A) {
                len = cnt;
                break;
            }

            if (num < A) {
                continue;
            }

            if (num % 10 == 1) {
                q.add(new int[]{num / 10, cnt + 1});
            }

            if (num % 2 == 0) {
                q.add(new int[]{num / 2, cnt + 1});
            }
        }

        System.out.println(len);
    }
}