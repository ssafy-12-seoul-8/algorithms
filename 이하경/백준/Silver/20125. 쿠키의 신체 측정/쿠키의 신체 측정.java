import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        char[][] cookie = new char[n][];

        for (int i = 0; i < n; i++) {
            cookie[i] = br.readLine().toCharArray();
        }

        int hx = 0, hy = 0;

        // find head
        head:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cookie[i][j] == '*') {
                    hx = i + 1;
                    hy = j;
                    break head;
                }
            }
        }

        sb.append(hx + 1).append(" ").append(hy + 1).append("\n");

        // left arm
        int la = 0;
        for (int i = hy - 1; i >= 0; i--) {
            if (cookie[hx][i] != '*') {
                break;
            }
            la++;
        }

        // right arm
        int ra = 0;
        for (int i = hy + 1; i < n; i++) {
            if (cookie[hx][i] != '*') {
                break;
            }
            ra++;
        }

        // waist
        int w = 0;
        for (int i = hx + 1; i < n; i++) {
            if (cookie[i][hy] != '*') {
                break;
            }
            w++;
        }

        // left leg
        int ll = 0;
        for (int i = hx + w + 1; i < n; i++) {
            if (cookie[i][hy - 1] != '*') {
                break;
            }
            ll++;
        }

        // right leg
        int rl = 0;
        for (int i = hx + w + 1; i < n; i++) {
            if (cookie[i][hy + 1] != '*') {
                break;
            }
            rl++;
        }

        sb.append(la).append(" ").append(ra).append(" ").append(w).append(" ").append(ll).append(" ").append(rl);
        System.out.println(sb);
    }
}
