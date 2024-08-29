import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            Deque<Character> stack = new ArrayDeque<>();
            String str = br.readLine();
            int len = str.length();
            for (int j = 0; j < len; j++) {
                char c = str.charAt(j);

                if (stack.isEmpty() || stack.peekFirst() != c) {
                    stack.offerFirst(c);
                } else {
                    stack.pollFirst();
                }
            }

            if (stack.isEmpty()) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
