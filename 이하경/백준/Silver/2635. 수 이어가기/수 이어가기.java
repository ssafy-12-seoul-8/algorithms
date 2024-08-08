import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> maxList = makeNum(n, 1);
        int maxSize = maxList.size();

        for (int i = 2; i < n; i++) {
            List<Integer> tmpList = makeNum(n, i);
            if (tmpList.size() > maxSize) {
                maxSize = tmpList.size();
                maxList = tmpList;
            }
        }

        System.out.println(maxSize);
        StringBuilder sb = new StringBuilder();
        for (int i : maxList) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static List<Integer> makeNum (int first, int second) {
        List<Integer> num = new ArrayList<>();

        num.add(first);

        while (second >= 0) {
            num.add(second);
            int tmp = first - second;
            first = second;
            second = tmp;
        }

        return num;
    }
}
