import java.io.*;
import java.util.*;

public class Main {
    static int[][] result = new int[6][3];
    static boolean possible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        tc:
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    result[j][k] = Integer.parseInt(st.nextToken());
                }
                if (result[j][0] + result[j][1] + result[j][2] != 5) {
                    sb.append(0).append(" ");
                    continue tc;
                }
            }
            possible = false;
            bt(0, 1);
            if (possible) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void bt(int c1, int c2) {
        if (possible) {
            return;
        }

        if (c2 == 6) {
            c1++;
            c2 = c1 + 1;
        }

        if (c1 == 5) {
            possible = true;
            return;
        }

        if (result[c1][0] > 0 && result[c2][2] > 0) {
            result[c1][0]--;
            result[c2][2]--;
            bt(c1, c2 + 1);
            result[c1][0]++;
            result[c2][2]++;
        }

        if (result[c1][1] > 0 && result[c2][1] > 0) {
            result[c1][1]--;
            result[c2][1]--;
            bt(c1, c2 + 1);
            result[c1][1]++;
            result[c2][1]++;
        }

        if (result[c1][2] > 0 && result[c2][0] > 0) {
            result[c1][2]--;
            result[c2][0]--;
            bt(c1, c2 + 1);
            result[c1][2]++;
            result[c2][0]++;
        }
    }
}
