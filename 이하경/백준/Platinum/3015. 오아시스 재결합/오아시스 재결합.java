import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long ans = 0;

        Deque<Person> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            int cnt = 1;
            while (!stack.isEmpty()) {
                Person prev = stack.pop();
                if (prev.height > height) {
                    stack.push(prev);
                    ans++;
                    break;
                }
                ans += prev.cnt;
                if (prev.height == height) {
                    cnt += prev.cnt;
                }
            }
            stack.push(new Person(height, cnt));
        }
        System.out.println(ans);
    }
}

class Person {
    int height;
    int cnt;

    Person(int height, int cnt) {
        this.height = height;
        this.cnt = cnt;
    }
}
