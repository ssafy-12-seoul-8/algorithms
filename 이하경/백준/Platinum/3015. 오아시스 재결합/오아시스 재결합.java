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
            while (!stack.isEmpty() && stack.peek().height <= height) {
                Person pop = stack.pop();
                // 나보다 같거나 작은 것들은 여러개를 다 볼 수 있다
                ans += pop.cnt;
                if (pop.height == height) {
                    // 나를 넣을때 같이 넣어주기 위해 키가 같은거 개수 세기
                    cnt += pop.cnt;
                }
            }
            // 스텍이 비지 않았다면 나보다 큰 사람 하나를 볼 수 있다
            if (!stack.isEmpty()) {
                ans++;
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
