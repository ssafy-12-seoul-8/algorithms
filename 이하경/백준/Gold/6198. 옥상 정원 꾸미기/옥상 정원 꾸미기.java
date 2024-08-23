import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] building = new int[n];
        int[] idxStack = new int[n];
        long ans = 0;
        int stackTop = -1; // 마지막 원소가 들어있는 위치

        for (int i = 0; i < n; i++) {
            building[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            while (stackTop != -1 && building[idxStack[stackTop]] <= building[i]) {
                // stack에 든게 현재보다 작거나 같으면 현재 위치 전까지만 보임
                ans += (i - idxStack[stackTop--] - 1);
            }
            idxStack[++stackTop] = i;
        }

        while (stackTop != -1) {
            ans += (n - idxStack[stackTop--] - 1);
        }

        System.out.println(ans);

    }
}
