import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] relation = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(relation[i], Integer.MAX_VALUE / 10);
            relation[i][0] = 0;
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int member1 = Integer.parseInt(st.nextToken());
            int member2 = Integer.parseInt(st.nextToken());

            if (member1 == -1) {
                break;
            }

            relation[member1][member2] = 1;
            relation[member2][member1] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) {
                        relation[i][j] = 0;
                        continue;
                    }

                    relation[i][j] = Math.min(relation[i][j], relation[i][k] + relation[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                relation[i][0] = Math.max(relation[i][0], relation[i][j]);
            }

            min = Math.min(min, relation[i][0]);
        }

        sb.append(min).append(" ");
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (relation[i][0] == min) {
                cnt++;
            }
        }

        sb.append(cnt).append("\n");

        for (int i = 1; i <= N; i++) {
            if (relation[i][0] == min) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}