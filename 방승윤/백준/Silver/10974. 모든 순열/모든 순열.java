import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static Stack<Integer> stack = new Stack<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        recur(N);
        System.out.println(sb);
    }

    public static void recur(int N) {
        if (stack.size() == N) {
            for (int num : stack) {
                sb.append(num).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (stack.contains(i)) {
                continue;
            }

            stack.push(i);
            recur(N);
            stack.pop();
        }
    }
}