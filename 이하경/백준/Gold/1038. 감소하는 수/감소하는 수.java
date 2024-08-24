import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Long> decNums = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n > 1022) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 10; i++) {
            makeDecNum(i);
        }
        Collections.sort(decNums);
        System.out.println(decNums.get(n));
    }

    // k의 오른쪽에 솟자를 추가해서 감소하는 수를 만든다
    static void makeDecNum (long k) {
        decNums.add(k);
        int onesPlace = (int) (k % 10);
        for (int i = 0; i < onesPlace; i++) {
            makeDecNum(k * 10 + i);
        }
    }
}
