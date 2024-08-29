import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] in = br.readLine().split("[\\[,\\]]");

            int head = 1; // 명렁어 시작점
            int tail = n + 1; // 끝점 다음
            boolean isReversed = false;

            int l = p.length();
            for (int i = 0; i < l; i++) {
                if (p.charAt(i) == 'R') {
                    isReversed = !isReversed;
                } else if (isReversed) {
                    tail--;
                } else {
                    head++;
                }
            }

            if (head > tail) {
                sb.append("error").append("\n");
            } else if (head == tail) {
                sb.append("[]").append("\n");
            } else {
                sb.append("[");
                if (!isReversed) {
                    for (int i = head; i < tail; i++) {
                        sb.append(in[i]).append(",");
                    }
                } else {
                    for (int i = tail - 1; i >= head; i--) {
                        sb.append(in[i]).append(",");
                    }
                }
                sb.setLength(sb.length() - 1);
                sb.append("]").append("\n");
            }

        }
        System.out.println(sb);
    }
}
