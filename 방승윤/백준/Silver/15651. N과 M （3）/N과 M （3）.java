import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static Stack<Integer> stack;
    static StringBuilder sb = new StringBuilder();;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        stack = new Stack<>();

        recur(0, 0);

        System.out.println(sb);
    }

    public static void recur(int level, int prev) {
        if (level == M) {
            for (int num : stack) {
                sb.append(num).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            stack.add(i);
            recur(level + 1, i);
            stack.pop();
        }
    }
}