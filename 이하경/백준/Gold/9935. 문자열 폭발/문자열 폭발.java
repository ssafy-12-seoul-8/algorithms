import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();

        Deque<Character> strStack = new ArrayDeque<>();

        int cnt = 0;
        for (char c : str) {
            if (cnt > 0 && c != bomb[cnt]) { // 앞에 몇개 있는데 일치 안할때
                strStack.addLast((char) cnt); // 앞에 개수 기록해주고
                cnt = 0; // 쌓인 개수 0으로
            }

            if (c != bomb[cnt]) { // 쌓인거 없는데 여기서 시작 아닐때
                strStack.addLast(c); // 그냥 넣어준다
                continue;
            }

            if (c == bomb[cnt]) { // 일치할때
                cnt++;
                if (cnt == bomb.length) { // 폭발문자열이 완성되면
                    cnt = 0; // 기본값은 0이고
                    if (!strStack.isEmpty() && strStack.peekLast() < 36) {
                        cnt = strStack.pollLast(); // 앞에 기록된 개수 있을때만 적용
                    }
                }
            }
        }

        if (cnt != 0) {
            strStack.addLast((char) cnt);
        }


        if (strStack.isEmpty()) {
            System.out.println("FRULA");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : strStack) {
            if (c < 36) {
                for (int i = 0; i < c; i++) {
                    sb.append(bomb[i]);
                }
                continue;
            }
            sb.append(c);
        }

        System.out.println(sb);
    }
}
