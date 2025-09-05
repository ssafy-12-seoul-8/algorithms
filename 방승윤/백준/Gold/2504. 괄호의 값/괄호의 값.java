import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static Stack<Object> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        for (char c : line.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                System.out.println(0);
                return;
            }

            if (c == ')') {
                if (stack.peek().equals('(')) {
                    stack.pop();
                    stack.push(2);
                    continue;
                }

                int sum = 0;

                while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                    sum += (int) stack.pop();
                }

                if (stack.isEmpty() || stack.peek().equals('[')) {
                    System.out.println(0);
                    return;
                }

                stack.pop();
                stack.push(sum * 2);
            }

            if (c == ']') {
                if (stack.peek().equals('[')) {
                    stack.pop();
                    stack.push(3);
                    continue;
                }

                int sum = 0;

                while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                    sum += (int) stack.pop();
                }

                if (stack.isEmpty() || stack.peek().equals('(')) {
                    System.out.println(0);
                    return;
                }

                stack.pop();
                stack.push(sum * 3);
            }
        }

        int answer = 0;

        while (!stack.isEmpty()) {
            if (!(stack.peek() instanceof Integer)) {
                System.out.println(0);
                return;
            }

            answer += (int) stack.pop();
        }

        System.out.println(answer);
    }
}