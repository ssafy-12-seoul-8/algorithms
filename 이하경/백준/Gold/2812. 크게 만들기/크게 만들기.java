import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> stack = new ArrayDeque<>();

        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            int num = str.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peekLast() < num && k > 0) {
                stack.pollLast();
                k--;
            }
            stack.addLast(num);
        }

        for (int i = 0; i < k; i++) {
            stack.pollLast();
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        System.out.println(sb);
    }
}
