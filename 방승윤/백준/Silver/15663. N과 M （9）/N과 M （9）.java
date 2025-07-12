import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] num;
    static int[] arr;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        used = new boolean[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        recur(0);

        System.out.println(sb);
    }

    public static void recur(int level) {
        if (level == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                if (i == 0 || num[i] != num[i - 1] || used[i - 1]) {
                    arr[level] = num[i];
                    used[i] = true;
                    recur(level + 1);
                    used[i] = false;
                }
            }
        }
    }
}