import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();

        Deque<Character> parStack = new ArrayDeque<>();
        Deque<Integer> intStack = new ArrayDeque<>();

        boolean isValid = true;
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            int tmp = 0;
            if (c == '(' || c == '[') {
                parStack.push(c);
            } else {
                while (!parStack.isEmpty() && parStack.peekFirst() == 'n') {
                    parStack.pop();
                    tmp += intStack.pop();
                }
                if (!parStack.isEmpty()) {
                    if (c == ')' && parStack.peekFirst() == '(') {
                        parStack.pop();
                        parStack.push('n');
                        intStack.push(tmp == 0 ? 2 : tmp * 2);
                        continue;
                    }
                    if (c == ']' && parStack.peekFirst() == '[') {
                        parStack.pop();
                        parStack.push('n');
                        intStack.push(tmp == 0 ? 3 : tmp * 3);
                        continue;
                    }
                }
                isValid = false;
                break;
            }
        }
        int ans = 0;
        while (!parStack.isEmpty() && parStack.peekFirst() == 'n') {
            parStack.pop();
            ans += intStack.pop();
        }
        if (!parStack.isEmpty()) {
            isValid = false;
        }
        System.out.println(isValid ? ans : 0);
    }
}
