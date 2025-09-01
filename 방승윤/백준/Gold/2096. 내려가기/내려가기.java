import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] max = new int[N + 1][3];
        int[][] min = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + a;
            max[i][1] = Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2])) + b;
            max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + c;
            min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + a;
            min[i][1] = Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2])) + b;
            min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + c;
        }

        sb.append(Math.max(max[N][0], Math.max(max[N][1], max[N][2]))).append(" ").append(Math.min(min[N][0], Math.min(min[N][1], min[N][2])));
        System.out.println(sb);
    }
}